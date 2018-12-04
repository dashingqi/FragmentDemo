package cn.dashingqi.com.mytablayoutview;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/4<p>
 * <p>更改时间：2018/12/4<p>
 * <p>版本号：1<p>
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mTitleList;
    private List<Fragment> mFragmentList;
    public MyViewPagerAdapter(FragmentManager fm,List<String> mTitleList,List<Fragment> mFragmentList) {
        super(fm);
        this.mTitleList = mTitleList;
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTitleList.size();
    }

    @Nullable
    @Override
    public String getPageTitle(int position) {
        return mTitleList.size()==0 ? "" : mTitleList.get(position);
    }
}
