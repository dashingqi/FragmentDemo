package cn.dashingqi.com.lzjfragmentdemo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/11/29<p>
 * <p>更改时间：2018/11/29<p>
 * <p>版本号：1<p>
 */
public class BaseViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> mTitleList;
    private List<Fragment> mContentList;

    public BaseViewPagerAdapter(FragmentManager fm, List<String> mTitlList, List<Fragment> mContentList) {
        super(fm);
        this.mTitleList = mTitlList;
        this.mContentList = mContentList;
    }

    @Override
    public Fragment getItem(int i) {
        return mContentList.get(i);
    }

    @Override
    public int getCount() {
        return mContentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList == null ? "" : mTitleList.get(position);
    }
}
