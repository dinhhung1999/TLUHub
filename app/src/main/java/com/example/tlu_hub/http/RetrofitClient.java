package com.example.tlu_hub.http;


import com.example.tlu_hub.BuildConfig;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    protected static OkHttpClient httpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            builder.addInterceptor(logging);
        }
        builder.addInterceptor(new AuthenticateInterceptor());
        return builder.build();
    }


    static OkHttpClient client = httpClient();


    private static Retrofit retrofit=null;
    public static Retrofit getRetrofitClient(String baseUrl){
        if (retrofit==null){
            Retrofit.Builder builder = new   Retrofit.Builder();
            builder.baseUrl(baseUrl);
            builder.addConverterFactory(GsonConverterFactory.create());
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            if (client != null) {
                builder.client(client);
            }
            retrofit = builder.build();
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    client != null ?
//                    .client(client)
//                    :
//                    .build();
        }
        return retrofit;
    }
}
