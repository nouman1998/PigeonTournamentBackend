package com.piegon.Controller;

import com.piegon.DTO.PigeonDTO;
import com.piegon.DTO.UpdatePigeonTimeDTO;
import com.piegon.Models.Pigeon;
import com.piegon.Service.PigeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pigeon")
@CrossOrigin("*")
public class PigeonController {

    @Autowired
    PigeonService pigeonService;


    @GetMapping("/{participantId}")
    public java.util.List<PigeonDTO> getByParticipantId(@PathVariable("participantId") Long id) {
        return this.pigeonService.findByParticipantId(id);
    }

    @PutMapping("/update/{pigeonId}")
    public void updatePigeonTime(@PathVariable("pigeonId") Long pigeonId, @RequestBody UpdatePigeonTimeDTO updatePigeonTimeDTO) {
        this.pigeonService.updatePigeonTime(pigeonId, updatePigeonTimeDTO);
    }


}
