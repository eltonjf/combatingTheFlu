package com.example.android.combatingtheflu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Elton on 15/04/2016.
 */
public class Question5Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question5_activity);
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

                break;
        }
    }
}