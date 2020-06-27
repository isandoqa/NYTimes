package com.ishaq.nytimes.api;

import com.ishaq.nytimes.model.ArticlesResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("svc/mostpopular/v2/viewed/7.json")
    Observable<ArticlesResponse> getPopularArticles(@Query("api-key")String apiKey);
}
