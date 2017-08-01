package com.waris.hellorecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    public TextView tvName;
    public TextView tvClub;
    public ImageView imvPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = (TextView) findViewById(R.id.tvNamePlayer);
        tvClub = (TextView) findViewById(R.id.tvClubPlayer);
        imvPlayer = (ImageView) findViewById(R.id.imvPlayer);

        Intent intentStartActivity = getIntent();
        if(intentStartActivity.hasExtra("playerName")){


            int[] myPlayer = {R.drawable.messi,R.drawable.ronaldo,R.drawable.suarez};

            String strName= getIntent().getStringExtra("playerName");
            String strClub= getIntent().getStringExtra("clubName");
            int noPlayer= getIntent().getIntExtra("noPlayer",0);

            tvName.setText(strName);
            tvClub.setText(strClub);

            for(int i=0;i< myPlayer.length;i++) {
                if(i == noPlayer) {
                    imvPlayer.setImageResource(myPlayer[i]);
                }
            }

        }else{

            tvName.setText("Messi");
            tvClub.setText("Bacelona");
            imvPlayer.setImageResource(R.drawable.messi);
        }



    }
}
