package com.waris.hellorecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvR);
        mlayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(mlayoutManager);

        mAdapter = new CustomerAdapter(this,initPlayer());
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<Player> initPlayer() {
        Player messi = new Player("Leonel messi","Bacelona");
        Player ronaldo = new Player("Cristiano Ronaldo", "Real Madrid");
        Player suarez = new Player("Luis Suarez", "Liverpool");

        List<Player> dataset = new ArrayList<Player>();
        dataset.add(messi);
        dataset.add(ronaldo);
        dataset.add(suarez);

        return dataset;
    }
}
