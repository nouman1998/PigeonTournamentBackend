package com.piegon.DTO;

import com.piegon.Models.Category;
import com.piegon.Models.Tournament;

import java.util.Date;

public class TournamentDTO {

    Long tournamentId;
    String tournamentCity;
    Date createDateTime;
    String tournamentName;
    String tournamentStatus;
    Long tournamentWinner;
    String categoryName;
    Long categoryId;
    Date tournamentStartTime;
    Date tournamentEndTime;

    public TournamentDTO() {
    }

    public String getTournamentCity() {
        return tournamentCity;
    }

    public void setTournamentCity(String tournamentCity) {
        this.tournamentCity = tournamentCity;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getTournamentStatus() {
        return tournamentStatus;
    }

    public void setTournamentStatus(String tournamentStatus) {
        this.tournamentStatus = tournamentStatus;
    }

    public Long getTournamentWinner() {
        return tournamentWinner;
    }

    public void setTournamentWinner(Long tournamentWinner) {
        this.tournamentWinner = tournamentWinner;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void populateDTO(Tournament tournament) {
        this.tournamentId = tournament.getTournamentId();
        this.tournamentCity = tournament.getCity();
        this.tournamentName = tournament.getTournamentName();

        if (tournament != null && tournament.getCategory() != null) {
            this.categoryId = tournament.getCategory().getCategoryId();
            this.categoryName = tournament.getCategory().getCategoryName();
        }

        if (tournament != null && tournament.getTournamentWinner() != null) {
            this.tournamentWinner = tournament.getTournamentWinner();
        }

        this.tournamentStartTime= tournament.getTournamentStartTime();
        this.tournamentEndTime = tournament.getTournamentEndTime();
        this.createDateTime = tournament.getDate();

    }

    public Tournament populateDomainObject(TournamentDTO tournamentDTO) {
        Tournament tournament = new Tournament();

        if (tournamentDTO != null && tournamentDTO.getTournamentId() != null) {
            tournament.setTournamentId(tournamentDTO.getTournamentId());
        }
        tournament.setTournamentName(tournamentDTO.getTournamentName());
        tournament.setTournamentStatus(tournamentDTO.getTournamentStatus());
        if (tournamentDTO != null && tournamentDTO.getCategoryId() != null) {
            Category category = new Category();
            category.setCategoryId(tournamentDTO.getCategoryId());
            tournament.setCategory(category);
        }
        tournament.setTournamentWinner(tournamentDTO.getTournamentWinner());
        tournament.setDate(tournamentDTO.createDateTime);
        tournament.setTournamentStatus(tournamentDTO.getTournamentStatus());
        tournament.setCity(tournamentDTO.tournamentCity);
        tournament.setTournamentStartTime(tournamentDTO.getTournamentStartTime());
        tournament.setTournamentEndTime(tournamentDTO.getTournamentEndTime());
        return  tournament;

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
}
