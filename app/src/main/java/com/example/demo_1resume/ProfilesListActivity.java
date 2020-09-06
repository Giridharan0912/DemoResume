package com.example.demo_1resume;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo_1resume.entities.Profile;
import com.example.demo_1resume.model.ResumeMakerViewModel;
import com.example.demo_1resume.ui.adapters.ProfileListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ProfilesListActivity extends AppCompatActivity {
    private   String TAG = this.getClass().getSimpleName();
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private EditText etProfileName;
    private EditText etProfileEmail;
    private Button saveProfileBtn;
    private RecyclerView recyclerView;
    private ProfileListAdapter profileListAdapter;
    private ResumeMakerViewModel resumeMakerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles_list);
        recyclerView = findViewById(R.id.profile_list_recycler_view);
        FloatingActionButton fab = findViewById(R.id.fab);
        resumeMakerViewModel = ViewModelProviders.of(this).get(ResumeMakerViewModel.class);
        recyclerView = findViewById(R.id.profile_list_recycler_view);
        profileListAdapter = new ProfileListAdapter(this);
        recyclerView.setAdapter(profileListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        resumeMakerViewModel.getAllProfilesList().observe(this, new Observer<List<Profile>>() {
            @Override
            public void onChanged(List<Profile> profiles) {
                profileListAdapter.setProfileList(profiles);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                createProfilePopUp();
            }
        });
    }

    private void createProfilePopUp() {
        builder = new AlertDialog.Builder(ProfilesListActivity.this);
        View view = getLayoutInflater().inflate(R.layout.create_profile_popup, null);
        etProfileName = view.findViewById(R.id.et_profile_name);
        etProfileEmail = view.findViewById(R.id.et_profile_email);
        saveProfileBtn = view.findViewById(R.id.save_profile_button);
        saveProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etProfileName.getText().toString().isEmpty()
                        && !etProfileEmail.getText().toString().isEmpty()) {
                    String profileName = etProfileName.getText().toString();
                    String profileEmail = etProfileEmail.getText().toString();

                    Profile profile = new Profile(profileName, profileEmail);
                    resumeMakerViewModel.insertProfile(profile);
                    Log.i(TAG,"Success");
                }else {
                    Toast.makeText(ProfilesListActivity.this,"Not saved",Toast.LENGTH_SHORT).show();
                }
                alertDialog.dismiss();

            }
        });
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();

    }
}