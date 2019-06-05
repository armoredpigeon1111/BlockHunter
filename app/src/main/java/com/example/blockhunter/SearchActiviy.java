package com.example.blockhunter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class SearchActiviy extends AppCompatActivity {

    private ArrayList<String> sResultDescription = new ArrayList<>();
    private ArrayList<String> sResultItem = new ArrayList<>();
    private ArrayList<Product> products= new ArrayList<>();
    private String locationString;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activiy);
        /*******LOCATION STUFF*************/
        //LocationRequisition locReq = new LocationRequisition();
        getLocation();
        /********END LOCATION STUFF********/
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
      @Override
      public boolean onQueryTextSubmit(String queryString) {
          queryString = "Lego "+queryString.toString().trim(); // Use this to pass the search item?
          final String queryStringMod = queryString.replaceAll("\\s", "%20");
          Toast.makeText(SearchActiviy.this, queryStringMod , Toast.LENGTH_LONG).show();
          FetchData fd = new FetchData(queryStringMod);
          fd.execute();
          products = fd.productList;
          try {
              initSearchResults(products);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return false;
      }
      @Override
      public boolean onQueryTextChange(String newText) {
          return false;
      }
        });
    }

    private void initSearchResults(ArrayList<Product> products) throws InterruptedException {
        Thread.sleep(3000);
        for(Product product : products){
            sResultDescription.add(product.getProductName());
            sResultItem.add(product.getMediumImage());
        }
            //Intent intent = new Intent();
            //intent.putExtra("productList",products);
            initRecyclerView(products);
    }

    private void initRecyclerView(ArrayList<Product> products){
        RecyclerView recyclerView = findViewById(R.id.results_recycler_view1);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, products);// sResultDescription, sResultItem);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public String getLocation(){
        client = LocationServices.getFusedLocationProviderClient(SearchActiviy.this);

        if (ActivityCompat.checkSelfPermission(SearchActiviy.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(SearchActiviy.this, "Location Unavailable" , Toast.LENGTH_LONG).show();
        }

        client.getLastLocation().addOnSuccessListener(SearchActiviy.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                locationString = Location.convert(location.getLatitude(), Location.FORMAT_DEGREES) +
                        " " + Location.convert(location.getLongitude(), Location.FORMAT_DEGREES);
                System.out.println(locationString);
                Toast.makeText(SearchActiviy.this, locationString , Toast.LENGTH_LONG).show();
            }
        });
        return locationString;
    }
}

