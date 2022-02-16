package com.piegon.Controller;

import com.piegon.DTO.TournamentDTO;
import com.piegon.DTO.TournamentWinnerDTO;
import com.piegon.Models.Category;
import com.piegon.Models.Tournament;
import com.piegon.Service.CategoryService;
import com.piegon.Service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<TournamentDTO> getAllTournament() {
        return this.tournamentService.findAllTournaments();
    }

    @GetMapping("/all")
    public List<TournamentDTO> getAllTournaments() {
        return this.tournamentService.findAllTournamentsModel();
    }

    @PostMapping("/{categoryId}")
    public TournamentDTO addTournament(@PathVariable("categoryId") Long categoryId, @RequestBody TournamentDTO tournamentDTO) {
        return this.tournamentService.addTournament(categoryId, tournamentDTO);
    }

    @GetMapping("/{categoryId}")
    public List<TournamentDTO> findTournamentByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return this.categoryService.findByCategoryId(categoryId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTournament(@PathVariable("id") Long id) {
        return this.tournamentService.deleteTournament(id);
    }

    @PutMapping("/endTournament/{tournamentId}")
    public List<TournamentWinnerDTO> endTournament(@PathVariable("tournamentId") Long tournamentId) {
        return this.tournamentService.endTournament(tournamentId);
    }

    @GetMapping("/detail/{tournamentId}")
    public  List<TournamentWinnerDTO> findDetailByTournamentId(@PathVariable("tournamentId") Long tournamentId)
    {
        return  this.tournamentService.findDetailByTournamentId(tournamentId);
    }

    @GetMapping("/latest/tournament")
    public List<TournamentWinnerDTO> findLastTournament()
    {
        return this.tournamentService.findLatestTournament();
    }


}
