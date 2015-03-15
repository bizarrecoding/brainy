package com.coding.bizarre.brainybeta;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class TieInActivity extends ActionBarActivity {

    public String ans;
    public int[] bArray,V;
    public int count,dec;
    public Context ctx;
    public boolean correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie_in);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        bArray = new int[4];
        bArray[0]=R.id.button1;
        bArray[1]=R.id.button2;
        bArray[2]=R.id.button3;
        bArray[3]=R.id.button4;
        count = 9;
        dec=0;
        V = new int[10];
        for(int i=0;i<10;i++){
            V[i]=i+1;
        }
        count--;
        loader();
        ctx = getApplicationContext();
    }

    public void loader(){
        String options = null;
        int drawableID = 0;
        int temp;
        correct=false;
        int r = 1 + Math.abs(new Random().nextInt()) % count;
        Log.d("Debug","choice: "+r);
        switch(Math.abs(r)){
            case 1:
                options = "Grapes;Cranberries;Cherries;Tomatoes";
                drawableID = R.drawable.juego_word1;
                ans = "Cherries";
            break;
            case 2:
                options = "Flag;Car;Boat;Floater";
                drawableID = R.drawable.juego_word2;
                ans = "Boat";
            break;
            case 3:
                options="Cotton;Cloud;Window;white";
                drawableID = R.drawable.juego_word3;
                ans = "Cloud";
            break;
            case 4:
                options="Piece;Nail;Key;Blade";
                drawableID = R.drawable.juego_word4;
                ans = "Key";
                break;
            case 5:
                options="Eye;Ball;Coin;Balloon";
                drawableID = R.drawable.juego_word5;
                ans = "Eye";
                break;
            case 6:
                options="Train;Bus;Truck;Car";
                drawableID = R.drawable.juego_word6;
                ans = "Car";
                break;
            case 7:
                options="Skyscraper;House;Shop;Mall";
                drawableID = R.drawable.juego_word7;
                ans = "House";
                break;
            case 8:
                options="Monkey;Puppy;Dog;Donkey";
                drawableID = R.drawable.juego_word8;
                ans = "Monkey";
                break;
            case 9:
                options="Bar;Eraser;Pencil;Ruler";
                drawableID = R.drawable.juego_word9;
                ans = "Pencil";
                break;
            case 10:
                options="Moon;Star;Sun;Scar";
                drawableID = R.drawable.juego_word10;
                ans = "Star";
                break;
            default:
                options="Cotton;Cloud;Window;white";
                drawableID = R.drawable.juego_word3;
                ans = "Cloud";
            break;
        }
        ImageView iv = (ImageView)findViewById(R.id.question);
        iv.setImageResource(drawableID);
        String optionsArray[] = options.split(";");
        for(int i = 0;i<4;i++){
            Button button = (Button) findViewById(bArray[i]);
            button.setText(optionsArray[i]);
            button.setVisibility(View.VISIBLE);
            Drawable dr;
            if(i%2==0){
                dr = getResources().getDrawable(R.drawable.tiein_button_a);
            }else{
                dr = getResources().getDrawable(R.drawable.tiein_button_b);
            }
            button.setBackground(dr);
        }
        temp=V[r];
        V[r]=V[count];
        V[count]=temp;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tie_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void answer(View v){
        Button b = (Button)findViewById(v.getId());
        Drawable ans_bg;
        Log.d("Debug","button touched");
        if(!correct){
            if(b.getText().equals(ans)){
                ans_bg = getResources().getDrawable(R.drawable.tiein_respuesta_correcta);
                b.setBackground(ans_bg);
                for(Integer i:bArray){
                    if(!i.equals(v.getId())) {
                        correct=true;
                        Button button = (Button) findViewById(i);
                        Animation ani = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
                        ani.setDuration(1600);
                        listenAnim(ani);
                        button.startAnimation(ani);
                        button.setVisibility(View.INVISIBLE);
                    }
                }
            }else{
                ans_bg = getResources().getDrawable(R.drawable.tiein_respuesta_incorrecta);
                b.setBackground(ans_bg);
            }
        }
    }
    public void listenAnim(Animation anim){
        anim.setAnimationListener( new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                dec++;
                if(dec%3==0){
                    Log.d("Debug","Count: "+count);
                    if(count>4){
                        count--;
                        loader();
                    }else{
                        Log.d("Debug", "Count stopped: "+count);
                        Intent I = new Intent(ctx,GameOverActivity.class);
                        startActivity(I);
                        Log.d("Debug","GameOver");

                    }
                }
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
}
