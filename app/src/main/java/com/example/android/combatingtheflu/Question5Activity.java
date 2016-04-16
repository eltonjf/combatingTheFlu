package com.example.android.combatingtheflu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Elton on 15/04/2016.
 */
public class Question5Activity extends AppCompatActivity {

    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question5_activity);

        score = getIntent().getIntExtra("score", 0);
        name = getIntent().getStringExtra("name");
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        TextView textAnswer = (TextView) findViewById(R.id.textViewAnswerQ5);

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonQ5True:
                if (checked)
                    textAnswer.setText(R.string.answerWrongQ5);
                textAnswer.setVisibility(View.VISIBLE);
                textAnswer.setTextColor(Color.parseColor("#D32F2F"));

                break;
            case R.id.radioButtonQ5False:
                if (checked)
                    textAnswer.setText(R.string.answerRightQ5);
                textAnswer.setVisibility(View.VISIBLE);
                textAnswer.setTextColor(Color.parseColor("#0288D1"));

                score += 1;
                break;
        }
    }

    public void next(View view){
        boolean checkedFalse = ((RadioButton) findViewById(R.id.radioButtonQ5False)).isChecked();
        boolean checkedTrue = ((RadioButton) findViewById(R.id.radioButtonQ5True)).isChecked();

        if(checkedFalse == false && checkedTrue == false){
            Toast.makeText(this, R.string.radioButtonError, Toast.LENGTH_SHORT).show();
            return;
        }else{
            Intent intent = new Intent(this, FinalActivity.class);

            intent.putExtra("score", score);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }
}
