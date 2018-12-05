package cn.dashingqi.com.imitatejdscroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/5<p>
 * <p>更改时间：2018/12/5<p>
 * <p>版本号：1<p>
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Goods> goodsList;
    private IGetData iGetData;

    public void setOnItemClickListener(IGetData iGetData){
        this.iGetData = iGetData;
    }

    public MyAdapter(Context context, List<Goods> goodsList) {
        this.context = context;
        this.goodsList = goodsList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Goods goods = goodsList.get(i);
        viewHolder.tvName.setText(goods.getName());
        viewHolder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetData.getData(goods.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public  TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

}
