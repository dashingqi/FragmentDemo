package cn.dashingqi.com.fragmenttoactivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ISendMsgListener {

    private FrameLayout mFrameView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        replaceFragmentOne();
    }

    private void replaceFragmentOne() {
        FragmentManager manger = getSupportFragmentManager();
        FragmentTransaction transaction = manger.beginTransaction();
        transaction.replace(R.id.frameView,new FragmentOne());
        transaction.commit();
    }

    private void initView() {
        mFrameView = findViewById(R.id.frameView);
        mTextView = findViewById(R.id.textView);
    }

    @Override
    public void sendMsg(String msg) {
        if (msg != null)
            mTextView.setText(msg);
    }
}
