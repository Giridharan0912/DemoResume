package com.example.demo_1resume.util;

import android.app.Application;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.demo_1resume.database.ResumeMakerDao;
import com.example.demo_1resume.database.ResumeMakerDatabase;
import com.example.demo_1resume.entities.PersonalDetails;
import com.example.demo_1resume.entities.Profile;

import java.util.List;

import io.reactivex.Completable;


public class Repository  {

    public ResumeMakerDatabase resumeMakerDatabase;
    public ResumeMakerDao resumeMakerDao;
    public LiveData<List<Profile>> profileListLivedata;
    public LiveData<PersonalDetails> personalDetailsLiveData;

    public Repository(Application application) {
        resumeMakerDatabase = ResumeMakerDatabase.getDatabase(application);
        resumeMakerDao = resumeMakerDatabase.resumeMakerDao();
        profileListLivedata = resumeMakerDao.getAllProfile();
        personalDetailsLiveData=resumeMakerDao.getPersonalDetailsOfProfile();
    }

    public LiveData<List<Profile>> getAllProfiles() {
        return profileListLivedata;
    }
    public LiveData<PersonalDetails> getPersonalDetails() {
        return personalDetailsLiveData;
    }

    public void insertProfile(Profile profile) {
        new InsertProfileAsyncTask(resumeMakerDao).execute(profile);
    }


    private class InsertProfileAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ResumeMakerDao resumeMakerDao;

        public InsertProfileAsyncTask(ResumeMakerDao dao) {
            this.resumeMakerDao = dao;
        }


        @Override
        protected Void doInBackground(Profile... profiles) {
            resumeMakerDao.insertProfile(profiles[0]);
            return null;
        }
    }
    public void insertPersonalDetails(PersonalDetails personalDetails){
        new InsertPersonalDetailsAsyncTask(resumeMakerDao).execute(personalDetails);
    }

    private class InsertPersonalDetailsAsyncTask extends  AsyncTask<PersonalDetails,Void,Void>{
        private ResumeMakerDao resumeMakerDao;
        public InsertPersonalDetailsAsyncTask(ResumeMakerDao dao) {
            this.resumeMakerDao = dao;
        }

        @Override
        protected Void doInBackground(PersonalDetails... personalDetails) {
            resumeMakerDao.insertPersonalDetails(personalDetails[0]);
            return null;
        }
    }
//    public Completable insertProfile(final Profile profile){
//            resumeMakerDao.insertProfile(profile);
//            return null;
//    }



}
