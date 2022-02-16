package com.piegon.Repository;

import com.piegon.Models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament , Long> {

    @Modifying
    @Transactional
    @Query(value = "update tournament set tournament_winner = :winnerId where tournament_id = :tournamentId",nativeQuery = true)
    public  void updateTournamentWinner(@Param("winnerId") Long winnerId ,@Param("tournamentId") Long tournamentId);

    @Query(value = "SELECT * FROM tournament ORDER BY  create_date_time DESC")
    Optional<Tournament> findLastTournament();
}
