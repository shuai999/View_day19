package com.jackchen.view_day19.baseUse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jackchen.view_day19.R;

import java.util.ArrayList;
import java.util.List;


/**
 *  Email: 2185134304@qq.com
 *  Create JackChen 2018/3/3 10:48
 *  Version:
 *  Params:
 *  Description:
 */
public class BaseUseActivity extends AppCompatActivity {

    private RecyclerView recycler_view;

    // 数据
    private List<String> mDatas ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_use);

        initData() ;

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);


        // 这里一定要注意，在给RecyclerView设置adapter之前一定要设置 显示的样式，如果不设置，则数据就不能出来
        // new LinearLayoutManager) -> 表示是ListView的样式
        // new GridLayoutManager() -> 表示是GridView的样式，1列显示的个数
        // new StaggeredGridLayoutManager() -> 表示瀑布流样式
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
//        recycler_view.setLayoutManager(new GridLayoutManager(this , 3));
//        recycler_view.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));


        //和ListView一样，来设置Adapter
        recycler_view.setAdapter(new RecyclerAdapter());

    }


    /**
     *  初始化数据 - 举例说明
     */
    private void initData() {
        mDatas = new ArrayList<>() ;
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char)i) ;
        }
    }


    /**
     * 列表适配器  这里必须是一个ViewHolder的泛型，所以下边我们必须新建一个ViewHolder,这里是强制的，只有新建ViewHolder，才可以
     * 覆盖3个方法，而ListView的 ViewHolder不是强制写的，可以不写，但是不写的后果就是如果数据一多，可能导致 OOM或者滑动卡顿
     */
    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

        // 总共显示多少条目
        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        // 创建ViewHolder
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(BaseUseActivity.this).inflate(R.layout.item_home , parent , false) ;
            ViewHolder viewHolder = new ViewHolder(itemView) ;
            return viewHolder;
        }

        // 绑定数据
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.itemTv.setText(mDatas.get(position));
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView itemTv ;
            public ViewHolder(View itemView) {
                super(itemView);

                itemTv = (TextView) itemView.findViewById(R.id.tv_num);

            }
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_action_gridview:
                recycler_view.setLayoutManager(new GridLayoutManager(BaseUseActivity.this , 2));
                break;
            case R.id.id_action_listview:
                recycler_view.setLayoutManager(new LinearLayoutManager(BaseUseActivity.this));
                break;
        }
        return true;
    }
}
