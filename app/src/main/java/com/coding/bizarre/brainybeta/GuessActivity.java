package com.coding.bizarre.brainybeta;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;


public class GuessActivity extends ActionBarActivity {
    public String ans;
    public int count;
    public int V[];
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        count = 9;
        V = new int[10];
        for(int i=0;i<10;i++){
            V[i]=i+1;
        }
        count--;
        loader();
    }
    public void loader(){
        Log.d("Debug", "Loading image question");
        ans = "";
        int temp;
        int drawableID = 0;
        int r = 1 + Math.abs(new Random().nextInt()) % 10;
        switch(V[r]){
            case 1:
                drawableID = R.drawable.juego_word1;
                ans = "cherries";
                break;
            case 2:
                drawableID = R.drawable.juego_word2;
                ans = "boat";
                break;
            case 3:
                drawableID = R.drawable.juego_word3;
                ans = "cloud";
                break;
            case 4:
                drawableID = R.drawable.juego_word4;
                ans = "key";
                break;
            case 5:
                drawableID = R.drawable.juego_word5;
                ans = "eye";
                break;
            case 6:
                drawableID = R.drawable.juego_word6;
                ans = "car";
                break;
            case 7:
                drawableID = R.drawable.juego_word7;
                ans = "house";
                break;
            case 8:
                drawableID = R.drawable.juego_word8;
                ans = "monkey";
                break;
            case 9:
                drawableID = R.drawable.juego_word9;
                ans = "pencil";
                break;
            case 10:
                drawableID = R.drawable.juego_word10;
                ans = "star";
                break;
            default:
                drawableID = R.drawable.juego_word10;
                ans = "star";
                break;
        }
        EditText et = (EditText)findViewById(R.id.editText);
        Drawable dr = getResources().getDrawable(R.drawable.respuestatexto);
        et.setBackground(dr);
        et.setText("");

        ImageView iv = (ImageView)findViewById(R.id.guess_question);
        iv.setImageResource(drawableID);
        temp=V[r-1];
        V[r-1]=V[count];
        V[count]=temp;
    }
    public void answer(View v){
        EditText et = (EditText)findViewById(R.id.editText);
        Drawable ans_bg;
        Log.d("Debug","ans: "+ans+", text: "+et.getText()+".");
        if(et.getText().toString().equals(ans)){
            ans_bg = getResources().getDrawable(R.drawable.respuestacorrecta);
            //next

            if(count>4) {
                count--;
                Log.d("Debug","Count: "+count);
                loader();
            }else{
                Intent I = new Intent(this,GameOverActivity.class);
                startActivity(I);
                Log.d("Debug","GameOver");
            }
        }else{
            ans_bg = getResources().getDrawable(R.drawable.respuestaincorrecta);
        }
        et.setBackground(ans_bg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guess, menu);
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
}
