package uk.co.glacialstudio.lgcloveconnectionempty;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

public class MainActivity extends AppCompatActivity {

    public int x;
    public int realDist=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void compareDistance(View y) {
        if (realDist > x) {
            // Get instance of Vibrator from current Context
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            // This example will cause the phone to vibrate "SOS" in Morse Code
            // In Morse Code, "s" = "dot-dot-dot", "o" = "dash-dash-dash"
            // There are pauses to separate dots/dashes, letters, and words
            // The following numbers represent millisecond lengths
            int dot = 200;      // Length of a Morse Code "dot" in milliseconds
            int dash = 400;     // Length of a Morse Code "dash" in milliseconds
            int short_gap = 25;    // Length of Gap Between dots/dashes
            int medium_gap = 50;   // Length of Gap Between Letters
            int long_gap = 75;    // Length of Gap Between Words
            long[] pattern = {
                    0,  // Start immediately
                    dot, short_gap, dot, short_gap, dot,    // s
                    medium_gap,
                    dash, short_gap, dash, short_gap, dash, // o
                    medium_gap,
                    dot, short_gap, dot, short_gap, dot,    // s
                    long_gap
            };

            // Only perform this pattern one time (-1 means "do not repeat")
            v.vibrate(pattern, 0);
        }
        else {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(50);
            v.cancel();
        }
    }

    public void oneMeter(View v) {
        x=1;

        TextView t = (TextView) findViewById(R.id.distanceText);
        t.setText(""+x);
    }
    public void twoMeter(View v) {
        x=2;
        TextView t = (TextView) findViewById(R.id.distanceText);
        t.setText(""+x);
    }
    public void threeMeter(View v) {
        x=3;
        TextView t = (TextView) findViewById(R.id.distanceText);
        t.setText(""+x);
    }
    public void fourMeter(View v) {
        x=4;
        TextView t = (TextView) findViewById(R.id.distanceText);
        t.setText(""+x);
    }
    public void fiveMeter(View v) {
        x=5;
        TextView t = (TextView) findViewById(R.id.distanceText);
        t.setText(""+x);
    }

    public void VibrateTap(View x) {
        // Get instance of Vibrator from current Context
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // This example will cause the phone to vibrate "SOS" in Morse Code
        // In Morse Code, "s" = "dot-dot-dot", "o" = "dash-dash-dash"
        // There are pauses to separate dots/dashes, letters, and words
        // The following numbers represent millisecond lengths
        int dot = 200;      // Length of a Morse Code "dot" in milliseconds
        int dash = 400;     // Length of a Morse Code "dash" in milliseconds
        int short_gap = 25;    // Length of Gap Between dots/dashes
        int medium_gap = 50;   // Length of Gap Between Letters
        int long_gap = 75;    // Length of Gap Between Words
        long[] pattern = {
                0,  // Start immediately
                dot, short_gap, dot, short_gap, dot,    // s
                medium_gap,
                dash, short_gap, dash, short_gap, dash, // o
                medium_gap,
                dot, short_gap, dot, short_gap, dot,    // s
                long_gap
        };

        // Only perform this pattern one time (-1 means "do not repeat")
        v.vibrate(pattern, 0);
    }

    public void stopVibrate(View y) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(50);
        v.cancel();
    }

    public void onButtonTap(View z) {
        Toast myToast = Toast.makeText(getApplicationContext(), "Ouch!", Toast.LENGTH_LONG);
        myToast.show();
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
