package com.example.blockhunter;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BBFetchData extends AsyncTask<Product, Void, Product> {

    Product passedProduct;
    private String upc;
    public BBFetchData(){

    }


    public BBFetchData(String upc){
        this.upc = upc;
    }
    @Override
    protected void onPostExecute(Product product) {
        super.onPostExecute(product);

    }

    public String getBestBuyUPCApi(){
        return "https://api.bestbuy.com/v1/products((search=lego)&upc="+upc+")?apiKey=QgIu1I4A3VFbIjgGuuIPAsKu&format=json";
    }

    @Override
    protected Product doInBackground(Product... products) {
        passedProduct = products[0];
        try {
        URL url = new URL(getBestBuyUPCApi());
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        InputStream iStream = httpConn.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(iStream));
        String line = "";
        int count = 0;
        String data = "";
        while(line != null )
        {
            line =  bf.readLine();
            data = data + line;
        }

        System.out.println("Data from Best Buy: " + data.toString());
            JSONObject jsonObject1 = new JSONObject(data);
//            JSONObject response = jsonObject1.getJSONObject("items");
            JSONArray jsonArray = jsonObject1.getJSONArray("products");
            String bbUrl, salePrice = "";

            if(jsonArray.get(0) == null)
            {
                bbUrl = "";
                salePrice = "n/a";
            }
            else {

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    bbUrl = jsonObject.get("url").toString();
                    salePrice = jsonObject.get("salePrice").toString();

                    passedProduct.setBbPrice(salePrice);
                    passedProduct.setBBUrl(bbUrl);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return passedProduct;
    }
}
