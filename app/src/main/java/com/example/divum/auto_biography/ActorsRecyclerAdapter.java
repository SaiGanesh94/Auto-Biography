package com.example.divum.auto_biography;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by divum.
 */
public class ActorsRecyclerAdapter  extends RecyclerView.Adapter<ActorsRecyclerAdapter.SimpleViewHolder>{

    private Context mContext;
    private ArrayList<ActorsEntity> mActorsList;

    public ActorsRecyclerAdapter(Context context,ArrayList<ActorsEntity> mActorsList){
        mContext=context;
        this.mActorsList=mActorsList;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.actors_list_item,parent,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        ActorsEntity actorsEntity= mActorsList.get(position);
        holder.mName.setText(actorsEntity.getmName());
        holder.mAge.setText( String.valueOf(actorsEntity.getmAge()));
        holder.mImage.setImageResource(R.drawable.vijay);
        holder.mDesc.setText(actorsEntity.getmDesc());
    }

    @Override
    public int getItemCount() {
        return mActorsList.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_actors)
        ImageView mImage;

        @Bind(R.id.tv_setName)
        TextView mName;

        @Bind(R.id.tv_setAge)
        TextView mAge;

        @Bind(R.id.tv_setDesc)
        TextView mDesc;

        public SimpleViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
