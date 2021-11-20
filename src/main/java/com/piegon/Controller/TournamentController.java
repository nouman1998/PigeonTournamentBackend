package com.piegon.Controller;

import com.piegon.DTO.TournamentDTO;
import com.piegon.Models.Category;
import com.piegon.Models.Tournament;
import com.piegon.Service.CategoryService;
import com.piegon.Service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Tournament> getAllTournaments() {
        return this.tournamentService.findAllTournamentsModel();
    }

    @PostMapping("/{categoryId}")
    public TournamentDTO addTournament(@PathVariable("categoryId") Long categoryId, @RequestBody TournamentDTO tournamentDTO) {
        return this.tournamentService.addTournament(categoryId , tournamentDTO);
    }

    @GetMapping("/{categoryId}")
    public List<TournamentDTO> findTournamentByCategoryId(@PathVariable("categoryId") Long categoryId)
    {
        return this.categoryService.findByCategoryId(categoryId);
    }

}
