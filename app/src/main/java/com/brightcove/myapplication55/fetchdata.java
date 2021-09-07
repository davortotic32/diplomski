package com.brightcove.myapplication55;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchdata extends AsyncTask<Void,Void,Void> {
    JSONArray data;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://demo.smart.sum.ba/parking?withParkingSpaces=1");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String data2 = "";
            while (line != null){
                line = bufferedReader.readLine();
                data2 += line;
            }
            data = new JSONArray(data2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);

        try {

            JSONObject p1 = (JSONObject) this.data.get(0);
            JSONObject p2 = (JSONObject) this.data.get(1);
            JSONObject p3 = (JSONObject) this.data.get(2);

            MainActivity.data.setText("Ukupno mjesta na parkingu:" + p1.get("capacity_normal").toString());
            MainActivity.slobono1Txt.setText("Trenutno slobodno mjesta na parkingu:" + p1.get("normal_available").toString());
            MainActivity.zauzeto1Txt.setText("Trenutno zauzeto mjesta na parkingu:"+ p1.get("normal_occupied").toString());

            MainActivity.data1.setText("Ukpuno mjesta na parkingu:" + p2.get("capacity_normal").toString());
            MainActivity.slobono2Txt.setText("Trenutno slobodno mjesta na parkingu:" + p2.get("normal_available").toString());
            MainActivity.zauzeto2Txt.setText("Trenutno zauzeto mjesta na parkingu:" + p2.get("normal_occupied").toString());

            MainActivity.data2.setText("Ukpuno mjesta na parkingu:" + p3.get("capacity_normal").toString());
            MainActivity.slobono3Txt.setText("Trenutno slobodno mjesta na parkingu:" + p3.get("normal_available").toString());
            MainActivity.zauzeto3Txt.setText("Trenutno zauzeto mjesta na parkingu:" + p3.get("normal_occupied").toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

