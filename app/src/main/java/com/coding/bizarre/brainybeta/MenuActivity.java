package com.coding.bizarre.brainybeta;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MenuActivity extends ActionBarActivity {
    private Context context;
    private Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = getApplicationContext();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void GotoOrganize(View v)
    {
        Intent I = new Intent(this,OrganizeActivity.class);
        startActivity(I);
        Log.d("Debug","Organize");
    }


    public void GotoTieIn(View v){
        Intent I = new Intent(this,TieInActivity.class);
        startActivity(I);
        Log.d("Debug","Tie In");
    }

    public void GotoGuess(View v){
        Intent I = new Intent(this,GuessActivity.class);
        startActivity(I);
        Log.d("Debug","Guess");
    }

    public void Soon(View v){
        Toast.makeText(context,"Coming soon!",Toast.LENGTH_SHORT).show();
        Log.d("Debug","Coming Soon!");
    }
}
