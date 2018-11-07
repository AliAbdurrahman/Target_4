package id.papapaok.aliabdurrahman.indonesianews4.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.papapaok.aliabdurrahman.indonesianews4.DetailActivity;
import id.papapaok.aliabdurrahman.indonesianews4.MainActivity;
import id.papapaok.aliabdurrahman.indonesianews4.Model.ArticlesItem;
import id.papapaok.aliabdurrahman.indonesianews4.R;

/**
 * Created by AliAbdurrahman on 11/5/18.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private final Context context;
    private final List<ArticlesItem> articlesItems;

    public MainAdapter(Context context, List<ArticlesItem> data) {
        this.context = context;
        this.articlesItems = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.mainitem, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.titleMain.setText(articlesItems.get(i).getTitle());
        myViewHolder.publisherMain.setText(articlesItems.get(i).getPublishedAt());
        Glide.with(context)
                .load(articlesItems.get(i).getUrlToImage())
                .into(myViewHolder.imgMain);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", articlesItems.get(i).getTitle());
                intent.putExtra("publish", articlesItems.get(i).getPublishedAt());
                intent.putExtra("content", articlesItems.get(i).getContent());
                intent.putExtra("gambar", articlesItems.get(i).getUrlToImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleMain, publisherMain;
        ImageView imgMain;

        public MyViewHolder(View itemView) {
            super(itemView);

            imgMain = itemView.findViewById(R.id.imgMain);
            titleMain = itemView.findViewById(R.id.titleMain);
            publisherMain = itemView.findViewById(R.id.publisherMain);

        }
    }
}
