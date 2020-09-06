package com.example.demo_1resume.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class PersonalDetails {
    @PrimaryKey(autoGenerate = true)
    public int personalDetailsId;
    public int profileId;
    public String fullName;
    public String emailId;
    public String phoneNumber;
    public String address;
    public String linkedIn;
    @Ignore
    public PersonalDetails(int profileId) {
        this.profileId = profileId;
    }

    public PersonalDetails(int profileId, String fullName, String emailId, String phoneNumber, String address, String linkedIn) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.linkedIn = linkedIn;
    }

    public int getPersonalDetailsId() {
        return personalDetailsId;
    }

    public void setPersonalDetailsId(int personalDetailsId) {
        this.personalDetailsId = personalDetailsId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
}
