package cn.dashingqi.com.fragmenttofragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.dashingqi.com.fragmenttofragment.MainActivity;
import cn.dashingqi.com.fragmenttofragment.R;
import cn.dashingqi.com.fragmenttofragment.frragment.FragmentTwo;
import cn.dashingqi.com.fragmenttofragment.model.Person;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/11/22<p>
 * <p>更改时间：2018/11/22<p>
 * <p>版本号：1<p>
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Person> personList;
    private Context mContext;

    public MyAdapter(List<Person> personList, Context mContext) {
        this.personList = personList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_one_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Person person = personList.get(i);
        viewHolder.mName.setText(person.getName());
        viewHolder.mAge.setText(person.getAge());
        viewHolder.mAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) mContext;
                FragmentTwo fragmentTwo = (FragmentTwo) mainActivity.getSupportFragmentManager().findFragmentByTag("fragment_two");
                fragmentTwo.setData(person.getName()+" "+person.getAge());
            }
        });

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mAge;

        public ViewHolder(View view) {
            super(view);
            mName = view.findViewById(R.id.tv_name);
            mAge = view.findViewById(R.id.tv_age);
        }

    }
}
