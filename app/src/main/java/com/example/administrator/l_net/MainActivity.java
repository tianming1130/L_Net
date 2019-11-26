package com.example.administrator.l_net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.l_net.adapter.MenuAdapter;
import com.example.administrator.l_net.bean.Menu;
import com.example.administrator.l_net.net.ExceptionEngine;
import com.example.administrator.l_net.net.HttpResult;
import com.example.administrator.l_net.net.RetrofitUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG ="MainActivity" ;
    private Button mBtnGetData;
    private RecyclerView mRecyclerView;
    private EditText mPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGetData=(Button)findViewById(R.id.btn_get_menu);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mPage=(EditText)findViewById(R.id.et_page);
        mBtnGetData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RetrofitUtil.getInstance().getMenus(new Subscriber<List<Menu>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(List<Menu> menus) {
                MenuAdapter menuAdapter=new MenuAdapter(R.layout.item_view,menus);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mRecyclerView.setAdapter(menuAdapter);
            }

            @Override
            public void onError(Throwable t) {
                ExceptionEngine.handleException(MainActivity.this,t);
            }

            @Override
            public void onComplete() {

            }
        },mPage.getText().toString());
    }
}
