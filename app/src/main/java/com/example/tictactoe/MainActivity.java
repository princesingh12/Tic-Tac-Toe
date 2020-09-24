package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     boolean active=true;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int activePlayer=0;
    int[][] winningPositions={{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};

    public  void Tap(View view)
    {  ImageView image=(ImageView)view;
       int tappedPositon=Integer.parseInt(image.getTag().toString());
       TextView text=(TextView)findViewById(R.id.StatusBar);

       if(!active)
           Reset(view);

       if(gameState[tappedPositon]==2)
       {  gameState[tappedPositon]=activePlayer;
           image.setTranslationY(-1000f);
           if(activePlayer==0)
           { image.setImageResource(R.drawable.x);
              activePlayer=1;
              text.setText("Player 2- Tap to play");
           }
           else
           {
               image.setImageResource(R.drawable.o);
               activePlayer=0;
               text.setText("Player 1- Tap to play");
           }
                 image.animate().translationYBy(1000f).setDuration(300);
       }
            for(int w[]:winningPositions)
            { if(gameState[w[0]]==gameState[w[1]]&&gameState[w[1]]==gameState[w[2]]&&gameState[w[0]]!=2)
             {   active=false;
                  String str;
                  if(gameState[w[0]]==0)
                      str="Player 1 has won";
                  else
                      str="player 2 has won";

                  TextView status=(TextView) findViewById(R.id.StatusBar);
                  status.setText(str);
               }


            }
    }
    public void Reset(View view)
    { active=true;
       for (int i=0;i<gameState.length;i++)
           gameState[i]=2;

        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);



    }

    public void clickButton(View view)
    {   Reset(view);


    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TextView t1=(TextView) findViewById(R.id.StatusBar);
                    t1.setOnClickListener(null);
            TextView t2=(TextView) findViewById(R.id.textView);
              t2.setOnClickListener(null);
            ImageView img=findViewById(R.id.imageView);
            img.setOnClickListener(null);
            TextView t3=(TextView)findViewById(R.id.textView2);
                   t3.setOnClickListener(null);

        }
    }



