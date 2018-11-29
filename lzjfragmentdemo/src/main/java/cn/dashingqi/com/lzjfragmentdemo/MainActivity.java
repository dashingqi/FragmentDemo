package cn.dashingqi.com.lzjfragmentdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private RelativeLayout mRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTabLayout();
    }

    /**
     * 初始化TabLayout
     */
    private void initTabLayout() {
        //为TabLayout填充数据
        mTabLayout.addTab(mTabLayout.newTab().setText("IT"));
        mTabLayout.addTab(mTabLayout.newTab().setText("人物"));
        setCurrentPage(0);
        //默认选中第一个
        mTabLayout.getTabAt(0).select();

        mTabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切换不同的选项卡，子布局展示不同的布局
                setCurrentPage(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setCurrentPage(int position) {
        FragmentManager manage = getSupportFragmentManager();
        FragmentTransaction transaction = manage.beginTransaction();
        switch (position) {
            case 0:
                transaction.replace(R.id.mRelativeLayout, BaseFragment.getInstance(BaseFragment.TYPE_0));
                break;
            case 1:
                transaction.replace(R.id.mRelativeLayout, BaseFragment.getInstance(BaseFragment.TYPE_1));
                break;
        }
        transaction.commit();


    }

    /**
     * 初始化控件
     */
    private void initView() {
        mTabLayout = findViewById(R.id.mTabLayout);
        mRelativeLayout = findViewById(R.id.mRelativeLayout);
    }
}
