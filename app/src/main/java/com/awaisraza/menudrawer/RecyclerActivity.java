package com.awaisraza.menudrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private ArrayList<Items> mTestItemList;

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();



            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            Items thisItem = mTestItemList.get(position);
                Toast.makeText(RecyclerActivity.this, "You Clicked: " + thisItem.getPicurl(), Toast.LENGTH_SHORT).show();
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result3",thisItem.getPicurl());
            returnIntent.putExtra("result",thisItem.getFname());
            returnIntent.putExtra("result2",thisItem.getLname());
            setResult(Activity.RESULT_OK,returnIntent);
            finish();



        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        mTestItemList = new ArrayList<>();
        Items testItem ;

        testItem = new Items(R.drawable.aboutus,"about","us");
        mTestItemList.add(testItem);

        testItem = new Items(R.drawable.globalnews,"global","news");
        mTestItemList.add(testItem);

        testItem = new Items(R.drawable.twitter,"twitter","nws");
        mTestItemList.add(testItem);




        MyAdapter recyclerViewAdapter = new MyAdapter(this,mTestItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        recyclerView.setAdapter(recyclerViewAdapter);
        //TODO: Step 1 of 4: Create and set OnItemClickListener to the adapter.
        recyclerViewAdapter.setOnItemClickListener(onItemClickListener);

    }
}