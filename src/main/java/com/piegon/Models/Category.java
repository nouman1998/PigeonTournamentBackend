package com.piegon.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @JsonIgnore
    @OneToMany(mappedBy="category")
    private Set<Tournament> tournaments;

    String categoryName;

    @Column(name = "TOTAL_PIGEONS")
    Integer noOfPigeons;
    public Category() {
    }

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }


    public Integer getNoOfPigeons() {
        return noOfPigeons;
    }

    public void setNoOfPigeons(Integer noOfPigeons) {
        this.noOfPigeons = noOfPigeons;
    }
}
