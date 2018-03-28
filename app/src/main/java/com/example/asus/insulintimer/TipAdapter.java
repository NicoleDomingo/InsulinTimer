package com.example.asus.insulintimer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Mharjorie Sandel on 09/03/2018.
 */

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.MyViewHolder> {

    private List<Tip> tipList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title,desc,read;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_tiptitle);
            desc = (TextView) itemView.findViewById(R.id.tv_tipdesc);
            read = (TextView) itemView.findViewById(R.id.tv_read);
            image = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public TipAdapter(List<Tip> tipList) {
        this.tipList = tipList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tip_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tip t = tipList.get(position);
        holder.title.setText(t.getTitle());
        holder.desc.setText(t.getDesc());

    }
    @Override
    public int getItemCount() {
        return tipList.size();
    }



}
