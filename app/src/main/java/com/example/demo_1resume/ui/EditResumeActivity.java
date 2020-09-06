package com.example.demo_1resume.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.demo_1resume.R;
import com.example.demo_1resume.model.ResumeMakerViewModel;
import com.example.demo_1resume.ui.fragments.PersonalDetailsFragments;
import com.example.demo_1resume.ui.fragments.ProjectsFragment;
import com.example.demo_1resume.ui.fragments.QualificationFragment;
import com.example.demo_1resume.ui.fragments.SkillsFragment;
import com.google.android.material.navigation.NavigationView;

import static com.example.demo_1resume.ui.adapters.ProfileListAdapter.PROFILE_ID;

public class EditResumeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private NavigationView navigationView;
    private Bundle bundle;
    private int profileId;
    private ResumeMakerViewModel resumeMakerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_resume);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager=getSupportFragmentManager();
       bundle=getIntent().getExtras();
       profileId= bundle.getInt(PROFILE_ID);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {

            fragmentTransaction=fragmentManager.beginTransaction();
            PersonalDetailsFragments personalDetailsFragments=new PersonalDetailsFragments(getApplicationContext());
            personalDetailsFragments.setArguments(bundle);
            fragmentTransaction.replace(R.id.edit_resume_container,personalDetailsFragments);
            fragmentTransaction.commit();
            navigationView.setCheckedItem(R.id.nav_personalDetails);
        }


    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==UPDATE_PERSONAL_DETAIL_REQ_CODE&& resultCode==RESULT_OK){
//            profileId=data.getIntExtra(PROFILE_ID,0);
//
//        }
//
//    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_personalDetails:

                fragmentTransaction=fragmentManager.beginTransaction();
                PersonalDetailsFragments personalDetailsFragments=new PersonalDetailsFragments(getApplicationContext());
                fragmentTransaction.replace(R.id.edit_resume_container,personalDetailsFragments);
                fragmentTransaction.commit();

                break;
            case R.id.nav_qualification:

                fragmentTransaction=fragmentManager.beginTransaction();
                QualificationFragment qualificationFragment=new QualificationFragment();
                fragmentTransaction.replace(R.id.edit_resume_container,qualificationFragment);
                fragmentTransaction.commit();
                break;
            case R.id.nav_skills:
                fragmentTransaction=fragmentManager.beginTransaction();
                SkillsFragment skillsFragment=new SkillsFragment();
                fragmentTransaction.replace(R.id.edit_resume_container,skillsFragment);
                fragmentTransaction.commit();
                break;
            case R.id.nav_projects:
                fragmentTransaction=fragmentManager.beginTransaction();
                ProjectsFragment projectsFragment=new ProjectsFragment();
                fragmentTransaction.replace(R.id.edit_resume_container,projectsFragment);
                fragmentTransaction.commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}