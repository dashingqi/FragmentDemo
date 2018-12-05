package cn.dashingqi.com.imitatejdscroll;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Goods> goodsList = new ArrayList<>();
    private FrameLayout mFrameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        MyAdapter myAdapter = new MyAdapter(this, goodsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new FragmentContent());
        initFragment();
    }

    private void initFragment() {

    }

    private void initData() {
        for (int i = 0; i <= 20; i++) {
            Goods goods = new Goods("常用菜单" + i, i);
            goodsList.add(goods);
        }
    }


    private void initViews() {
        mRecyclerView = findViewById(R.id.mRecyclerView);

    }
}
