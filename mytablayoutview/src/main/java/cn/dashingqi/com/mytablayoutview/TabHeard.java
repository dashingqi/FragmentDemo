package cn.dashingqi.com.mytablayoutview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/4<p>
 * <p>更改时间：2018/12/4<p>
 * <p>版本号：1<p>
 */
public class TabHeard extends LinearLayout {
    private Context mContext;
    //标题栏
    private List<String> mTitleList = new ArrayList<>();
    //Fragment 页面
    private List<Fragment> mFragmentList = new ArrayList<>();
    private TabLayout mTabLayout;
    private MyViewPager mViewPager;
    private MyViewPagerAdapter myViewPagerAdapter;

    public TabHeard(Context context) {
        this(context, null);

    }

    public TabHeard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabHeard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.layout_tab_heard, this);
        initViews();
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        mTabLayout = findViewById(R.id.mTabLayout);
        mViewPager = findViewById(R.id.mViewPager);

    }

    /**
     * 配置TabLayout
     *
     * @param titleList    标题栏
     * @param fragmentList Fragment页面数
     * @param fm
     * @param canScroll    控制ViewPager是否能够滑动
     */
    public void configTabLayout(List<String> titleList, List<Fragment> fragmentList, FragmentManager fm, boolean canScroll) {
        mTitleList.clear();
        mTitleList.addAll(titleList);
        mFragmentList.clear();
        mFragmentList.addAll(fragmentList);

        if (myViewPagerAdapter == null)
            myViewPagerAdapter = new MyViewPagerAdapter(fm, mTitleList, mFragmentList);

        mViewPager.setAdapter(myViewPagerAdapter);
        mViewPager.setNoScroll(canScroll);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    /**
     * 获取到当前选择的位置
     *
     * @return
     */
    public int getSelectedChildPosition() {
        return mTabLayout.getSelectedTabPosition();
    }

    /**
     * 是否展示TabLayout
     *
     * @param isVisible
     */
    public void isShowTabLayout(boolean isVisible) {
        mTabLayout.setVisibility(isVisible ? VISIBLE : GONE);
    }

    /**
     * 提供TabLayout切换事件
     *
     * @param listener
     */
    public void addOnTabChangedListener(TabLayout.BaseOnTabSelectedListener listener) {
        mTabLayout.addOnTabSelectedListener(listener);
    }

}
