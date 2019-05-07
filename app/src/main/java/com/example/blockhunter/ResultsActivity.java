package com.example.blockhunter;
//Richard is Working on Results page
//Doesn't work yet...Don't freak out if you try it
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class ResultsActivity extends AppCompatActivity {
    private RecyclerView recylerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        recylerView = (RecyclerView) findViewById(R.id.results_recycler_view);

        //sets size because the content should not change layout size
        //MAY NEED TO CHANGE IF SYNDICATED CONTENT DOES NOT PLAY NICE
        recylerView.setHasFixedSize(true);

        //Linear Layout Manager
        layoutManager = new LinearLayoutManager(this);
        recylerView.setLayoutManager(layoutManager);

        //setting the adapter
        String[] resultsDataset = {"item 1", "item 2", "item 3", "item 4", "I'm a Lego", "item 6"};
        mAdapter = new ResultsAdapter(resultsDataset);//changed myDataset to resultsDataset
        recylerView.setAdapter(mAdapter);
    }

}
