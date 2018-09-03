package com.tarandigitalempire.bankigame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newGame = findViewById(R.id.btn_new_game);
        Button showScore = findViewById(R.id.btn_show_scores);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThemesActivity.class));
            }
        });

        showScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(), ScoresActivity.class));
                Toast.makeText(getApplicationContext(), "Chargement des scores en cours...", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
