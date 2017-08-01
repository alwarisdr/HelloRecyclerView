package com.waris.hellorecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alwaris on 7/17/17.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>{

    private Context mContext;
    private List<Player> mPlayers;

    //3
    final private ListItemClickListener mOnClickListener;


    //1
    public interface ListItemClickListener{
        //2
        void onListItemClick(int clickedItemIndex);
    }

    //Constructor
    public CustomerAdapter(Context context,List<Player> dataset,ListItemClickListener listener) {
        //4
        this.mOnClickListener = listener;
        this.mContext = context;
        this.mPlayers = dataset;
    }

    //สรา้ง ViewHolder ขึ้นมา
    //5 implements View.OnClickListener ในกรณีที่ต้องการ click ได้
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mName;
        public TextView mClub;
        String strName;
        String strClub;
        int playerNo;

        //Constructor
        public ViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.tvName);
            mClub = (TextView) itemView.findViewById(R.id.tvClub);

            //7
            itemView.setOnClickListener(this);

        }

        //6
        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            //ส่ง ให้
            mOnClickListener.onListItemClick(clickedPosition);


            Intent i = new Intent(mContext, ProfileActivity.class);
            strName = mName.getText().toString();
            strClub = mClub.getText().toString();
            playerNo = clickedPosition;


            i.putExtra("playerName",strName);
            i.putExtra("clubName",strClub);
            i.putExtra("noPlayer",playerNo);

            mContext.startActivity(i);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.rv_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Player player = mPlayers.get(position);
        viewHolder.mName.setText(player.getName());
        viewHolder.mClub.setText(player.getClub());
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }
}
