package com.piegon.DTO;
import com.piegon.Models.Participants;
import com.piegon.Models.Tournament;

import java.math.BigDecimal;
import java.util.Date;

public class PartcipantsDTO {

    Long participantId;
    String participantCity;
    String participantName;
    String participantPosition;
    String tournamentName;
    String tournamentCity;
    Date tournamentStartTime;
    Date tournamentEndTime;
    Long tournamentId;
    Integer noOfPiegons;
    BigDecimal prizeAmount;

    public String getParticipantCity() {
        return participantCity;
    }

    public void setParticipantCity(String participantCity) {
        this.participantCity = participantCity;
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

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getTournamentCity() {
        return tournamentCity;
    }

    public void setTournamentCity(String tournamentCity) {
        this.tournamentCity = tournamentCity;
    }

    public Date getTournamentStartTime() {
        return tournamentStartTime;
    }

    public void setTournamentStartTime(Date tournamentStartTime) {
        this.tournamentStartTime = tournamentStartTime;
    }

    public Date getTournamentEndTime() {
        return tournamentEndTime;
    }

    public void setTournamentEndTime(Date tournamentEndTime) {
        this.tournamentEndTime = tournamentEndTime;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Integer getNoOfPiegons() {
        return noOfPiegons;
    }

    public void setNoOfPiegons(Integer noOfPiegons) {
        this.noOfPiegons = noOfPiegons;
    }

    public BigDecimal getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(BigDecimal prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public void populateDTO(Participants participants)
    {
        if(participants.getParticipantId() != null)
        {
            this.participantId = participants.getParticipantId();
        }

        this.participantName = participants.getParticipantName();
        this.participantCity = participants.getParticipantCity();

        if(participants.getTournament() != null)
        {
            this.tournamentName = participants.getTournament().getTournamentName();
            this.tournamentCity = participants.getTournament().getCity();
            this.tournamentEndTime = participants.getTournament().getTournamentEndTime();
            this.tournamentStartTime = participants.getTournament().getTournamentStartTime();
            this.tournamentId = participants.getTournament().getTournamentId();
        }

        if(participants.getPrizeMoney() != null)
        {
            this.prizeAmount = participants.getPrizeMoney();
        }
    }

    public Participants populateDomainObject()
    {
        Participants  participants = new Participants();
        if(this.participantId != null)
        {
            participants.setParticipantId(this.participantId);
        }
        participants.setParticipantName(this.participantName);
        if(this.prizeAmount != null)
        {
            participants.setPrizeMoney(this.prizeAmount);
        }
        participants.setParticipantPosition(this.participantPosition);
        participants.setParticipantCity(this.participantCity);
        if(this.tournamentId != null)
        {
            Tournament tournament = new Tournament();
            tournament.setTournamentId(this.tournamentId);
            participants.setTournament(tournament);
        }

        return participants;
    }


}

