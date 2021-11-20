package com.piegon.Service;

import com.piegon.DTO.PartcipantsDTO;
import com.piegon.Models.Participants;
import com.piegon.Models.Pigeon;
import com.piegon.Models.Tournament;
import com.piegon.Repository.ParticipantsRepository;
import com.piegon.Repository.PigeonRepository;
import com.piegon.Repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParticipantsService {

    @Autowired
    ParticipantsRepository participantsRepository;
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    PigeonRepository pigeonRepository;


    public List<PartcipantsDTO> findAllParticipants() {
        PartcipantsDTO partcipantsDTO;
        List<PartcipantsDTO> partcipantsDTOS = new ArrayList<>();
        try {
            List<Participants> participants = this.participantsRepository.findAll();
            if (participants != null && participants.size() > 0) {
                for (Participants domain : participants) {
                    partcipantsDTO = new PartcipantsDTO();
                    partcipantsDTO.populateDTO(domain);
                    partcipantsDTOS.add(partcipantsDTO);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return partcipantsDTOS;

    }

    public PartcipantsDTO addParticipant(Long tournamentId, PartcipantsDTO partcipantsDTO) {

        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        if (tournamentOptional.isPresent()) {
            Set<Pigeon> pigeons = new HashSet<>();
            Pigeon pigeon;
            partcipantsDTO.setTournamentId(tournamentId);
            Participants participants = partcipantsDTO.populateDomainObject();


            Participants participants1 = this.participantsRepository.save(participants);

            for (int i = 0; i < partcipantsDTO.getNoOfPiegons(); i++) {
                pigeon = new Pigeon();
                pigeon.setLanded(Boolean.FALSE);
                pigeon.setStartDate(tournamentOptional.get().getTournamentStartTime());
                pigeon.setEndDate(null);
                pigeon.setParticipants(participants1);
                pigeons.add(pigeon);
            }
            pigeonRepository.saveAll(pigeons);

        }
        return partcipantsDTO;
    }
}
