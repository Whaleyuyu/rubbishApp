//package com.pyz.viewpagerdemo.fragment;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.SearchView;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.pyz.viewpagerdemo.MainActivity;
//import com.pyz.viewpagerdemo.R;
//import com.pyz.viewpagerdemo.bean.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SearchActivity extends Fragment {
//
//        private List<User> mData = new ArrayList<User>();  // 这个数据会改变
//        private List<User> mBackData;  // 这是原始的数据
//
//        private ListView mListView;
//        private SearchView mSearchView;
//        private MyAdapter mAdapter;
//
//        @Override
//        protected View onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.search_layout);
//
//            mListView = (ListView) super.findViewById(R.id.mListView);
//            mSearchView = (SearchView) super.findViewById(R.id.mSearchView);
//            //添加数据
//            initData();
//
//            // 设置监听器
//            mSearchView.setOnQueryTextListener(new QueryListener());
//            mListView.setTextFilterEnabled(true);
//            mListView.setOnItemClickListener(new ItemClick());
//            //适配器
//            mAdapter = new MyAdapter();
//            mListView.setAdapter(mAdapter);
//
//            return mListView.getChildAt(getChildAt)
//        }
//
//        //我这里写的是死数据,也可以用User这个Bean类动态添加数据
//        private void initData() {
//            mData.add(new User(R.mipmap.ic_launcher,"张三"));
//            mData.add(new User(R.mipmap.bb,"李四"));
//            mData.add(new User(R.mipmap.ic_launcher,"王五"));
//            mData.add(new User(R.mipmap.ic_launcher_round,"赵六"));
//            //mBackData用来搜索框清空后回复到原始的数据
//            mBackData = mData;
//        }
//
//        // 必须实现Filterable接口
//        private class MyAdapter extends BaseAdapter implements Filterable {
//            private MyFilter mFilter;
//
//            @Override
//            public int getCount() {
//                return mData.size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return mData.get(position);
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                if (null == convertView) {
//                    convertView = View.inflate(MainActivity.this, R.layout.item_layout, null);
//                }
//
//                TextView textView = (TextView) convertView.findViewById(R.id.mText);
//                ImageView mImg = (ImageView) convertView.findViewById(R.id.mImg);
//                textView.setText(mData.get(position).getName());
//                mImg.setImageResource(mData.get(position).getImg());
//                return convertView;
//            }
//
//            @Override
//            public Filter getFilter() {
//                if (null == mFilter) {
//                    mFilter = new MyFilter();
//                }
//                return mFilter;
//            }
//
//            // 自定义Filter类
//            class MyFilter extends Filter {
//                @Override
//                // 该方法在子线程中执行
//                // 自定义过滤规则
//                protected FilterResults performFiltering(CharSequence constraint) {
//                    FilterResults results = new FilterResults();
//
//                    List<User> newValues = new ArrayList<User>();
//                    String filterString = constraint.toString().trim().toLowerCase();
//
//                    // 如果搜索框内容为空，就恢复原始数据
//                    if (TextUtils.isEmpty(filterString)) {
//                        newValues = mBackData;
//                    } else {
//                        // 过滤出新数据
//                        for (int i = 0; i <mBackData.size() ; i++) {
//                            //通过这个判断进行过滤,通过mBackData.get(i).getName()进行过滤
//                            if (-1 != mBackData.get(i).getName().toLowerCase().indexOf(filterString)) {
//                                newValues.add(mBackData.get(i));
//                            }
//                        }
//                    }
//                    results.values = newValues;
//                    results.count = newValues.size();
//                    return results;
//                }
//                @Override
//                protected void publishResults(CharSequence constraint,
//                                              FilterResults results) {
//                    mData = (List<User>) results.values;
//
//                    if (results.count > 0) {
//                        mAdapter.notifyDataSetChanged();  // 通知数据发生了改变
//                    } else {
//                        mAdapter.notifyDataSetInvalidated(); // 通知数据失效
//                    }
//                }
//            }
//        }
//
//        // 搜索文本监听器
//        private class QueryListener implements SearchView.OnQueryTextListener {
//            // 当内容被提交时执行
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            // 当搜索框内内容发生改变时执行
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (TextUtils.isEmpty(newText)) {
//                    mListView.clearTextFilter();  // 清楚ListView的过滤
//                } else {
//                    mListView.setFilterText(newText); // 设置ListView的过滤关键词
//                    //隐藏弹出的黑框
//                    mListView.dispatchDisplayHint(View.INVISIBLE);
//                }
//                return true;
//            }
//        }
//
//        //ListView的item点击事件
//        private class ItemClick implements AdapterView.OnItemClickListener {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, mData.get(position).getName(), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//
//}
