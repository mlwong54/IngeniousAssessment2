package com.example.Assessment2.Entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date recordDatetime;

    private int numGainers;

    private int numLosers;

    // Constructors
    public Stock() {}

    public Stock(Date recordDatetime, int numGainers, int numLosers) {
        this.recordDatetime = recordDatetime;
        this.numGainers = numGainers;
        this.numLosers = numLosers;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return recordDatetime;
    }

    public void setDatetime(Date recordDatetime) {
        this.recordDatetime = recordDatetime;
    }

    public int getNumGainers() {
        return numGainers;
    }

    public void setNumGainers(int numGainers) {
        this.numGainers = numGainers;
    }

    public int getNumLosers() {
        return numLosers;
    }

    public void setNumLosers(int numLosers) {
        this.numLosers = numLosers;
    }

}
