package cn.dashingqi.com.lzjfragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/11/29<p>
 * <p>更改时间：2018/11/29<p>
 * <p>版本号：1<p>
 */
public class BaseFragment extends Fragment {

    private TabLayout mBaseTableLayout;
    private ViewPager mViewPager;
    public static final int TYPE_0 = 0;
    public static final int TYPE_1 = 1;
    private List<String> mTitleList;
    private List<Fragment> mList;
    private BaseViewPagerAdapter viewPagerAdapter;

    public static BaseFragment getInstance(int type) {
        BaseFragment baseFragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        baseFragment.setArguments(bundle);
        return baseFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBaseTableLayout = view.findViewById(R.id.mBaseTableLayout);
        mViewPager = view.findViewById(R.id.mViewPager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int type = getData();
        setData(type);


    }


    private int getData() {
        Bundle bundle = getArguments();
        int type = bundle.getInt("type");
        return type;
    }

    private void setData(int type) {
        switch (type) {
            case TYPE_0:
                //IT
                mTitleList = new ArrayList<>();
                mTitleList.add("Java");
                mTitleList.add("IOS");
                mTitleList.add("Python");
                mList = new ArrayList<>();
                mList.add(SubFragment.getInstance("Java页面"));
                mList.add(SubFragment.getInstance("IOS页面"));
                mList.add(SubFragment.getInstance("Python页面"));
                viewPagerAdapter = new BaseViewPagerAdapter(getChildFragmentManager(), mTitleList, mList);
                mViewPager.setAdapter(viewPagerAdapter);
                mBaseTableLayout.setupWithViewPager(mViewPager);
                break;
            case TYPE_1:
                //人物
                mTitleList = new ArrayList<>();
                mTitleList.add("帅哥");
                mTitleList.add("美女");
                mTitleList.add("娃娃");
                mList = new ArrayList<>();
                mList.add(SubFragment.getInstance("帅哥页面"));
                mList.add(SubFragment.getInstance("美女页面"));
                mList.add(SubFragment.getInstance("娃娃页面"));
                viewPagerAdapter = new BaseViewPagerAdapter(getChildFragmentManager(), mTitleList, mList);
                mViewPager.setAdapter(viewPagerAdapter);
                mBaseTableLayout.setupWithViewPager(mViewPager);
                break;
        }
    }

}
