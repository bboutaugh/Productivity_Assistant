package com.productivityassistant.group14.productivity_assistant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
CurrentTime time;
DBMS dbms;
DataSnapshot dataSnapshot;
DatabaseReference dRef;





    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    Button trackerButton = (Button)findViewById(R.id.trackerButton);
    Button scheduleButton = (Button)findViewById(R.id.scheduleButton);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        AlertDialog.Builder queryAlert = new AlertDialog.Builder(MainActivity.this);

        queryAlert.setMessage("Are you busy at this hour?").setTitle("Productivity Request");


        queryAlert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dbms.updateWorkMetric(dataSnapshot, time.getDay(), time.getHour(), dRef);
            }
        });

        queryAlert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        queryAlert.show();
    }

    public void onClick(View v)
    {
        Intent startTrackerIntent = new Intent(getApplicationContext(),Tracker.class);
        startActivity(startTrackerIntent);
        Intent startScheduleIntent = new Intent(getApplicationContext(),Schedule.class);
        startActivity(startScheduleIntent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


}
