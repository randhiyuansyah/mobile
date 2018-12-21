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

public class Login extends AppCompatActivity {

  private Button login;
  private EditText email;
  private EditText pass;
  private TextView gotoreg;
  private FirebaseAuth firebaseAuth;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    login = findViewById(R.id.login);
    email = findViewById(R.id.email);
    gotoreg = findViewById(R.id.gotoreg);
    pass = findViewById(R.id.pass);
    firebaseAuth = FirebaseAuth.getInstance();
    gotoreg.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent ro = new Intent(Login.this, Register.class);
        startActivity(ro);
      }
    });
  }


  public void login_Click(View v){
    if (TextUtils.isEmpty(email.getText().toString())){
      Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_LONG).show();
    }
    else if (TextUtils.isEmpty(pass.getText().toString())){
      Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
    }
    else {
      final ProgressDialog progressDialog = ProgressDialog.show(Login.this, "Please wait..", "Processing..", true);
      (firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString()))
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                  progressDialog.dismiss();

                  if (task.isSuccessful()) {
                    Toast.makeText(Login.this, "Login Success!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login.this, Home.class);

                    startActivity(i);
                  } else {
                    Log.e("ERROR!!", task.getException().toString());
                    Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                  }
                }
              });
    }
  }
}
