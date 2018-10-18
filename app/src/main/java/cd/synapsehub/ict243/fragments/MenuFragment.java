package cd.synapsehub.ict243.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import cd.synapsehub.ict243.MainActivity;
import cd.synapsehub.ict243.R;
import cd.synapsehub.ict243.adapter.MenuAdapter;



public class MenuFragment extends Fragment {

    public static final String TAG = MenuFragment.class.getSimpleName();


    //private RecyclerView recyclerView;
    CardView mycard,cardblog, cardmember;
    Intent i ;
    LinearLayout ll;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        /*recyclerView = rootView.findViewById(R.id.menu_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        MenuAdapter adapter = new MenuAdapter(getContext());
        recyclerView.setAdapter(adapter);*/

        ll = rootView.findViewById(R.id.ll);
        mycard = rootView.findViewById(R.id.bankcardId);
        cardblog=rootView.findViewById(R.id.cardblog);
        cardmember=rootView.findViewById(R.id.cardmembres);

        setCardListeners();

        return rootView;
    }


    private void setCardListeners(){
        //code ici

        i = new Intent(getActivity(),MainActivity.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(i);
                Toast.makeText(getActivity(), "Action a ajouter", Toast.LENGTH_SHORT).show();
            }
        });

        cardblog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

               // Toast.makeText(getActivity(), "Action a ajouter", Toast.LENGTH_SHORT).show();
                BlogsFragment blogsFragment=new BlogsFragment();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frame_container,blogsFragment,"Blogs")
                        .commit();

            }
        });

        cardmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MembersFragment membFragment=new MembersFragment();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frame_container,membFragment,"Membres")
                        .commit();
            }
        });

    }




}
