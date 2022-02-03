package com.hs.basicauth.user;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}, name = "UNIQUE_ID"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "biginit unsigned")
    int id;
    @Column(name = "fname")
    String firstname;
    @Column(name = "lname")
    String lastname;
    @Column(name = "email",unique = true)
    String email;
    @Column(name = "phone")
    String phone;
    @Column(name = "password")
    String password;
    @Column(name = "dob")
    Timestamp dob;
    @Column(name = "profile")
    String profile;
    @Column(name = "address")
    String address;
    @Column(name = "role")
    int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
