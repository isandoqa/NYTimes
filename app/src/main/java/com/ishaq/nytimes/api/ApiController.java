package com.ishaq.nytimes.api;

import com.ishaq.nytimes.model.ArticlesResponse;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    private static Retrofit retrofit;
    private static ApiService apiService;

    private static ApiService getApiService(){
        if(apiService==null){
            if(retrofit==null){
                final String BASE_URL= "https://api.nytimes.com/";
                retrofit=new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            apiService=retrofit.create(ApiService.class);
        }
        return apiService;
    }

    public static Observable<ArticlesResponse> getPopularArticles(String apiKey){
        ApiService service= getApiService();
        return service.getPopularArticles(apiKey);
    }
}