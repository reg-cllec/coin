package com.example.recyclerview002;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DataAdapterPrice extends RecyclerView.Adapter<DataAdapterPrice.ViewHolder> {
    private ArrayList<AndroidVersion> android_versions;
    private Context context;

    public DataAdapterPrice(Context context, ArrayList<AndroidVersion> android_versions) {
        this.context = context;
        this.android_versions = android_versions;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.price_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_price.setText(android_versions.get(i).getAndroid_version_name());
        viewHolder.tv_updated.setText(android_versions.get(i).getAndroid_updated());
//        viewHolder.img_agent.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background));
//        Picasso
//            .with(context)
//            .load(android_versions.get(i).getAndroid_image_url())
//            .resize(120, 60).into(viewHolder.img_agent);

        Glide
            .with(context)
            .load(android_versions.get(i).getAndroid_image_url())
            .placeholder(R.drawable.ic_launcher_background)
            .override(200, 200)
            .centerCrop()
            .into(viewHolder.img_agent);

//        viewHolder.img_agent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context context = v.getContext();
//                Intent intent = new Intent(context, FullImageActivity.class);
//                intent.putExtra("url", "coin base");
//                intent.putExtra("title", "title");
//                context.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_price;
        TextView tv_updated;
        ImageView img_agent;
        public ViewHolder(View view) {
            super(view);

            tv_price = (TextView)view.findViewById(R.id.tv_price);
            tv_updated = (TextView)view.findViewById(R.id.tv_updated);
            img_agent = (ImageView)view.findViewById(R.id.img_agent);
        }
    }
}