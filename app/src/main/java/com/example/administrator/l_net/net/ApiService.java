package com.example.administrator.l_net.net;

import com.example.administrator.l_net.bean.Menu;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2019/11/12.
 */

public interface ApiService {
    @GET("getmenu.php")
    Flowable<HttpResult<List<Menu>>> getMenus(@Query("page") String page);
}

