package com.example.administrator.l_net.net;


import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2019/11/25.
 */

public class MyFunction<T> implements Function<HttpResult<T>,T> {
    @Override
    public T apply(@NonNull HttpResult<T> tHttpResult) throws Exception {
        if(tHttpResult.getCode()!=0){
            throw new ServerException(tHttpResult.getCode(),tHttpResult.getMessage());
        }else{
            return tHttpResult.getData();
        }
    }
}
