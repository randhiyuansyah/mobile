package com.example.lenovo.hmm;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class AkunFragment extends Fragment {

    private View myMainView;
    private Button logout;
    private TextView nama;
    private TextView email;
    private TextView notlp;
    private FirebaseAuth mAuth;
    private DatabaseReference dbref;


    public AkunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myMainView = inflater.inflate(R.layout.fragment_akun, container, false);
        logout = myMainView.findViewById(R.id.buttonLogout);
        nama = myMainView.findViewById(R.id.nama_akun);
        notlp = myMainView.findViewById(R.id.notlp_akun);
        email = myMainView.findViewById(R.id.email_akun);
        mAuth = FirebaseAuth.getInstance();
        String currentUserId = mAuth.getCurrentUser().getUid();
        dbref = FirebaseDatabase.getInstance().getReference().child("User").child(currentUserId);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent mainIntent = new Intent(getContext(), MainActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(mainIntent);
            }
        });

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String namaStr = dataSnapshot.child("nama").getValue().toString();
                    String emailStr = dataSnapshot.child("email").getValue().toString();
                    String notlpStr = dataSnapshot.child("Notlp").getValue().toString();

                    nama.setText(namaStr);
                    email.setText(emailStr);
                    notlp.setText(notlpStr);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return myMainView;
    }

}
