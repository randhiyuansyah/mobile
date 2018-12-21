package com.example.lenovo.hmm;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View myMainView;

    private ImageButton caridoct;
    private ImageButton carirs;
    private ImageButton ambulance;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myMainView = inflater.inflate(R.layout.fragment_home, container, false);

        caridoct = myMainView.findViewById(R.id.caridoct);
        carirs = myMainView.findViewById(R.id.carirs);
        ambulance = myMainView.findViewById(R.id.ambulance);

        caridoct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CariDokter.class);
                startActivity(i);

            }
        });

        carirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ih = new Intent(getContext(), MapsActivity.class);
                startActivity(ih);

            }
        });

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ig = new Intent(getContext(), MapsActivity.class);
                startActivity(ig);

            }
        });

        return myMainView;
    }

}
