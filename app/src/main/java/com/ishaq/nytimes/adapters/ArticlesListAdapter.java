package com.ishaq.nytimes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ishaq.nytimes.ArticleDetailsActivity;
import com.ishaq.nytimes.R;
import com.ishaq.nytimes.databinding.ArticlesListItemBinding;
import com.ishaq.nytimes.model.Article;
import com.ishaq.nytimes.model.MediaMetaData;

import java.util.ArrayList;

public class ArticlesListAdapter extends RecyclerView.Adapter<ArticlesListAdapter.ArticleViewHolder> {

    private Context mContext;
    private ArrayList<Article> mArticles;

    public ArticlesListAdapter(Context context, ArrayList<Article> articles){
        mContext= context;
        mArticles= articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(mContext).inflate(R.layout.articles_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.bind(mArticles.get(position));
    }

    @Override
    public int getItemCount() {
        return mArticles==null?0:mArticles.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{

        private ArticlesListItemBinding binding;
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= ArticlesListItemBinding.bind(itemView);
        }

        public void bind(Article article){
            binding.titleText.setText(article.getTitle());
            binding.authorText.setText(article.getSource());
            binding.dateText.setText(article.getPublishedDate());

            String thumbUrl= article.getImageUrlByFormat(MediaMetaData.FORMAT_STANDARD_THUMBNAIL);
            Glide.with(mContext)
                    .load(thumbUrl)
                    .placeholder(R.drawable.aritcle_thumb_placeholder)
                    .into(binding.thumpImage);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.startActivity(ArticleDetailsActivity.getArticleIntent(mContext,article));
                }
            });
        }
    }
}
