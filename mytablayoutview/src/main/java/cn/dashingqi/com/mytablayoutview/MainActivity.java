package cn.dashingqi.com.mytablayoutview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabHeard mTabHeard;
    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        mTitleList = new ArrayList<>();
        mTitleList.add("标题一");
        mTitleList.add("标题二");
        mTitleList.add("标题三");

        mFragmentList = new ArrayList<>();
        mFragmentList.add(FragmentOne.newInstance("fragment_one","1"));
        mFragmentList.add(FragmentOne.newInstance("fragment_two","2"));
        mFragmentList.add(FragmentOne.newInstance("fragment_three","3"));

        mTabHeard.configTabLayout(mTitleList,mFragmentList,getSupportFragmentManager(),false);
    }

    private void initView() {
        mTabHeard = findViewById(R.id.mTabHeard);
    }
}
