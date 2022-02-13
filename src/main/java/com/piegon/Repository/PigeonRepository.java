package com.piegon.Repository;

import com.piegon.Models.Pigeon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PigeonRepository extends JpaRepository<Pigeon, Long> {
   @Query(value = "select * from pigeon where participant_id = :participantId",nativeQuery = true)
    List<Pigeon> findByParticipantId(@Param("participantId") Long participantId);
}
