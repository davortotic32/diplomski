package com.brightcove.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    //za otvaranje ulazne kamere
    private Button p1Btn;
    private Button p2Btn;

    //za dohvaćanje podataka
    public static TextView data;
    public static TextView slobono1Txt;
    public static TextView zauzeto1Txt;

    public static TextView data1;
    public static TextView slobono2Txt;
    public static TextView zauzeto2Txt;

    public static TextView data2;
    public static TextView slobono3Txt;
    public static TextView zauzeto3Txt;



    private Button refreshBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button p1Btn = findViewById(R.id.P1Btn);
        Button p2Btn = findViewById(R.id.P2Btn);
        TextView dateTxt = findViewById(R.id.dateTxt);
        Button refreshBtn = findViewById(R.id.refreshBtn);

        data= (TextView) findViewById(R.id.ukupno1Txt);
        slobono1Txt= (TextView) findViewById(R.id.slobono1Txt);
        zauzeto1Txt=(TextView) findViewById(R.id.zauzeto1Txt);

        data1= (TextView) findViewById(R.id.ukupno2Txt);
        slobono2Txt= (TextView) findViewById(R.id.slobono2Txt);
        zauzeto2Txt=(TextView) findViewById(R.id.zauzeto2Txt);

        data2= (TextView) findViewById(R.id.ukupno3Txt);
        slobono3Txt= (TextView) findViewById(R.id.slobono3Txt);
        zauzeto3Txt=(TextView) findViewById(R.id.zauzeto3Txt);
        fetchdata process = new fetchdata();



        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new fetchdata().execute();
            }
        });


        p1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openP1();
            }
        });

        p2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openP2();
            }
        });
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        dateTxt.setText(currentDate);
    }
    public void openP1(){
        Intent i = new Intent(this, p1.class);
        startActivity(i);
    }
    public void openP2(){
        Intent i = new Intent(this,p2.class);
        startActivity(i);
    }
}
