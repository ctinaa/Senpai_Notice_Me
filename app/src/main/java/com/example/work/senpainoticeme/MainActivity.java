package com.example.work.senpainoticeme;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//event handling: events caused when pressing button
// callback: text changing

public class MainActivity extends ActionBarActivity {

    // okay button listen do as soon activity created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button will_he_button = (Button)findViewById(R.id.will_he_button);
     // event listener
        will_he_button.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    TextView Notice_me = (TextView)findViewById(R.id.Notice_me);
                    Notice_me.setText("He notices me!");
                }
            }
        );
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
}
