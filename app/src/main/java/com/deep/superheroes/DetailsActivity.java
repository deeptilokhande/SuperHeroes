package com.deep.superheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView setDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent getIntent = getIntent();
        String publisher = getIntent.getStringExtra("publisher");
        String createdBy = getIntent.getStringExtra("createdBy");
        String firstAppearance = getIntent.getStringExtra("firstappearance");

        setDetails = findViewById(R.id.other_details);
        setDetails.setText("Publisher :"+publisher + "\n"
                +"Created By :" +createdBy+"\n"
                +"First Appearance :"+firstAppearance+"\n");
    }
}
