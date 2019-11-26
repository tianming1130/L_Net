package com.example.administrator.l_net.net;



import com.example.administrator.l_net.bean.Menu;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/11/12.
 */

public class RetrofitUtil {
    private static RetrofitUtil mRetrofitUtil;
    private static final String BASE_URL="http://10.0.2.2/";
    private ApiService mApiService;

    private RetrofitUtil(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApiService=retrofit.create(ApiService.class);
    }
    public static RetrofitUtil getInstance(){
        if (mRetrofitUtil==null){
            mRetrofitUtil=new RetrofitUtil();
        }
        return mRetrofitUtil;
    }

    public void getMenus(Subscriber<List<Menu>> subscriber , String page){
        Flowable<HttpResult<List<Menu>>> flowable=mApiService.getMenus(page);
//        call.enqueue(callback);
        flowable.map(new MyFunction<List<Menu>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }


}
