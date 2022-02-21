
package com.piegon.Service;

import com.piegon.DTO.TournamentDTO;
import com.piegon.DTO.TournamentWinnerDTO;
import com.piegon.Models.Category;
import com.piegon.Models.Participants;
import com.piegon.Models.Pigeon;
import com.piegon.Models.Tournament;
import com.piegon.Repository.CategoryRepository;
import com.piegon.Repository.TournamentRepository;
import org.hibernate.boot.jaxb.internal.InputStreamXmlSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<TournamentDTO> findAllTournaments() {
        TournamentDTO tournamentDTO;
        List<TournamentDTO> tournamentDTOS = new ArrayList<>(0);
        try {

            List<Tournament> tournaments = this.tournamentRepository.findAll();
            if (tournaments != null && tournaments.size() > 0) {

                for (Tournament tournament : tournaments) {
                    tournamentDTO = new TournamentDTO();
                    tournamentDTO.populateDTO(tournament);
                    tournamentDTOS.add(tournamentDTO);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return tournamentDTOS;

    }

    public List<TournamentDTO> findAllTournamentsModel() {
        TournamentDTO tournamentDTO;
        List<TournamentDTO> tournamentDTOS = new ArrayList<>(0);
        List<Tournament> tournaments = new ArrayList<>();
        try {

            tournaments = this.tournamentRepository.findAll();
            if (tournaments != null && tournaments.size() > 0) {

                for (Tournament tournament : tournaments) {
                    tournamentDTO = new TournamentDTO();
                    tournamentDTO.populateDTO(tournament);
                    tournamentDTOS.add(tournamentDTO);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return tournamentDTOS;

    }

    public TournamentDTO addTournament(Long categoryId, TournamentDTO tournamentDTO) {
        try {
            if (this.categoryRepository.findById(categoryId).isPresent()) {
                TournamentDTO newDTO = new TournamentDTO();
                Category category = new Category();
                category.setCategoryId(categoryId);
                Tournament tournament = tournamentDTO.populateDomainObject(tournamentDTO);
                if (tournament != null && !ObjectUtils.isEmpty(tournament)) {
                    tournament.setCategory(category);
                    tournamentRepository.save(tournament);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tournamentDTO;
    }


    public ResponseEntity deleteTournament(Long id) {
        try {
            Tournament t = this.tournamentRepository.findById(id).get();
            this.tournamentRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<TournamentWinnerDTO> endTournament(Long tournamentId) {

        try {

            Optional<Tournament> tournamentOptional = this.tournamentRepository.findById(tournamentId);
            List<TournamentWinnerDTO> tournamentWinnerDTOS = new ArrayList<>(0);
            if (tournamentOptional.isPresent()) {

                Tournament t = tournamentOptional.get();
                List<Participants> participants = t.getParticipants();

                TournamentWinnerDTO tournamentWinnerDTO = null;

                for (Participants participant : participants) {
                    Long totalHoursOfParticipant = 0l;
                    tournamentWinnerDTO = new TournamentWinnerDTO();
                    tournamentWinnerDTO.setParticipantName(participant.getParticipantName());
                    tournamentWinnerDTO.setParticipantId(participant.getParticipantId());

                    Map<Long, Long> totalHours = new HashMap<>();
                    Set<Pigeon> pigeons = participant.getPigeons();
                    pigeons.stream().forEach(pigeon -> {
                        if (pigeon != null && pigeon.getStartDate() != null && pigeon.getEndDate() != null) {
                            Long diff = pigeon.getEndDate().getTime() - pigeon.getStartDate().getTime();
                            totalHours.put(pigeon.getPigeonId(), TimeUnit.MILLISECONDS.toSeconds(diff));

                        }
                    });

                    tournamentWinnerDTO.setMap(totalHours);
                    tournamentWinnerDTOS.add(tournamentWinnerDTO);


                }


            }
            Map<Long, Integer> winner = new HashMap<>();
            tournamentWinnerDTOS.forEach(tournamentWinnerDTO -> {
                Integer sum = 0;
                for (Map.Entry<Long, Long> entry : tournamentWinnerDTO.getMap().entrySet()) {
                    sum += entry.getValue().intValue();
                }
                winner.put(tournamentWinnerDTO.getParticipantId(), sum);
            });

            Map<Long, Integer> sortedMap = winner.entrySet().
                    stream().
                    sorted(Map.Entry.comparingByValue()).
                    collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            System.out.println(sortedMap);
            Long id = (Long) sortedMap.keySet().toArray()[sortedMap.size() - 1];
            this.tournamentRepository.updateTournamentWinner(id, tournamentId);
            for (TournamentWinnerDTO tournamentWinnerDTO : tournamentWinnerDTOS) {
                if (tournamentWinnerDTO.getParticipantId() == id) {
                    tournamentWinnerDTO.setWinner(Boolean.TRUE);
                }
            }
            return tournamentWinnerDTOS;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public List<TournamentWinnerDTO> findDetailByTournamentId(Long tournamentId) {

        try {

            Optional<Tournament> tournamentOptional = this.tournamentRepository.findById(tournamentId);
            List<TournamentWinnerDTO> tournamentWinnerDTOS = new ArrayList<>(0);
            if (tournamentOptional.isPresent()) {

                Tournament t = tournamentOptional.get();
                List<Participants> participants = t.getParticipants();

                TournamentWinnerDTO tournamentWinnerDTO = null;

                for (Participants participant : participants) {

                    AtomicReference<Integer> remainingPigeons = new AtomicReference<Integer>();
                    remainingPigeons.set(0);

                    Long totalHoursOfParticipant = 0l;
                    tournamentWinnerDTO = new TournamentWinnerDTO();
                    tournamentWinnerDTO.setTournamentCity(t.getCity());
                    tournamentWinnerDTO.setTournamentName(t.getTournamentName());
                    tournamentWinnerDTO.setEndDate(t.getTournamentEndTime());
                    tournamentWinnerDTO.setStartDate(t.getTournamentStartTime());
                    tournamentWinnerDTO.setParticipantName(participant.getParticipantName());
                    tournamentWinnerDTO.setParticipantId(participant.getParticipantId());
                    tournamentWinnerDTO.setTotalPigeons(participants.size() * t.getCategory().getNoOfPigeons());
                    tournamentWinnerDTO.setLofted(participants.size());

                    Map<Long, Long> totalHours = new HashMap<>();
                    Set<Pigeon> pigeons = participant.getPigeons();
                    pigeons.stream().forEach(pigeon -> {
                        if (pigeon != null && pigeon.getStartDate() != null && pigeon.getEndDate() != null) {
                            Long diff = pigeon.getEndDate().getTime() - pigeon.getStartDate().getTime();
                            totalHours.put(pigeon.getPigeonId(), TimeUnit.MILLISECONDS.toSeconds(diff));

                        } else {
                            remainingPigeons.set(remainingPigeons.get() + 1);
                            ;
                        }

                    });

                    tournamentWinnerDTO.setRemainingPigeons(remainingPigeons.get());
                    tournamentWinnerDTO.setMap(totalHours);
                    tournamentWinnerDTOS.add(tournamentWinnerDTO);


                }
                if(participants.size()>0)
                {
                	
                	Map<Long, Integer> winner = new HashMap<>();
                    tournamentWinnerDTOS.forEach(tournamentWinnerDTO1 -> {
                        Integer sum = 0;
                        for (Map.Entry<Long, Long> entry : tournamentWinnerDTO1.getMap().entrySet()) {
                            sum += entry.getValue().intValue();
                        }
                        winner.put(tournamentWinnerDTO1.getParticipantId(), sum);
                    });

                    Map<Long, Integer> sortedMap = winner.entrySet().
                            stream().
                            sorted(Map.Entry.comparingByValue()).
                            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                    System.out.println(sortedMap);
                    Long id = (Long) sortedMap.keySet().toArray()[sortedMap.size() - 1];
                    this.tournamentRepository.updateTournamentWinner(id, tournamentId);
                    for (TournamentWinnerDTO tournamentWinnerDTO2 : tournamentWinnerDTOS) {
                        if (tournamentWinnerDTO2.getParticipantId() == id) {
                            tournamentWinnerDTO2.setWinner(Boolean.TRUE);
                        }
                    }
                }
                    

            }
           
            return tournamentWinnerDTOS;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public List<TournamentWinnerDTO> findLatestTournament() {

        List<TournamentWinnerDTO> empty = new ArrayList<>(0);
        Optional<Tournament> t = this.tournamentRepository.findLastTournament();
        if(t.isPresent())
        {
            return this.findDetailByTournamentId(t.get().getTournamentId());
        }
        else {
            return empty;
        }

    }
}
