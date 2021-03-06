package com.example.demo_1resume.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_1resume.R;
import com.example.demo_1resume.entities.Profile;
import com.example.demo_1resume.ui.EditResumeActivity;
import com.example.demo_1resume.ui.fragments.PersonalDetailsFragments;

import java.util.List;


public class ProfileListAdapter extends RecyclerView.Adapter<ProfileListAdapter.ProfileListViewHolder> {
    public static final String PROFILE_ID ="profileId" ;
    public static final int UPDATE_PERSONAL_DETAIL_REQ_CODE = 1;
    private Context context;
    private LayoutInflater inflater;
    private List<Profile> profileList;

    public ProfileListAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProfileListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.profile_list_item, parent, false);
        return new ProfileListViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileListViewHolder holder, int position) {
        if (profileList != null) {
            Profile current = profileList.get(position);
            holder.setProfileData(current.getProfileName(), current.getProfileEmailId(), current.getProfileId());

        }

    }

    public void setProfileList(List<Profile> profiles) {
        profileList = profiles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (profileList != null) {
            return profileList.size();
        } else return 0;
    }

    public class ProfileListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvProfileName;
        private TextView tvProfileEmailId;
        private Context context;
        private int profileId;
        private ImageButton editBtn;

        public ProfileListViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            this.context = ctx;
            tvProfileName = itemView.findViewById(R.id.tv_profile_name);
            tvProfileEmailId = itemView.findViewById(R.id.tv_profile_email);
            editBtn=itemView.findViewById(R.id.edit_btn);
            editBtn.setOnClickListener(this);

        }

        public void setProfileData(String profileName, String profileEmailId, int profileId) {
            tvProfileName.setText(profileName);
            tvProfileEmailId.setText(profileEmailId);
            this.profileId = profileId;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.edit_btn:
//                    todo: go to editResumeActivity and open personalDetailFragment to save personal details of the respective profile clicked
                    int profilePosition=getAdapterPosition();
                    Intent intent=new Intent(context, EditResumeActivity.class);
                    Profile profile=new Profile();
                    intent.putExtra(PROFILE_ID,profileId);
                    ((Activity)context).startActivity(intent);
            }
        }

    }
}
