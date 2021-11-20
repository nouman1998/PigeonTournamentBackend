package com.piegon.Models;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Table(name = "TOURNAMENT")
@Entity
public class Tournament implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Long tournamentId;

    @Column(name = "tournament_name")
    private String tournamentName;

    @Column(name = "tournament_status")
    private String tournamentStatus;

    @Column(name = "create_date_time")
    private Date date;

    @Column(name = "tournament_winner")
    private Long tournamentWinner;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy="tournament")
    private Set<Participants> participants;


    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Column(name="tournament_start_time")
    Date tournamentStartTime;
    @Column(name="tournament_end_time")
    Date tournamentEndTime;

    private final static long serialVersionUID = 705302529926327994L;

    public Tournament() {
    }


    public Tournament(Long tournamentId, String tournamentName, String tournamentStatus, Date date, Long tournamentWinner, String city) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.tournamentStatus = tournamentStatus;
        this.date = date;
        this.tournamentWinner = tournamentWinner;
        this.city = city;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTournamentWinner() {
        return tournamentWinner;
    }

    public void setTournamentWinner(Long tournamentWinner) {
        this.tournamentWinner = tournamentWinner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participants> participants) {
        this.participants = participants;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
