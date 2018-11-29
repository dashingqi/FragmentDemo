package cn.dashingqi.com.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.dashingqi.com.fragmentdemo.fragment.FragmentOne;
import cn.dashingqi.com.fragmentdemo.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private Button btnAddFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddFragment = findViewById(R.id.btn_start_add_fragment);
        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFragment();
            }
        });
    }

    private void initFragment(){
        FragmentManager manager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl1, new FragmentOne());
        transaction.replace(R.id.fl2,new FragmentTwo());
        //transaction.add(R.id.fl2,new FragmentOne());
        //提交事务
        transaction.commit();
    }
}
