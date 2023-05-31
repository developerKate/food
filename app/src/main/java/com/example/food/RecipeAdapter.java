package com.example.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.FoodViewHolder> {
    private Context context;

    public RecipeAdapter(Context context, List<root.Hits> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    private List<root.Hits> recipes;
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipe, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.label.setText(recipes.get(position).getRecipe().getLabel());
        Glide.with(holder.itemView.getContext()).load(recipes.get(position).getRecipe().getImage()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (recipes != null){
            return recipes.size();
        }
        return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView label;
        ImageView imageView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.text_label);
            imageView = itemView.findViewById(R.id.recipeImg);
        }
    }

}
