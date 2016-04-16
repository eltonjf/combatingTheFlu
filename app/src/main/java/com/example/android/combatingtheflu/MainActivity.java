package com.example.android.combatingtheflu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view){
        Intent intent = new Intent(this, Question1Activity.class);

        TextView edtTexto = (TextView) findViewById(R.id.inputName);

        String txt = "";
        txt = edtTexto.getText().toString();

        if(txt.equals("")){
            Toast.makeText(this, R.string.nameError, Toast.LENGTH_SHORT).show();
            return;
        }

        int score = 0;

        intent.putExtra("score", score);
        intent.putExtra("name", txt);
        startActivity(intent);
    }
}
