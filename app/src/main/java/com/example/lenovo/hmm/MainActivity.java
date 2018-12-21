package com.example.lenovo.hmm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button logbut;
    private Button regbut;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logbut = findViewById(R.id.login_button);
        regbut = findViewById(R.id.regis_button);
        mAuth = FirebaseAuth.getInstance();

        logbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Halaman Login.", Toast.LENGTH_SHORT).show();
                Intent w = new Intent(MainActivity.this, Login.class);
                startActivity(w);
            }
        });

        regbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Halaman Registrasi.", Toast.LENGTH_SHORT).show();
                Intent t = new Intent(MainActivity.this, Register.class);
                startActivity(t);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cuurentUser = mAuth.getCurrentUser();
        if (cuurentUser != null){
            String currentUserId = mAuth.getCurrentUser().getUid();

            Intent mainInten = new Intent(MainActivity.this, Home.class);
            mainInten.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(mainInten);
            finish();


        }
    }
}
