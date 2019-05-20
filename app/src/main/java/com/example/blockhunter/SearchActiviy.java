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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activiy);

       //Made this searchView stuff
        SearchView searchView = findViewById(R.id.searchView);
        CharSequence query = searchView.getQuery();
        final String queryString = query.toString();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

          @Override
          public boolean onQueryTextSubmit(String query) {
              Toast.makeText(SearchActiviy.this, query, Toast.LENGTH_LONG).show();
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
              return false;
          }
      });


        initSearchResults();
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

