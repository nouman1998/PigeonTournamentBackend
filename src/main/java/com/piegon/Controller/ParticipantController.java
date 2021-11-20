package com.piegon.Controller;

import com.piegon.DTO.PartcipantsDTO;
import com.piegon.Service.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    ParticipantsService  participantsService;

    @GetMapping("/")
    public List<PartcipantsDTO> findAllParticipants(){
        return this.participantsService.findAllParticipants();
    }

    @PostMapping("/{tournamentId}")
    public PartcipantsDTO addParticipant(@PathVariable("tournamentId") Long tournamentId , @RequestBody PartcipantsDTO partcipantsDTO)
    {
        return this.participantsService.addParticipant(tournamentId, partcipantsDTO);
    }
}
