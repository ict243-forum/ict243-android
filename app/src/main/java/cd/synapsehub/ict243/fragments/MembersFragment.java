package cd.synapsehub.ict243.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import cd.synapsehub.ict243.R;
import cd.synapsehub.ict243.model.MemberIct;
import cd.synapsehub.ict243.model.blogs;


public class MembersFragment extends Fragment {

    private EditText mSearchField;
    private ImageButton mSearchBtn;
    private RecyclerView mResultList;
    private DatabaseReference mMembersDatabase;

    public MembersFragment() {
        // Required empty public constructor
    }

    public static MembersFragment newInstance(String param1, String param2) {
        MembersFragment fragment = new MembersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_members, container, false);

        mMembersDatabase = FirebaseDatabase.getInstance().getReference("members");

        mResultList = rootView.findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(getActivity()));


        //Firebase ici
        FirebaseRecyclerAdapter<MemberIct, MembersFragment.UsersViewHolder> FBRA = new FirebaseRecyclerAdapter<MemberIct, MembersFragment.UsersViewHolder>(
                MemberIct.class,
                R.layout.list_layout,
                MembersFragment.UsersViewHolder.class,
                mMembersDatabase
        ) {
            @Override
            protected void populateViewHolder(MembersFragment.UsersViewHolder viewHolder, MemberIct model, int position) {
                final String post_key = getRef(position).getKey().toString();

                viewHolder.setDetails(getActivity(),model.getMbfullname(),model.getMbtitle(),model.getMbphoto());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent singleActivity = new Intent(MainActivity.this, SinglePostActivity.class);
                        //singleActivity.putExtra("PostID", post_key);
                        // startActivity(singleActivity);
                    }
                });
            }
        };
        mResultList.setAdapter(FBRA);

        return rootView;
    }



    // View Holder Class

    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public UsersViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDetails(Context ctx, String userName, String userStatus, String userImage){

            TextView user_name = mView.findViewById(R.id.name_text);
            TextView user_status = mView.findViewById(R.id.status_text);
            ImageView user_image = mView.findViewById(R.id.profile_image);


            user_name.setText(userName);
            user_status.setText(userStatus);

            Glide.with(ctx).load(userImage).into(user_image);


        }




    }


}
