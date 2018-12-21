package com.example.lenovo.hmm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    private Button register;
    private EditText no_telp;
    private EditText conpass;
    private EditText email;
    private TextView gotolog;
    private EditText pass;
    private EditText nama;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.submit);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        gotolog = findViewById(R.id.gotolog);
        nama = findViewById(R.id.nama);
        no_telp = findViewById(R.id.no_telp);
        conpass = findViewById(R.id.con_pass);
        firebaseAuth = FirebaseAuth.getInstance();

        gotolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fk = new Intent(Register.this, Login.class);
                startActivity(fk);
            }
        });
    }


    public void submit_click(View v){

        String password = pass.getText().toString();
        String vadPass = conpass.getText().toString();

        if (TextUtils.isEmpty(no_telp.getText().toString())){
            Toast.makeText(this, "No Telpon tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(nama.getText().toString())){
            Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(email.getText().toString())){
            Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(pass.getText().toString())){
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }

        else if ( !password.equals(vadPass)){
            Toast.makeText(this, "Password Tidak sama", Toast.LENGTH_SHORT).show();
        }
        else {


            final ProgressDialog progressDialog = ProgressDialog.show(Register.this, "Please wait..", "Processing..", true);
            (firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()))
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
                                String userID = firebaseAuth.getCurrentUser().getUid();
                                databaseReference.child(userID).child("Notlp").setValue(no_telp.getText().toString());
                                databaseReference.child(userID).child("email").setValue(email.getText().toString());
                                databaseReference.child(userID).child("nama").setValue(nama.getText().toString());
                                Toast.makeText(Register.this, "Register Success!", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Register.this, Login.class);

                                startActivity(i);
                            } else {
                                Toast.makeText(Register.this, "Gagal register", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }
    }
}
