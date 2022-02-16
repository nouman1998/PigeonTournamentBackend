package com.piegon.DTO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinnerDTO {

    Long participantId;
    String participantName;
    Map<Long,Long> map = new HashMap<Long,Long>();
    Boolean isWinner = Boolean.FALSE;
    Integer totalPigeons = 0;
    Integer remainingPigeons = 0;
    Integer pigeonLanded = 0;
    Integer lofted = 0;
    String tournamentName;
    String tournamentId;
    String tournamentCity;
    Date startDate;
    Date endDate;


    public TournamentWinnerDTO() {
    }

    public TournamentWinnerDTO(Long participantId, String participantName, Map<Long, Long> map) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.map = map;
    }

    public TournamentWinnerDTO(Long participantId, String participantName, Map<Long, Long> map, Boolean isWinner, Integer totalPigeons, Integer remainingPigeons, Integer pigeonLanded, Integer lofted, String tournamentName, String tournamentId, String tournamentCity, Date startDate, Date endDate) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.map = map;
        this.isWinner = isWinner;
        this.totalPigeons = totalPigeons;
        this.remainingPigeons = remainingPigeons;
        this.pigeonLanded = pigeonLanded;
        this.lofted = lofted;
        this.tournamentName = tournamentName;
        this.tournamentId = tournamentId;
        this.tournamentCity = tournamentCity;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Map<Long, Long> getMap() {
        return map;
    }

    public void setMap(Map<Long, Long> map) {
        this.map = map;
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }

    public Integer getTotalPigeons() {
        return totalPigeons;
    }

    public void setTotalPigeons(Integer totalPigeons) {
        this.totalPigeons = totalPigeons;
    }

    public Integer getRemainingPigeons() {
        return remainingPigeons;
    }

    public void setRemainingPigeons(Integer remainingPigeons) {
        this.remainingPigeons = remainingPigeons;
    }

    public Integer getPigeonLanded() {
        return pigeonLanded;
    }

    public void setPigeonLanded(Integer pigeonLanded) {
        this.pigeonLanded = pigeonLanded;
    }

    public Integer getLofted() {
        return lofted;
    }

    public void setLofted(Integer lofted) {
        this.lofted = lofted;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentCity() {
        return tournamentCity;
    }

    public void setTournamentCity(String tournamentCity) {
        this.tournamentCity = tournamentCity;
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
}
