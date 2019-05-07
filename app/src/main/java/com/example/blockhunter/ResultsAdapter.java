package com.example.blockhunter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultsAdapter extends RecyclerView.Adapter
        <ResultsAdapter.MyViewHolder> {
    private String[] mDataset;

    //Referencing views for each item
    //MAY need more than one view per item
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //this is just for a test..
        public TextView textView;
        public MyViewHolder(TextView v){
            super(v);
           // textView = v;
        }
        //end of textView test
    }

    //constructor
    public ResultsAdapter(String[] resultsDataset){
        mDataset = resultsDataset;
    }

    //Creating new views (invoked by Layout Manager according to
    // developer.android.com)
    @Override
    public ResultsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType){
        //creating new view

        TextView v = (TextView)  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_results, parent, false);//just put activity
        // results because my_text_view wasn't working and creating app crash
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        //get element from dataset at position
        //replace contents of view with the element
        holder.textView.setText(mDataset[position]);
    }

    //Returning dataset size(layout manager)
    @Override
    public int getItemCount(){
        return mDataset.length;
    }
}
