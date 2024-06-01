package com.life.support.sehat.models.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;
    private String email;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Contact contact;
    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
