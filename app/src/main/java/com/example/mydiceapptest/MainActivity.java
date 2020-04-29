package com.example.mydiceapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView diceImage1=findViewById(R.id.imgDice1);
        final ImageView diceImage2=findViewById(R.id.imgDice2);

       final int [] diceImages ={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};//referrence to images of dice placed in drawable
       // diceImages[2];



        int myBox = 10; /*i am assigning number 10 to my box in this step*/
        float myFloatBox = 4.2f;/*f is putted because data type is float*/
        double myDoubleBox = 3.34578923;/*no need for a variable in double*/

        Button btnRoll = findViewById(R.id.btnRollTheDice);
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.dice_sound);//we here used a media player to make sounds whereas our sound file is present under res folder in raw

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("MyDiceApp","btnRoll is tapped now");/* i here stands for information */
                Random random=new Random();
                int myRandomNumber=random.nextInt(6);//this will generate random no 0...5
                Log.i("MyDiceApp","The generated random no is "+ myRandomNumber);//to convert int to string we use + ""

                diceImage1.setImageResource(diceImages[myRandomNumber]);

                myRandomNumber=random.nextInt(6);

                diceImage2.setImageResource(diceImages[myRandomNumber]);
                YoYo.with(Techniques.SlideInDown)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.SlideInUp)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage2);
                mediaPlayer.start();
            }
        });



    }
}
