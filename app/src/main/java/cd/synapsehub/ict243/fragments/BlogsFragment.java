package cd.synapsehub.ict243.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cd.synapsehub.ict243.R;
import cd.synapsehub.ict243.model.blogs;


public class BlogsFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    /*private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;*/

    public BlogsFragment() {
        // Required empty public constructor
    }

    public static BlogsFragment newInstance(String param1, String param2) {
        BlogsFragment fragment = new BlogsFragment();
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
        View rootView= inflater.inflate(R.layout.fragment_blogs, container, false);


        recyclerView = (RecyclerView)rootView.findViewById(R.id.blog_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("blogs");

        //Firebase ici
        FirebaseRecyclerAdapter<blogs, BlogzoneViewHolder> FBRA = new FirebaseRecyclerAdapter<blogs, BlogzoneViewHolder>(
                blogs.class,
                R.layout.card_items,
                BlogzoneViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(BlogzoneViewHolder viewHolder, blogs model, int position) {
                final String post_key = getRef(position).getKey().toString();
                viewHolder.setTitle(model.getPosttitle());
                viewHolder.setDesc(model.getPostdesc());
                viewHolder.setImageUrl(getActivity(), model.getPhoto());
                viewHolder.setUserName(model.getPostauthor());
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
        recyclerView.setAdapter(FBRA);




        return rootView;
    }

    public static class BlogzoneViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public BlogzoneViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setTitle(String title){
            TextView post_title = mView.findViewById(R.id.post_title_txtview);
            post_title.setText(title);
        }
        public void setDesc(String desc){
            TextView post_desc = mView.findViewById(R.id.post_desc_txtview);
            post_desc.setText(desc);
        }
        public void setImageUrl(Context ctx, String imageUrl){
            ImageView post_image = mView.findViewById(R.id.post_image);
            Glide.with(ctx).load(imageUrl).into(post_image);
        }
        public void setUserName(String userName){
            TextView postUserName = mView.findViewById(R.id.post_user);
            postUserName.setText(userName);
        }
    }

}
