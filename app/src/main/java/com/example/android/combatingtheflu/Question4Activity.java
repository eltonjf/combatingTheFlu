package com.example.android.combatingtheflu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Elton on 15/04/2016.
 */
public class Question4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question4_activity);
    }

    public void next(View view){
        boolean checkedFalse = ((RadioButton) findViewById(R.id.radioButtonQ4False)).isChecked();
        boolean checkedTrue = ((RadioButton) findViewById(R.id.radioButtonQ4True)).isChecked();

        if(checkedFalse == false && checkedTrue == false){
            Toast.makeText(this, R.string.radioButtonError, Toast.LENGTH_SHORT).show();
            return;
        }else{
            Intent intent = new Intent(this, Question5Activity.class);
            startActivity(intent);
        }
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        TextView textAnswer = (TextView) findViewById(R.id.textViewAnswerQ4);

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonQ4True:
                if (checked)
                    textAnswer.setText(R.string.answerRightQ4);
                textAnswer.setVisibility(View.VISIBLE);
                textAnswer.setTextColor(Color.parseColor("#0288D1"));

                break;
            case R.id.radioButtonQ4False:
                if (checked)
                    textAnswer.setText(R.string.answerWrongQ4);
                textAnswer.setVisibility(View.VISIBLE);
                textAnswer.setTextColor(Color.parseColor("#D32F2F"));

                break;
        }
    }

}
