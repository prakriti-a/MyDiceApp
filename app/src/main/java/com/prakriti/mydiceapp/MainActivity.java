package com.prakriti.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button roll;
    ImageView firstDice, secondDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstDice = findViewById(R.id.firstDice);
        secondDice = findViewById(R.id.secondDice);

        int[] diceArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        roll = findViewById(R.id.roll);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randomObj = new Random();

                int number = randomObj.nextInt(6); // upper bound is not included
                firstDice.setImageResource(diceArray[number]);
                number = randomObj.nextInt(6); // upper bound is not included
                secondDice.setImageResource(diceArray[number]);

                YoYo.with(Techniques.Shake).duration(400).repeat(0).playOn(firstDice); // duration in ms
                YoYo.with(Techniques.Shake).duration(400).repeat(0).playOn(secondDice);

                mp.start();
            }
        });

    }
}