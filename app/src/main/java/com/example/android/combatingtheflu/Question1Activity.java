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
public class Question1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1_activity);

    }


    public void next(View view){
        boolean checkedFalse = ((RadioButton) findViewById(R.id.radioButtonQ1False)).isChecked();
        boolean checkedTrue = ((RadioButton) findViewById(R.id.radioButtonQ1True)).isChecked();

        if(checkedFalse == false && checkedTrue == false){
            Toast.makeText(this, R.string.radioButtonError, Toast.LENGTH_SHORT).show();
            return;
        }else{
            Intent intent = new Intent(this, Question2Activity.class);
            startActivity(intent);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        TextView  textAnswer = (TextView) findViewById(R.id.textViewAnswerQ1);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonQ1True:
                if (checked)
                    textAnswer.setText(R.string.answerWrongQ1);
                    textAnswer.setVisibility(View.VISIBLE);
                    textAnswer.setTextColor(Color.parseColor("#D32F2F"));

                break;
            case R.id.radioButtonQ1False:
                if (checked)
                    textAnswer.setText(R.string.answerRightQ1);
                    textAnswer.setVisibility(View.VISIBLE);
                    textAnswer.setTextColor(Color.parseColor("#0288D1"));

                break;
        }
    }
}
