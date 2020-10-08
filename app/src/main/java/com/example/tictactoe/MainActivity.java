package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1 : player1 , 2:player2 , 0:empty

    int gameState[]={0,0,0,0,0,0,0,0,0};
    int activePlayer=1;
    int[][] winSituation={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6},{0,4,8}};
    boolean gameActive=true;

    public void dropIn(View view){
        ImageView counter=(ImageView) view;
        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        boolean win=false;

        if(gameState[tappedCounter]==0 && gameActive) {
            counter.setTranslationY(-2000);
            gameState[tappedCounter]=activePlayer;


            if (activePlayer == 1) {
                counter.setImageResource(R.drawable.x);
                activePlayer = 2;
            } else {
                counter.setImageResource(R.drawable.o);
                activePlayer = 1;
            }
            counter.animate().translationYBy(2000).setDuration(300);
            String winner = "";
            for (int[] winposition : winSituation) {
                if (gameState[winposition[0]] == gameState[winposition[1]] && gameState[winposition[1]] == gameState[winposition[2]] && gameState[winposition[0]] != 0  /*(Not empty)*/) {
                    //someone has won!
                    win=true;
                    gameActive=false;

                    if (activePlayer == 2) {
                        winner = "X has won";
                    } else {
                        winner = "O has won";

                    }
                    Toast.makeText(this, winner, Toast.LENGTH_LONG).show();
                    TextView winnerText=(TextView)findViewById(R.id.winnerTextView);
                    ImageButton rButton=(ImageButton)findViewById(R.id.replayButton);
                    winnerText.setText(winner);
                    winnerText.setVisibility(View.VISIBLE);
                    rButton.setVisibility(View.VISIBLE);
                }
            }
        }
        if(!win) {
            int count = 0;
            for (int i = 0; i < 9; i++) {
                if (gameState[i] != 0) {
                    count++;
                }
            }
            if (count == 9) {
                TextView winnerText = (TextView) findViewById(R.id.winnerTextView);
                ImageButton rButton = (ImageButton) findViewById(R.id.replayButton);
                winnerText.setText("Tie");
                winnerText.setVisibility(View.VISIBLE);
                rButton.setVisibility(View.VISIBLE);
            }
        }

    }

    public void resetGrid(View view){
        for(int i=0;i<9;i++) {
            gameState[i] = 0;
        }
        activePlayer=1;
        gameActive=true;

        TextView winnerText=(TextView)findViewById(R.id.winnerTextView);
        ImageButton rButton=(ImageButton)findViewById(R.id.replayButton);
        winnerText.setVisibility(View.INVISIBLE);
        rButton.setVisibility(View.INVISIBLE);

        ImageView img1 = (ImageView) findViewById(R.id.o00);
        img1.setImageDrawable(null);
        ImageView img2 = (ImageView) findViewById(R.id.o01);
        img2.setImageDrawable(null);
        ImageView img3 = (ImageView) findViewById(R.id.o02);
        img3.setImageDrawable(null);
        ImageView img4 = (ImageView) findViewById(R.id.o10);
        img4.setImageDrawable(null);
        ImageView img5 = (ImageView) findViewById(R.id.o11);
        img5.setImageDrawable(null);
        ImageView img6 = (ImageView) findViewById(R.id.o12);
        img6.setImageDrawable(null);
        ImageView img7 = (ImageView) findViewById(R.id.o20);
        img7.setImageDrawable(null);
        ImageView img8 = (ImageView) findViewById(R.id.o21);
        img8.setImageDrawable(null);
        ImageView img9 = (ImageView) findViewById(R.id.o22);
        img9.setImageDrawable(null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}