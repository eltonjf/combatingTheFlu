package com.example.android.combatingtheflu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by elton on 15/04/2016.
 */
public class Question2Activity extends AppCompatActivity {

    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2_activity);

        name = getIntent().getStringExtra("name");
        score = getIntent().getIntExtra("score", 0);
    }


   public void next(View view){
            boolean checkedFalse = ((RadioButton) findViewById(R.id.radioButtonQ2False)).isChecked();
            boolean checkedTrue = ((RadioButton) findViewById(R.id.radioButtonQ2True)).isChecked();

            if(checkedFalse == false && checkedTrue == false){
                Toast.makeText(this, R.string.radioButtonError, Toast.LENGTH_SHORT).show();
                return;
            }else{
                Intent intent = new Intent(this, Question3Activity.class);

                intent.putExtra("score", score);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        }


        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            TextView textAnswer = (TextView) findViewById(R.id.textViewAnswerQ2);

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radioButtonQ2True:
                    if (checked)
                        textAnswer.setText(R.string.answerRightQ2);
                    textAnswer.setVisibility(View.VISIBLE);
                    textAnswer.setTextColor(Color.parseColor("#0288D1"));

                    score += 1;

                    break;
                case R.id.radioButtonQ2False:
                    if (checked)
                        textAnswer.setText(R.string.answerWrongQ2);
                    textAnswer.setVisibility(View.VISIBLE);
                    textAnswer.setTextColor(Color.parseColor("#D32F2F"));

                    break;
        }
    }

}
