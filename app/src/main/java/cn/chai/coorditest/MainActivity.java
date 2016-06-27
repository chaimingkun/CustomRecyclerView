package cn.chai.coorditest;

import android.os.Handler;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import java.util.ArrayList;

import cn.chai.customrecyclerview.listener.OnLoadMoreListener;
import cn.chai.customrecyclerview.listener.OnRefreshListener;
import cn.chai.customrecyclerview.ptr.CustomRecyclerView;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private CustomRecyclerView mRecyclerView;
    private MAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (CustomRecyclerView) findViewById(R.id.mRecyclerView);
//        mRecyclerView.setRefreshEnable(true);
//        mRecyclerView.setLoadMoreEnable(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MAdapter();
        mRecyclerView.setAdapter(adapter);
        /**
         * 增加header
         */
//        mRecyclerView.addRecyclerViewHeader(view);

       // mRecyclerView.setFooterLoadText("");

//        mRecyclerView.setFooterView(view);



        mRecyclerView.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.setRefreshing(false);
                    }
                },2000);
            }
        });

        mRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.adddata();
                        adapter.notifyDataSetChanged();
                        mRecyclerView.stopLoadMore();
                    }
                },2000);
            }
        });
    }

    private class MAdapter extends RecyclerView.Adapter{
        private ArrayList list = new ArrayList();
        public MAdapter(){
            for (int i = 0;i<50;i++){
                list.add(i);
            }
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(View.inflate(MainActivity.this,R.layout.testitem,null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((Holder) holder).tv.setText(list.get(position)+"");

        }

        @Override
        public int getItemCount() {
            return list.size();
        }


        private class Holder extends RecyclerView.ViewHolder{
            private TextView tv;
            public Holder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.text);
            }
        }

        public void adddata(){
            for (int i = 0;i<10;i++){
                list.add(list.size()+i);
            }
        }
    }
}
