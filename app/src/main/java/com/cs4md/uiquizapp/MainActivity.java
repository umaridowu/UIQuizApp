package com.cs4md.uiquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Code complete through Unit 1 Lesson 8 Activities and Intents.

    // declaring the UI element variables
    TextView questionTextView;
    Button trueButton;
    Button falseButton;
    Button nextButton;
    // declaring a score variable
    int score;
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;
    Question currentQ;
    String message;

    Question[] arrayOfQuestion;
    int currentIndex;

    // declaring a score variable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflating the UI elements Initialize the variables
        questionTextView = (TextView) findViewById(R.id.question_text);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.finished_button);
        score=0;

        q1 = new Question("The int 1 is represented as true", true);
        q2 = new Question("9 is represented as 1001", true);
        q3 = new Question("E is represented as 12 in Hexadecimal", false);
        q4 = new Question("The computer converts images to letters", false);
        q5 = new Question("Your age can be an int or a boolean", true);
        currentQ = q1;
        message = "";
        arrayOfQuestion = new Question[]{q1,q2,q3,q4,q5};
        currentIndex = 0;


        // onClick listener and method for the true button,
        // will display toast stating they got it wrong
        // and set the score to 0%
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.isCorrectAnswer() == true){
                    message = "Correct";
                    score++;

                }
                else{
                    message = "Try Again";
                }
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // onClick listener and method for the false button,
        // will display toast stating they got it right
        // and set the score to 100%
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.isCorrectAnswer() == false){
                    message = "Correct";
                    score++;

                }
                else{
                    message = "Try Again";
                }
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // when the finished button is clicked, we
        // declare an intent, pass the score as an "extra",
        // then open the ScoreActivity to display the score
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < arrayOfQuestion.length-1){
                    //advance and show next question
                    currentIndex ++;
                    currentQ = arrayOfQuestion[currentIndex];
                    questionTextView.setText(arrayOfQuestion[currentIndex].getqText());

                }
               else {
                    Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            }
        });

    }
}