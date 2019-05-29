package com.developer.harshi.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mQuestionView;
    private TextView mScoreView;
    private Button mchoice1;
    private Button mchoice2;
    private Button mchoice3;

    private String mAnswer;
    private int score=0;
    private int mQuestionNumber=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.q1);
        mchoice1 = findViewById(R.id.b1q1);
        mchoice2 = findViewById(R.id.b1q2);
        mchoice3 = findViewById(R.id.b1q3);

        if(mQuestionNumber==10){
            Intent i = new Intent (QuizActivity.this,Extra.class);
            i.putExtra("score",score);
            startActivity(i);
        }
        else
            updateQuestion();
        mchoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mchoice1.getText()==mAnswer);
                score = score+1;
                updatescore(score);
                updateQuestion();
            }
        });
        mchoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mchoice2.getText()==mAnswer);
                score = score+1;
                updatescore(score);
                updateQuestion();
            }
        });
        mchoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mchoice3.getText()==mAnswer);
                score = score+1;
                updatescore(score);
                updateQuestion();
            }
        });
    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestions(mQuestionNumber));
        mchoice1.setText(mQuestionLibrary.getchoice1(mQuestionNumber));
        mchoice2.setText(mQuestionLibrary.getchoice2(mQuestionNumber));
        mchoice3.setText(mQuestionLibrary.getchoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswers(mQuestionNumber);
        mQuestionNumber++;
    }

    private void updatescore(int score) {
        mScoreView.setText(""+score);
    }
}
