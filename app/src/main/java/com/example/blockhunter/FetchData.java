package com.example.blockhunter;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FetchData extends AsyncTask<Void, Void, ArrayList<Product>> {

    ArrayList<Product> productList = new ArrayList<>();
    private String query;
    public FetchData(){

    }
    public FetchData(String query){
        this.query = query;
    }
    @Override
    protected void onPostExecute(ArrayList<Product> productList) {
        super.onPostExecute(productList);

    }
    public String getWalmartApi(){
        return "http://api.walmartlabs.com/v1/search?apiKey=f95tkjdaepwn7rexbxrb4cs5&query="+query+"&numItems=10";
    }
    public String getBestBuyUPCApi(){
        return "https://api.bestbuy.com/v1/products((search=lego)&upc="+"673419233590"+")?apiKey=QgIu1I4A3VFbIjgGuuIPAsKu&format=json";
    }

    @Override
    protected ArrayList<Product> doInBackground(Void... voids) {
        try {
        URL url = new URL(getWalmartApi());
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

        System.out.println("Data from Walmart: " + data.toString());
            JSONObject jsonObject1 = new JSONObject(data);
//            JSONObject response = jsonObject1.getJSONObject("items");
            JSONArray jsonArray = jsonObject1.getJSONArray("items");
            String productName,description,msrp, salePrice, upc, thumbnail, mediumImage = "";

            for(int i = 0 ; i < jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                productName = jsonObject.get("name").toString();
                description = jsonObject.get("shortDescription").toString();
                msrp = jsonObject.get("msrp").toString();
                salePrice = jsonObject.get("salePrice").toString();
                upc = jsonObject.get("upc").toString();
                thumbnail = jsonObject.get("thumbnailImage").toString();
                mediumImage = jsonObject.get("mediumImage").toString();
                System.out.print("Product Name : " + productName +"\t");
                Product product = new Product(productName, description, thumbnail, mediumImage);
                product.setMsrp(msrp);
                product.setWalmartPrice(salePrice);
                product.setUpc(upc);
                productList.add(product);

                System.out.print("Short Description : " + description+"\t");
                System.out.print("MSRP : " + msrp+"\t");
                System.out.print("Sales Price : " + salePrice+"\t");
                System.out.print("UPC : " + upc+"\t");
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return productList;
    }
}
