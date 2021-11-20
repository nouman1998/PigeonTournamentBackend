package com.piegon.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "participants")
public class Participants {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "participant_name")
    String participantName;

    @Column(name = "participant_position")
    String participantPosition;

    @Column(name = "participant_city")
    String participantCity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="tournament_id", nullable=false)
    private Tournament tournament;

    @OneToMany(mappedBy="participants")
    private Set<Pigeon> pigeons;



    public Participants() {
    }

    public Participants(Long participantId, String participantName, String participantPosition, String participantCity, Tournament tournament, Set<Pigeon> pigeons) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.participantPosition = participantPosition;
        this.participantCity = participantCity;
        this.tournament = tournament;
        this.pigeons = pigeons;

    }



    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantPosition() {
        return participantPosition;
    }

    public void setParticipantPosition(String participantPosition) {
        this.participantPosition = participantPosition;
    }

    public String getParticipantCity() {
        return participantCity;
    }

    public void setParticipantCity(String participantCity) {
        this.participantCity = participantCity;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Set<Pigeon> getPigeons() {
        return pigeons;
    }

    public void setPigeons(Set<Pigeon> pigeons) {
        this.pigeons = pigeons;
    }


}
