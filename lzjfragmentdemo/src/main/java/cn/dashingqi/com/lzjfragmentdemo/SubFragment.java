package cn.dashingqi.com.lzjfragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/11/29<p>
 * <p>更改时间：2018/11/29<p>
 * <p>版本号：1<p>
 */
public class SubFragment extends Fragment {
    public static  final String TAG = SubFragment.class.getSimpleName();

    private TextView tvText;
    private String text;
    private View rootView;
    private boolean isFragmentVisible;
    private boolean isReuseView;
    private boolean isFirstVisible;


    public static SubFragment getInstance(String text){
        SubFragment subFragment = new SubFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        subFragment.setArguments(bundle);
        return subFragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Logger.t(String.valueOf(Thread.currentThread())).d("setUserVisibleHint = "+isVisibleToUser);
        if (rootView==null)
            return;
        if (isFirstVisible&&isVisibleToUser){
            onFragmentFirstVisible();
            isFirstVisible = false;

        }

       if (isVisibleToUser){
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
            return;
       }

       if (isFragmentVisible){
            isFragmentVisible = false;
            onFragmentVisibleChange(false);
       }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.t(String.valueOf(Thread.currentThread())).d("onCreate");
        initVariable();

    }

    private void initVariable() {
        //第一次显示
        isFirstVisible = true;
        //Fragment可见了
        isFragmentVisible = false;
        rootView = null;
        isReuseView = true;
    }

    /**
     * 设置是否使用 view 的复用，默认开启
     * view 的复用是指，ViewPager 在销毁和重建 Fragment 时会不断调用 onCreateView() -&gt; onDestroyView()
     * 之间的生命函数，这样可能会出现重复创建 view 的情况，导致界面上显示多个相同的 Fragment
     * view 的复用其实就是指保存第一次创建的 view，后面再 onCreateView() 时直接返回第一次创建的 view
     *
     * @param isReuse
     */
    protected void reuseView(boolean isReuse) {
        isReuseView = isReuse;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (rootView == null) {
            rootView = view;
            //此时为true
            if (getUserVisibleHint()) {
                //第一次 为 true
                Logger.t(String.valueOf(Thread.currentThread())).i("isFirstVisible = "+isFirstVisible+" thread = "+Thread.currentThread());
                if (isFirstVisible) {
                    onFragmentFirstVisible();
                    isFirstVisible = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;
            }
        }
        Logger.t(String.valueOf(Thread.currentThread())).d("onViewCreated");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.t(String.valueOf(Thread.currentThread())).d("onCreateView");
        View view = inflater.inflate(R.layout.fragment_sub, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.t(String.valueOf(Thread.currentThread())).d("onActivityCreated");
    }

    private void initView(View view) {
        tvText = view.findViewById(R.id.tvText);
    }

    /**
     * 在fragment首次可见时回调，可在这里进行加载数据，保证只在第一次打开Fragment时才会加载数据，
     * 这样就可以防止每次进入都重复加载数据
     * 该方法会在 onFragmentVisibleChange() 之前调用，所以第一次打开时，可以用一个全局变量表示数据下载状态，
     * 然后在该方法内将状态设置为下载状态，接着去执行下载的任务
     * 最后在 onFragmentVisibleChange() 里根据数据下载状态来控制下载进度ui控件的显示与隐藏
     */
    protected void onFragmentFirstVisible() {
        //去获取数据
        text = getArguments().getString("text");
        Logger.t(String.valueOf(Thread.currentThread())).d("text = "+ text);

    }

    /**
     * 去除setUserVisibleHint()多余的回调场景，保证只有当fragment可见状态发生变化时才回调
     * 回调时机在view创建完后，所以支持ui操作，解决在setUserVisibleHint()里进行ui操作有可能报null异常的问题
     *
     * 可在该回调方法里进行一些ui显示与隐藏，比如加载框的显示和隐藏
     *
     * @param isVisible true  不可见 -&gt; 可见
     *                  false 可见  -&gt; 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible) {
        //设置数据
        if (isVisible){
            if(!TextUtils.isEmpty(text)){
                tvText.setText(text);
            }
        }
    }
}
