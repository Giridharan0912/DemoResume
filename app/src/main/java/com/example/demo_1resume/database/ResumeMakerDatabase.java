package com.example.demo_1resume.database;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.demo_1resume.entities.PersonalDetails;
import com.example.demo_1resume.entities.Profile;

@Database(entities = {Profile.class, PersonalDetails.class}, version = 1)
public abstract class ResumeMakerDatabase extends RoomDatabase {
    public static volatile ResumeMakerDatabase INSTANCE;

    public abstract ResumeMakerDao resumeMakerDao();

    public static ResumeMakerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ResumeMakerDatabase.class) {
                if (INSTANCE == null) {
                    //create our db
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ResumeMakerDatabase.class, "resume_maker_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}