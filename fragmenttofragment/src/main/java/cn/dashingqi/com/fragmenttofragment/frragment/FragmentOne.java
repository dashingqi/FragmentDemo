package cn.dashingqi.com.fragmenttofragment.frragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.dashingqi.com.fragmenttofragment.R;
import cn.dashingqi.com.fragmenttofragment.adapter.MyAdapter;
import cn.dashingqi.com.fragmenttofragment.model.Person;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/11/22<p>
 * <p>更改时间：2018/11/22<p>
 * <p>版本号：1<p>
 */
public class FragmentOne extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Person> personList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        initData();

        MyAdapter myAdapter = new MyAdapter(personList, getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        //加入分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(myAdapter);

    }

    private void initData() {
        personList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            personList.add(new Person("流川枫" + i, "年龄" + i));
        }

    }
}
