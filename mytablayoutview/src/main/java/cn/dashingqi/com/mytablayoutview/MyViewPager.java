package cn.dashingqi.com.mytablayoutview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/4<p>
 * <p>更改时间：2018/12/4<p>
 * <p>版本号：1<p>
 */
public class MyViewPager extends ViewPager {
    private boolean isCanScroll = false;

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNoScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    /**
     * @param ev
     * @return 返回false表示不拦截此事件
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("isCanScroll", "isCanScroll = " + isCanScroll);
        if (isCanScroll)
            return super.onInterceptTouchEvent(ev);
        else
            return false;
    }

    /**
     * @param ev
     * @return 返回false 表示不消耗此事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d("isCanScroll", "isCanScroll = " + isCanScroll);
        if (isCanScroll)
            return super.onTouchEvent(ev);
        else
            return false;
    }
}
