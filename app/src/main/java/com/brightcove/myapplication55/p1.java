package com.brightcove.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.DateFormat;
import java.util.Calendar;

public class p1 extends AppCompatActivity  {
    VideoView videoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1);

        TextView dateTxt = findViewById(R.id.dateTxt);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        dateTxt.setText(currentDate);

        VideoView player = (VideoView)findViewById(R.id.videoView);
        String httpLiveUrl = "http://rtmp.smart.sum.ba/stream/4fec9b2d-5907-4378-b481-a69640fa4eba/index.m3u8";
        player.setVideoURI(Uri.parse(httpLiveUrl));
        player.setMediaController(new MediaController(this));
        player.requestFocus();
        player.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_p1, menu);
        return true;
    }


}
