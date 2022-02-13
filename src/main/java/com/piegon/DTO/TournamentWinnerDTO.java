package com.piegon.DTO;

import java.util.HashMap;
import java.util.Map;

public class TournamentWinnerDTO {

    Long participantId;
    String participantName;
    Map<Long,Long> map = new HashMap<Long,Long>();
    Boolean isWinner = Boolean.FALSE;

    public TournamentWinnerDTO() {
    }

    public TournamentWinnerDTO(Long participantId, String participantName, Map<Long, Long> map) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.map = map;
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
}
