package cn.dashingqi.com.imitatejdscroll;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/5<p>
 * <p>更改时间：2018/12/5<p>
 * <p>版本号：1<p>
 */
public class FragmentContent extends Fragment implements IGetData {

    private TextView tvContent;
    private String datas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, container, false);
        tvContent = view.findViewById(R.id.tv_content);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!TextUtils.isEmpty(datas)){
            tvContent.setText(datas);
        }

    }

    @Override
    public void getData(String data) {
        datas = data;
    }
}
