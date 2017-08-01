package com.waris.hellorecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//1 implements CustomerAdapter.ListItemClickListener
public class MainActivity extends AppCompatActivity implements CustomerAdapter.ListItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    //2
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //สร้าง recyclerVeiw ขึ้นมา
        mRecyclerView = (RecyclerView) findViewById(R.id.rvR);
        //สร้าง Layout Manager
        mlayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setHasFixedSize(true);

        //set layout manager ให้กับ recyclerView
        mRecyclerView.setLayoutManager(mlayoutManager);

        //กำหนด Adapter ให้ recyclerView
        // 1.สร้าง new adapter จาก CustomerAdapter ที่สร้างไว้
        mAdapter = new CustomerAdapter(this,initPlayer(), this);
        // 2.set Adapter ให้ recyclerView
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



    //2
    @Override
    public void onListItemClick(int clickedItemIndex) {

        if(mToast != null){
            mToast.cancel();
        }

        String toastMessage = "Item #"+ clickedItemIndex +" clicked.";
        mToast = Toast.makeText(this,toastMessage,Toast.LENGTH_LONG);
        mToast.show();



    }
}
