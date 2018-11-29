package cn.dashingqi.com.fragmenttofragmentwithlistener;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.dashingqi.com.fragmenttofragmentwithlistener.frragment.FragmentOne;
import cn.dashingqi.com.fragmenttofragmentwithlistener.frragment.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrameViewOne;
    private FrameLayout mFrameViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        replaceView();
    }

    private void replaceView() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameView1,new FragmentOne(),"fragment_one");
        transaction.replace(R.id.frameView2,new FragmentTwo(),"fragment_two");
        transaction.commit();
    }

    private void initView() {
        mFrameViewOne = findViewById(R.id.frameView1);
        mFrameViewTwo = findViewById(R.id.frameView2);
    }
}
