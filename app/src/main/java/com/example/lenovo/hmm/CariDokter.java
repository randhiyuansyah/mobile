package com.example.lenovo.hmm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class CariDokter extends AppCompatActivity {

    private EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_dokter);

        //search = findViewById(R.id.search_input);
    }
}
