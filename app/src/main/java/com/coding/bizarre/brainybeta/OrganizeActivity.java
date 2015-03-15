package com.coding.bizarre.brainybeta;

import android.app.ActionBar;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;
import java.util.Vector;


public class OrganizeActivity extends ActionBarActivity {

    private LinearLayout ButtonsLayout1;
    private LinearLayout ButtonsLayout2;
    private LinearLayout AnswersLayout;
    private ImageView WordImage;
    private int LetterCount = 4;
    private int ButtonAnswers = 10;
    private String word;
    private int locationanswer=0;
    private int locationanswerstart;
    private Vector<String> answerims;
    private Vector<Integer> Buttonans;
    private Vector<Button> DaButtons;
    private Vector<String> LetterPos;
    private Context context;
    public boolean firsttime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organize);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButtonsLayout1 = (LinearLayout)findViewById(R.id.ButtonLayout1);
        ButtonsLayout2 = (LinearLayout)findViewById(R.id.ButtonLayout2);
        context = getApplicationContext();
        AnswersLayout = (LinearLayout)findViewById(R.id.AnswerLayout);
        WordImage = (ImageView)findViewById(R.id.ImageWord);
        firsttime = true;
        DaButtons = new Vector<>();

        loadimage();
        loadButtons();
        Log.d("Debug","Pude Load Image");
        CreateButtons();
        Log.d("Debug","Pude Crear Botones");
        CreateAnswers();
        Log.d("Debug","Pude Crear Answers");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_organize, menu);
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

    public void loadButtons()
    {
        DaButtons.add((Button) findViewById(R.id.button6));
        DaButtons.add((Button) findViewById(R.id.button7));
        DaButtons.add((Button) findViewById(R.id.button8));
        DaButtons.add((Button) findViewById(R.id.button9));
        DaButtons.add((Button) findViewById(R.id.button10));
        DaButtons.add((Button) findViewById(R.id.button11));
        DaButtons.add((Button) findViewById(R.id.button12));
        DaButtons.add((Button) findViewById(R.id.button13));
        DaButtons.add((Button) findViewById(R.id.button14));
        DaButtons.add((Button) findViewById(R.id.button15));
    }

    public void CreateAnswers()
    {
        AnswersLayout.removeAllViewsInLayout();
        TextView Def;
        ImageView De;

        if(firsttime)
        {
            for(int i=1; i<=LetterCount; i++)
            {
                De = new ImageView(context);
                De.setImageResource(R.drawable.rayadebajodelaletrajuego2);

                AnswersLayout.addView(De);
                answerims.add("");
            }
            firsttime = false;
        }
        else
        {
            for(int i=1; i<=LetterCount; i++)
            {
                De = new ImageView(context);
                Def = new TextView(context);
                if(answerims.get(i-1).contentEquals(""))
                {
                    De.setImageResource(R.drawable.rayadebajodelaletrajuego2);
                    AnswersLayout.addView(De);
                }
                else
                {
                    Def.setText(answerims.get(i-1));
                    AnswersLayout.addView(Def);
                }


            }
        }

    }

    public void CreateButtonText()
    {
        LetterPos = new Vector<>();
        for(int i = 1; i<=ButtonAnswers; i++)
        {
            if (i<=LetterCount)
            {
                LetterPos.add(word.substring(i-1,i));
            }
            else
            {
                Random rn = new Random();
                int rni = rn.nextInt();
                rni = Math.abs(rni);
                int ri = 65 + rni% 23;

                Log.d("Debug","Next int is"+rni);
                LetterPos.add(((char) ri)+"");
            }
        }
    }

    public void CreateButtons()
    {
        Log.d("Debug", "Entre a Create");
        answerims = new Vector<>();
        Buttonans = new Vector<>();
        TextView Def;
        Button tempB;
        Log.d("Debug", "Cree Vector");
        boolean flag= true;
        CreateButtonText();
        Log.d("Debug",""+LetterPos.size());
        for(int j = 1; j<=ButtonAnswers; j++)
        {

            DaButtons.get(j-1).setText(LetterPos.get(j - 1));
        }

    }

    public void loadimage()
    {
        Random rn = new Random();

        int randomnum =  1 + Math.abs(rn.nextInt())% 8;
        Log.d("Debug",""+randomnum);
        switch(Math.abs(randomnum))
        {
            case 1:
                WordImage.setImageResource(R.drawable.juego_word1);
                word = "CHERRY";
                LetterCount = 6;
                break;
            case 2:
                WordImage.setImageResource(R.drawable.juego_word2);
                word = "BOAT";
                LetterCount = 4;
                break;
            case 3:
                WordImage.setImageResource(R.drawable.juego_word3);
                word = "CLOUD";
                LetterCount = 5;
                break;
            case 4:
                WordImage.setImageResource(R.drawable.juego_word6);
                word = "CAR";
                LetterCount = 3;
                break;
            case 5:
                WordImage.setImageResource(R.drawable.juego_word5);
                word = "EYE";
                LetterCount = 3;
                break;
            case 6:
                WordImage.setImageResource(R.drawable.juego_word7);
                word = "HOUSE";
                LetterCount = 5;
                break;
            case 7:
                WordImage.setImageResource(R.drawable.juego_word4);
                word = "KEY";
                LetterCount = 3;
                break;
            case 8:
                WordImage.setImageResource(R.drawable.juego_word8);
                word = "MONKEY";
                LetterCount = 6;
                break;
            case 9:
                WordImage.setImageResource(R.drawable.juego_word9);
                word = "PENCIL";
                LetterCount = 6;
                break;
            case 10:
                WordImage.setImageResource(R.drawable.juego_word10);
                word = "STAR";
                LetterCount = 4;
                break;
            default:
                WordImage.setImageResource(R.drawable.juego_word10);
                word = "STAR";
                LetterCount = 4;
                break;
        }


    }

    public void EndGame()
    {
        //loadimage();
        //CreateButtons();
        //CreateAnswers();
        String ans = "";

        for(int i = 0; i<answerims.size();i++)
        {
            ans = ans+answerims.get(i);
        }

        Log.d("Debug","Ans: "+ans+" Word: "+word);

        if (ans.contentEquals(word))
        {
            Toast.makeText(context,"WIN",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context,"LOSE", Toast.LENGTH_LONG).show();
        }

        for(int j = 0; j<=9; j++)
        {
            DaButtons.get(j).setClickable(false);
        }

    }

    public void Button1click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(0).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(0).setClickable(false);
        DaButtons.get(0).setVisibility(View.INVISIBLE);
    }

    public void Button2click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(1).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(1).setClickable(false);
        DaButtons.get(1).setVisibility(View.INVISIBLE);
    }

    public void Button3click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(2).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(2).setClickable(false);
        DaButtons.get(2).setVisibility(View.INVISIBLE);
    }

    public void Button4click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(3).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(3).setClickable(false);
        DaButtons.get(3).setVisibility(View.INVISIBLE);
    }

    public void Button5click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(4).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(4).setClickable(false);
        DaButtons.get(4).setVisibility(View.INVISIBLE);
    }

    public void Button6click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(5).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(5).setClickable(false);
        DaButtons.get(5).setVisibility(View.INVISIBLE);
    }

    public void Button7click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(6).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(6).setClickable(false);
        DaButtons.get(6).setVisibility(View.INVISIBLE);
    }

    public void Button8click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(7).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(7).setClickable(false);
        DaButtons.get(7).setVisibility(View.INVISIBLE);
    }

    public void Button9click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(8).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(8).setClickable(false);
        DaButtons.get(8).setVisibility(View.INVISIBLE);
    }

    public void Button10click (View v)
    {
        answerims.set(locationanswer,DaButtons.get(9).getText()+"");
        locationanswer++;
        CreateAnswers();
        if(locationanswer>=LetterCount)
        {
            EndGame();
        }
        DaButtons.get(9).setClickable(false);
        DaButtons.get(9).setVisibility(View.INVISIBLE);
    }

    private View.OnClickListener clickbutton(final String b)
    {
        Log.d("Debug","Clicked on "+b);
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerims.set(locationanswer, b);
                locationanswer++;
                CreateAnswers();
                if(locationanswer>=LetterCount)
                {
                    EndGame();
                }

                Log.d("Debug","Clicked on"+b);
            }
        };
    }

}
