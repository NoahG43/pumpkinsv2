package com.keyin.pumpkinsv2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tournament {
    @Id
    @SequenceGenerator(name = "tour_sequence", sequenceName = "tour_sequence", allocationSize = 1, initialValue=10)
    @GeneratedValue(generator = "tour_sequence")
    private int id;
    private String startDate;
    private String endDate;
    private String location;
    private String entryFee;
    private String cashPrize;

    public Tournament(){

    }

    public Tournament(String startDate, String endDate, String location, String entryFee, String cashPrize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public String getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(String cashPrize) {
        this.cashPrize = cashPrize;
    }

}
