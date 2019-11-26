package com.example.administrator.l_net.net;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2019/11/25.
 */

public class ExceptionEngine {
    public static void handleException(Context context, Throwable t){
        if (t instanceof ServerException){
            switch (((ServerException) t).getCode()){
                case 2:
                    Toast.makeText(context,"页码参数不正确！",Toast.LENGTH_LONG).show();
            }
        }
    }
}
