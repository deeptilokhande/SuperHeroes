package com.deep.superheroes;

import android.content.Context;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class SuperHeroesRecyclerViewAdapter extends RecyclerView.Adapter<SuperHeroesRecyclerViewAdapter.SuperHeroViewHolder> {
List<SuperHero> msuperHeroList;
Context mContext;

SuperHeroesRecyclerViewAdapter(List<SuperHero> superHeroList, Context context) {
     msuperHeroList = superHeroList;
     mContext=context;
}
    @NonNull
    @Override
    public SuperHeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_of_recyclerview,viewGroup,false);
       return new SuperHeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroViewHolder superHeroViewHolder, int i) {
    final SuperHero currentHero = msuperHeroList.get(i);
     superHeroViewHolder.name.setText(currentHero.getName());
     superHeroViewHolder.details.setText(currentHero.getBio());
        Picasso.get()
                .load(currentHero.getImageurl())
                .into(superHeroViewHolder.image);

        superHeroViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext,"You clicked"+currentHero.getName(),Toast.LENGTH_SHORT).show();

                Intent newIntent = new Intent(mContext,DetailsActivity.class);
                newIntent.putExtra("publisher",currentHero.getPublisher());
                newIntent.putExtra("createdBy",currentHero.getCreatedby());
                newIntent.putExtra("firstappearance",currentHero.getFirstappearance());

                startActivity(mContext,newIntent,null);

            }
        });
    }

    @Override
    public int getItemCount() {
        return msuperHeroList.size();
    }

    public static class SuperHeroViewHolder extends RecyclerView.ViewHolder{
         ImageView image;
         TextView name;
         TextView details;
         CardView cardView;
        public SuperHeroViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
            details = itemView.findViewById(R.id.textView2);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
