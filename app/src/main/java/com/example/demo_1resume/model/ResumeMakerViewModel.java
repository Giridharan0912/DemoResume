package com.example.demo_1resume.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.demo_1resume.entities.PersonalDetails;
import com.example.demo_1resume.entities.Profile;
import com.example.demo_1resume.util.Repository;

import java.util.List;

public class ResumeMakerViewModel extends AndroidViewModel {
    public Repository repository;
    public LiveData<List<Profile>> allProfilesList;
    public LiveData<PersonalDetails> personalDetailsLiveData;
    public ResumeMakerViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        allProfilesList=repository.getAllProfiles();
        personalDetailsLiveData=repository.getPersonalDetails();

    }
    public void insertProfile(Profile profile){
        repository.insertProfile(profile);
    }
    public void insertPersonalDetailForProfile(PersonalDetails personalDetails){
        repository.insertPersonalDetails(personalDetails);
    }

    public LiveData<List<Profile>> getAllProfilesList() {
        return allProfilesList;
    }
    public LiveData<PersonalDetails> getPersonalDetails(){
        return personalDetailsLiveData;
    }
}
