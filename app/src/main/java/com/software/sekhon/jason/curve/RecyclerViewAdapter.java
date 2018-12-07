package com.software.sekhon.jason.curve;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.sekhon.jason.curve.MyDB.Player;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private List<Player> players;
    private Context mContext;

    public RecyclerViewAdapter(List<Player> players, Context mContext) {
        Log.d(TAG, "CONSTRUCTOR: called");
        this.players = players;
        this.mContext = mContext;
    }

    public void swap(List list){
        if (players != null) {
            players.clear();
            players.addAll(list);
        }
        else {
            players = list;
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext).asBitmap().load(players.get(i).headshotURL).into(viewHolder.image);
        viewHolder.playerName.setText(players.get(i).lastName + ", " + players.get(i).firstName);
        viewHolder.position.setText(players.get(i).position);
        viewHolder.curveName.setText(players.get(i).brand + " " + players.get(i).curveName);
        viewHolder.parentLayout.setId(i);
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Description.class);
                intent.putExtra("Player", players.get(i));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView playerName;
        TextView position;
        TextView curveName;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            playerName = itemView.findViewById(R.id.playerName);
            curveName = itemView.findViewById(R.id.curve);
            position = itemView.findViewById(R.id.position);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
