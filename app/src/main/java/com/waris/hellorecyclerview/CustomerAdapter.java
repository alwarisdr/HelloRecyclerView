package com.waris.hellorecyclerview;

import android.content.Context;
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

    //Constructor
    public CustomerAdapter(Context context,List<Player> dataset) {
        this.mContext = context;
        this.mPlayers = dataset;
    }

    //สรา้ง ViewHolder ขึ้นมา
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mName;
        public TextView mClub;

        //Constructor
        public ViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.tvName);
            mClub = (TextView) itemView.findViewById(R.id.tvClub);

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
