package com.example.demo_1resume.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Profile {
    @PrimaryKey(autoGenerate = true)
    public int profileId;

    public String profileName;

    public String profileEmailId;

    public Profile() {
    }

    public Profile(String profileName, String profileEmailId) {
        this.profileName = profileName;
        this.profileEmailId = profileEmailId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileEmailId() {
        return profileEmailId;
    }

    public void setProfileEmailId(String profileEmailId) {
        this.profileEmailId = profileEmailId;
    }
}

