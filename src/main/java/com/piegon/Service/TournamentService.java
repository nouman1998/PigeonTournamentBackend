
package com.piegon.Service;

import com.piegon.DTO.TournamentDTO;
import com.piegon.Models.Category;
import com.piegon.Models.Tournament;
import com.piegon.Repository.CategoryRepository;
import com.piegon.Repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

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

    public List<Tournament> findAllTournamentsModel() {
//        TournamentDTO tournamentDTO;
//        List<TournamentDTO> tournamentDTOS = new ArrayList<>(0);
        List<Tournament> tournaments = new ArrayList<>();
        try {

            tournaments = this.tournamentRepository.findAll();
//            if (tournaments != null && tournaments.size() > 0) {
//
//                for (Tournament tournament : tournaments) {
//                    tournamentDTO = new TournamentDTO();
//                    tournamentDTO.populateDTO(tournament);
//                    tournamentDTOS.add(tournamentDTO);
//                }
//            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return tournaments;

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


}
