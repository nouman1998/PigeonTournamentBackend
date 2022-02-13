package com.piegon.DTO;

import com.piegon.Models.Participants;
import com.piegon.Models.Pigeon;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class PigeonDTO {

    private Long pigeonId;
    private String participantName;
    private Date startDate;
    private Date endDate;
    private Boolean landed;
    private Long partcipantId;


    public PigeonDTO() {
    }

    public PigeonDTO(Long pigeonId, String participantName, Date startDate, Date endDate, Boolean landed) {
        this.pigeonId = pigeonId;
        this.participantName = participantName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.landed = landed;
    }

    public PigeonDTO(Long pigeonId, String participantName, Date startDate, Date endDate, Boolean landed, Long partcipantId) {
        this.pigeonId = pigeonId;
        this.participantName = participantName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.landed = landed;
        this.partcipantId = partcipantId;
    }

    public Long getPigeonId() {
        return pigeonId;
    }

    public void setPigeonId(Long pigeonId) {
        this.pigeonId = pigeonId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

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

    public Boolean getLanded() {
        return landed;
    }

    public void setLanded(Boolean landed) {
        this.landed = landed;
    }

    public Long getPartcipantId() {
        return partcipantId;
    }

    public void setPartcipantId(Long partcipantId) {
        this.partcipantId = partcipantId;
    }

    public Pigeon populateDomainObject()
    {
        Pigeon pigeon = new Pigeon();
        pigeon.setPigeonId(this.pigeonId);
        pigeon.setStartDate(this.startDate);
        pigeon.setEndDate(this.endDate);
        pigeon.setLanded(this.landed);

        if(this.partcipantId != null)
        {
            Participants participants = new Participants();
            participants.setParticipantId(this.partcipantId);
            pigeon.setParticipants(participants);
        }
            return pigeon;
    }

    public void populateDTO(Pigeon domain)
    {
        if(domain.getPigeonId() != null)
        {
            this.pigeonId = domain.getPigeonId();
        }
        this.startDate = domain.getStartDate();
        this.endDate = domain.getEndDate();
        this.landed = domain.isLanded();
        if(domain.getParticipants() != null)
        {
            this.partcipantId = domain.getParticipants().getParticipantId();
            this.participantName = domain.getParticipants().getParticipantName();
        }
    }
}
