package com.example.blockhunter;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPostExecute(Void newVoid) {
        super.onPostExecute(newVoid);

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
        URL url = new URL("http://api.walmartlabs.com/v1/search?apiKey=f95tkjdaepwn7rexbxrb4cs5&query=lego");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        InputStream iStream = httpConn.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(iStream));
        String line = "";
        while(line != null)
        {
            line = bf.readLine();

        }
        System.out.println("Data from Walmart: " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
