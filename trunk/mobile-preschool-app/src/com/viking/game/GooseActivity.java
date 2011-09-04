/**
 *
 * Copyright 2011 TeleNav, Inc. All rights reserved.
 * GooseActivity.java
 *
 */
package com.viking.game;

import java.io.IOException;
import java.io.InputStream;

import com.viking.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;

import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 *@author GongChen (gongchen.cn@gmail.com)
 *@date 2011-9-4
 */
public class GooseActivity extends Activity
{
    protected void onStart()
    {
        super.onStart();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.goose);
        CheckBox box = (CheckBox) findViewById(R.id.gooseCheckBox);
        
        BitmapDrawable image = (BitmapDrawable) getResources().getDrawable(R.drawable.button01);
        box.setButtonDrawable(image);
        box.setWidth(image.getBitmap().getWidth());
        box.setHeight(image.getBitmap().getHeight());
 
        final MediaPlayer player = MediaPlayer.create(this, R.raw.goose);
        
        player.setLooping(true);

        box.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    buttonView.setButtonDrawable(R.drawable.button02);
//                    player.reset();
//                    try
//                    {
//                        player.prepare();
//                    }
//                    catch (IllegalStateException e)
//                    {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    catch (IOException e)
//                    {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    player.start();
                }
                else
                {
                    buttonView.setButtonDrawable(R.drawable.button01);
                    player.stop();
//                    player.release();
                }
            }
        });
        
       
    }
    
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        ImageView gooseImage = (ImageView) findViewById(R.id.gooseImage);
        AnimationDrawable animation1 = (AnimationDrawable) gooseImage.getBackground();
        animation1.setOneShot(false);
        animation1.stop();
        animation1.start();
        ImageView dragonflyImage = (ImageView)findViewById(R.id.dragonflyImage);
        AnimationDrawable animation2 = (AnimationDrawable)dragonflyImage.getBackground();
        animation2.stop();
        animation2.start();
    }
}
