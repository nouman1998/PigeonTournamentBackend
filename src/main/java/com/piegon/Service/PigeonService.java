package com.piegon.Service;

import com.piegon.DTO.PigeonDTO;
import com.piegon.DTO.UpdatePigeonTimeDTO;
import com.piegon.Models.Pigeon;
import com.piegon.Repository.PigeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class PigeonService {

    @Autowired
    PigeonRepository pigeonRepository;


    public List<PigeonDTO> findByParticipantId(Long participantId)
    {
      List<Pigeon> list =  this.pigeonRepository.findByParticipantId(participantId);
        PigeonDTO pigeonDTO = null;
        List<PigeonDTO> pigeonDTOList = new ArrayList<>(0);
        if(!list.isEmpty())
        {
            for (Pigeon pigeon : list)
            {
                pigeonDTO = new PigeonDTO();
                pigeonDTO.populateDTO(pigeon);
                pigeonDTOList.add(pigeonDTO);

            }

        }
     return pigeonDTOList;

    }

    public void updatePigeonTime(Long pigeonId, UpdatePigeonTimeDTO updatePigeonTimeDTO) {
        try{
            Optional<Pigeon> optionalPigeon = this.pigeonRepository.findById(pigeonId);
            if(optionalPigeon.isPresent())
            {
                Pigeon p = optionalPigeon.get();
                p.setStartDate(updatePigeonTimeDTO.getStartTime());
                p.setEndDate(updatePigeonTimeDTO.getEndTime());
                this.pigeonRepository.save(p);
            }
        }catch (Exception e )
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
