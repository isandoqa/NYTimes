package com.ishaq.nytimes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ishaq.nytimes.adapters.ArticlesListAdapter;
import com.ishaq.nytimes.api.ApiController;
import com.ishaq.nytimes.databinding.ActivityMainBinding;
import com.ishaq.nytimes.model.Article;
import com.ishaq.nytimes.model.ArticlesResponse;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadArticles();
    }

    private void loadArticles() {
        binding.progressBar.setVisibility(View.VISIBLE);
        Observable<ArticlesResponse> observable= ApiController.getPopularArticles(getString(R.string.ny_api_key));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result ->result.getResults())
                .subscribe(this::handleResult, this::handleError);
    }

    private void handleResult(ArrayList<Article> articles){
        binding.progressBar.setVisibility(View.GONE);
        if(articles==null||articles.isEmpty()){
            Toast.makeText(this,R.string.empty_articles, Toast.LENGTH_LONG).show();
        }else{
            ArticlesListAdapter adapter= new ArticlesListAdapter(this,articles);
            LinearLayoutManager manager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            binding.recycler.setLayoutManager(manager);
            binding.recycler.setAdapter(adapter);
        }
    }
    private void handleError(Throwable t){
        binding.progressBar.setVisibility(View.GONE);
        t.printStackTrace();
        Toast.makeText(this,t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }
}