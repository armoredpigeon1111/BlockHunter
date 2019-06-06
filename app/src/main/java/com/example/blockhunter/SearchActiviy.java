package com.example.blockhunter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchActiviy extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private ArrayList<String> sResultDescription = new ArrayList<>();
    private ArrayList<String> sResultItem = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private String locationString;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activiy);
        /*******LOCATION STUFF*************/
        //LocationRequisition locReq = new LocationRequisition();
        //getLocation();
        String bestProvider;
        Geocoder geocoder;
        List<Address> user = null;
        double lat;
        double lng;
        String zipCode;
        LocationManager lm = (LocationManager) SearchActiviy.this.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        bestProvider = lm.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            System.out.println("request permission");

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

            return;
        }

        Location location = lm.getLastKnownLocation(bestProvider);
        if(location == null){
            System.out.println("location is null");
            Toast.makeText(this,"Location Not Found", Toast.LENGTH_LONG).show();
        }else{
            geocoder = new Geocoder(this);
            try{
                user = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                lat = (double)user.get(0).getLatitude();
                lng = (double)user.get(0).getLongitude();
                zipCode = user.get(0).getPostalCode();
                System.out.println("latitude and longitude " + lat + " " +lng + " zipcode: " + zipCode + " address: "  + user.get(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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
/*
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
                System.out.println("location String " + locationString);
                Toast.makeText(SearchActiviy.this, locationString , Toast.LENGTH_LONG).show();
            }
        });
        return locationString;
    }
    */
}

