package com.assignmentss.safehouse.data.remote.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitApiClass used to call Retrofit instance
 */
public class RetrofitAPI {
    /**
     * Create Retrofit instance
     *
     * @param baseUrl : URL to connect
     * @return Retrofit Instance
     */
    private static Retrofit getInstance(String baseUrl) {
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();

        httpBuilder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS);



        //Used while Development
        /*Todo when Releasing*/
        //if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
            httpBuilder.addInterceptor(interceptor);
       // }

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    /**
     * Call Retrofit instance based on different URLs
     *
     * @param baseUrl : URL to connect
     * @return NetworkApiCallInterface : reference To call API methods
     */
    public static APIService getRetrofitApiClass(String baseUrl) {
        return getInstance(baseUrl).create(APIService.class);
    }
}
