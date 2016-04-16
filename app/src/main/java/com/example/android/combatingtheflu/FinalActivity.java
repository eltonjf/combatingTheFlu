package com.example.android.combatingtheflu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Elton on 16/04/2016.
 */
public class FinalActivity extends AppCompatActivity {

    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        name = getIntent().getStringExtra("name");
        score = getIntent().getIntExtra("score", 0);

        TextView textView = (TextView) findViewById(R.id.inputNameFinal);
        textView.setText(getString(R.string.congratFinal) + " " + name);

        TextView textViewResult = (TextView) findViewById(R.id.inputResultFinal);

        if(score >2) {
            textViewResult.setText(getString(R.string.informationFinal)+ " " +getString(R.string.resultFinal)+ " " +String.valueOf(score));
        }else{
            textViewResult.setText(getString(R.string.messageEmailStudy)+ " " +String.valueOf(score));
        }
    }

    public void sendEmail(View view){

        String subject = getString(R.string.app_name);
        String message = "";

        if(score > 2){
            message = getString(R.string.messageEmail);
        }else{
            message = getString(R.string.messageEmailStudy);
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
