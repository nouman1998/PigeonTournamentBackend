package com.piegon.DTO;

import java.util.Date;

public class UpdatePigeonTimeDTO {
    Date startTime;
    Date endTime;
    Long participantId;

    public UpdatePigeonTimeDTO() {
    }

    public UpdatePigeonTimeDTO(Date startTime, Date endTime, Long participantId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.participantId = participantId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }
}
