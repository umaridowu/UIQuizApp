package com.cs4md.uiquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    // declaring variables
    TextView scoreTV;
    int score;
    Button sendEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        sendEmail = (Button) findViewById(R.id.sendEmail);
        // retrieving the "int extra" (i.e. score) we put into the intent
        // when we started this activity




        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        // inflating UI element variables
        scoreTV = (TextView) findViewById(R.id.score_TV);

        //concatenating the string score with the numerical score
        scoreTV.setText("Score: " + score);

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "Look at my score";
                String [] addresses = new String[]{"umaridowu@gmail.com"};
                String body = "I scored high in the quiz. I scored " + score + "out five";
                email(addresses, subject,body);
            }
        });


    }
    public void email(String [] addresses, String subject, String body){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        //intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent. EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}