package com.andresleonel09.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.andresleonel09.petagram.R;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        setToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setToolbar() {
        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miActionBar);
    }
}
