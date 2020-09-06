package com.example.demo_1resume.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.demo_1resume.entities.PersonalDetails;
import com.example.demo_1resume.entities.Profile;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface ResumeMakerDao {

    @Insert
    void insertProfile(Profile profile);

    @Insert
    void insertPersonalDetails(PersonalDetails personalDetails);

    @Query("SELECT * FROM Profile ORDER BY profileName ASC")
    LiveData<List<Profile>> getAllProfile();

    @Query("SELECT * FROM PersonalDetails ")
    LiveData<PersonalDetails> getPersonalDetailsOfProfile();

    @Update
    void updatePersonalDetails(PersonalDetails personalDetails);

}
