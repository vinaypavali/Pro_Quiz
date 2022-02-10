package com.quiz.proquiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.quiz.proquiz.QuizActivity;
import com.quiz.proquiz.R;
import com.quiz.proquiz.ResultActivity;
import com.quiz.proquiz.WalletFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    ArrayList<CategoryModel> categoryModels;


    public CategoryAdapter(Context context,ArrayList<CategoryModel> categoryModels)
    {
        this.context = context;
        this.categoryModels = categoryModels;

    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        CategoryModel categoryModel =categoryModels.get(position);
        holder.textView.setText(categoryModel.getCategoryName());
        Glide.with(context)
                .load(categoryModel.getCategoryImage())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,QuizActivity.class);
                i.putExtra("categoryId",categoryModel.getCategoryId());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

       private ImageView imageView;
        private TextView textView;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
          imageView =  itemView.findViewById(R.id.imagec);
          textView = itemView.findViewById(R.id.textc);

        }

    }
}
