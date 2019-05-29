//Comment: This is a test by Leotis M Fields
//Test


package com.example.blockhunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;

public class SearchActiviy extends AppCompatActivity {

    //vars
    private ArrayList<String> sResultDescription = new ArrayList<>();
    private ArrayList<String> sResultItem = new ArrayList<>();
    private ArrayList<Product> products= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activiy);

       //Made this searchView stuff
        SearchView searchView = findViewById(R.id.searchView);
        CharSequence query = searchView.getQuery();


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

        Thread.sleep(5000);
        for(Product product : products){
            sResultDescription.add(product.getProductName());
            sResultItem.add(product.getMediumImage());

        }
            initRecyclerView();
    }

    private void initSearchResults(){
           // Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

            sResultItem.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
            sResultDescription.add("Havasu Falls");

            sResultItem.add("https://i.redd.it/tpsnoz5bzo501.jpg");
            sResultDescription.add("Trondheim");


            sResultItem.add("https://i.redd.it/j6myfqglup501.jpg");
            sResultDescription.add("Rocky Mountain National Park");


            sResultItem.add("https://i.redd.it/0h2gm1ix6p501.jpg");
            sResultDescription.add("Mahahual");

            sResultItem.add("https://i.redd.it/k98uzl68eh501.jpg");
            sResultDescription.add("Frozen Lake");


            sResultItem.add("https://i.redd.it/glin0nwndo501.jpg");
            sResultDescription.add("White Sands Desert");

            sResultItem.add("https://i.redd.it/obx4zydshg601.jpg");
            sResultDescription.add("Austrailia");

            sResultItem.add("https://i.imgur.com/ZcLLrkY.jpg");
            sResultDescription.add("Washington");

            initRecyclerView();
        }

        private void initRecyclerView(){
            //Log.d(TAG, "initRecyclerView: init recyclerview.");
            RecyclerView recyclerView = findViewById(R.id.results_recycler_view1);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, sResultDescription, sResultItem);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

