package com.example.yodha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    public ArrayList<String> questions;
    public TextView question;
    int i = 0;
    Button next;
    Button previous;
    RadioButton radioButton1;
    RadioButton radioButton2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_quiz_view);
        question = findViewById(R.id.textView2);
        next = findViewById(R.id.Next);
        previous = findViewById(R.id.Previous);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        questions = new ArrayList<>();

        questions.add(getString(R.string.question_1));
        questions.add(getString(R.string.question_2));

        questions.add(getString(R.string.question_3));
        questions.add(getString(R.string.question_4));
        questions.add(getString(R.string.question_5));
        questions.add(getString(R.string.question_6));
        questions.add(getString(R.string.question_7));
        questions.add(getString(R.string.question_8));

        question.setText(questions.get(0));
    }

    public void nextQuestion(View view) {
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);

        if (i < questions.size()) {
            question.setText(questions.get(++i));
        } else if (i >= questions.size()) {
            Toast.makeText(QuizActivity.this, "No further questions", Toast.LENGTH_LONG).show();

        }

    }

    public void previousQuestion(View view) {
        i--;
        if (i >= 0) {
            question.setText(questions.get(i));
        } else if (i < 0) {
            Toast.makeText(QuizActivity.this, "Questions not found", Toast.LENGTH_LONG).show();
        }

    }
}
