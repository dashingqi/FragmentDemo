package cn.dashingqi.com.fragmenttofragmentwithlistener.frragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.dashingqi.com.fragmenttofragmentwithlistener.R;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/11/22<p>
 * <p>更改时间：2018/11/22<p>
 * <p>版本号：1<p>
 */
public class FragmentTwo extends Fragment {

    private TextView mTvContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvContent = view.findViewById(R.id.tv_content);
    }

    public void setData(String data) {
        if (data != null)
            mTvContent.setText(data);
    }

}
