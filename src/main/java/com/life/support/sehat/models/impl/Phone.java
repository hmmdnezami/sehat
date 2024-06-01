package com.life.support.sehat.models.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;
    private long phone;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Contact contact;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
