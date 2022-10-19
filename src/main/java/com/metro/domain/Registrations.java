package com.metro.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registrations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    // @ManyToOne
    // Customer customer;

    @Column(name = "EVENT_ID")
    String event_id;

    @Column(name = "CUSTOMER_ID")
    String customer_id;

    @Column(name = "REGISTRATION_DATE")
    Date registration_date;

    @Column(name = "NOTES")
    String notes;

    public Registrations() {
        // Default constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
