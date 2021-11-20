package com.piegon.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Pigeon")
public class Pigeon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pigeon_id")
    private Long pigeonId;

//    @ManyToOne
//    @JoinColumn(name="tournament_id", nullable=false)
//    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name="participant_id", nullable=false)
    private Participants participants;
    Date startDate;
    Date endDate;
    boolean landed;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isLanded() {
        return landed;
    }

    public void setLanded(boolean landed) {
        this.landed = landed;
    }

    public Long getPigeonId() {
        return pigeonId;
    }

    public void setPigeonId(Long pigeonId) {
        this.pigeonId = pigeonId;
    }

    public Participants getParticipants() {
        return participants;
    }

    public void setParticipants(Participants participants) {
        this.participants = participants;
    }
}
