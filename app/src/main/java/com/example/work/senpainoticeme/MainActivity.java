package com.example.work.senpainoticeme;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.EditText;


//event handling: events caused when pressing button
// callback: text changing

public class MainActivity extends ActionBarActivity {
    EditText senpai_id;
    TextView Textname;
    DBHandler dbHandler;


    //Notification
    NotificationCompat.Builder notification;
    private static final int uniqueID = 2304; // give id to each notif.

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
              /* For the input and text */
        senpai_id = (EditText) findViewById(R.id.senpai_id);
        Textname = (TextView) findViewById(R.id.Textname);
        dbHandler = new DBHandler(this, null, null, 1);
        printDatabase();

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        //whatever notif. on screen will delete action
    }

    // adds product to database - only accepts a product object

    public void addButtonClicked(View view){
        Products product = new Products(senpai_id.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }
     public void deleteButtonClicked(View view){
        String inputText = senpai_id.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        Textname.setText(dbString);
        senpai_id.setText("");
    }


    public void save_button_clicked(View view) {
        // build the notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title");
        notification.setContentText("I am the body text of the notification");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);
        // builds notification and issues (sending out to device) it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());
    }
//okay button listen do as soon activity created

//    Button will_he_button = (Button) findViewById(R.id.will_he_button);
//    // event listener
//    will_he_button.setOnClickListener(new View.OnClickListener(){
//    public void onClick(View v){
//        TextView Notice_me = (TextView) findViewById(R.id.Notice_me);
//        Notice_me.setText("He notices me!");
//        }
//    };



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
