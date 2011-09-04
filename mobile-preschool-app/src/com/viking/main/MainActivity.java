package com.viking.main;

import com.viking.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawableResource(R.drawable.background00);
        setContentView(R.layout.main);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        for (int i = 0; i < linearLayout1.getChildCount(); i++)
        {
            linearLayout1.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v)
    {
        System.out.println("Click " + v.getId());
        switch (v.getId())
        {
            case R.id.button1:
            {
                Intent intent = new Intent();
                intent.setClassName(this, "com.viking.game.GooseActivity");
                startActivity(intent);
                break;
            }
            case R.id.button2:
            {

                break;
            }
            case R.id.button3:
            {

                break;
            }
        }
    }
}