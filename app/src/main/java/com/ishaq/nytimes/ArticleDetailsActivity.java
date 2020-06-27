package com.ishaq.nytimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ishaq.nytimes.databinding.ActivityArticleDetailsBinding;
import com.ishaq.nytimes.model.Article;
import com.ishaq.nytimes.model.MediaMetaData;

public class ArticleDetailsActivity extends AppCompatActivity {
    private static String EXTRA_ARTICLE="extraArticle";

    public static Intent getArticleIntent(Context context, Article article){
        Intent i= new Intent(context,ArticleDetailsActivity.class);
        i.putExtra(EXTRA_ARTICLE,article);
        return i;
    }

    ActivityArticleDetailsBinding binding;
    private Article mArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityArticleDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mArticle= getIntent().getParcelableExtra(EXTRA_ARTICLE);
        if(mArticle==null){
            Toast.makeText(this,R.string.article_not_found,Toast.LENGTH_LONG).show();
            return;
        }

        binding.titleText.setText(mArticle.getTitle());
        binding.abstractText.setText(mArticle.getAbstractStr());
        binding.dateText.setText(mArticle.getPublishedDate());

        Glide.with(this)
                .load(mArticle.getImageUrlByFormat(MediaMetaData.FORMAT_MEDIUM_THREE_BY_TWO_440))
                .into(binding.image);
    }
}