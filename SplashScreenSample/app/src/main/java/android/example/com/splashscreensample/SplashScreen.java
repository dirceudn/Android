package android.example.com.splashscreensample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

    /**
     * The splash time out.
     */
    private static final int SPLASHTIMEOUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    final Intent i = new Intent(SplashScreen.this, LoginActivity.class);

                    startActivity(i);
                    finish();
                }
            }, SPLASHTIMEOUT);

    }


    /**
     * Destroy the activity.
     */
    @Override
    protected final void onDestroy() {
        super.onDestroy();
    }
}
