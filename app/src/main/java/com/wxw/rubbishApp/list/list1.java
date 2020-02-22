package com.wxw.rubbishApp.list;


import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;

import com.wxw.rubbishApp.R;
import com.wxw.rubbishApp.adapter.MyAdapter;
import com.wxw.rubbishApp.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class list1 extends Activity {
//    private String[] list = null;
    List<String> list1 = new ArrayList<>();
    ListView listView;
    ImageButton ib;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        隐藏状态栏
        setContentView(R.layout.list1_layout);
//        linearLayout= (LinearLayout) findViewById(R.id.linearLayout);
        initData();
        List<ItemBean> itemBeanList = new ArrayList<>();

        for (int i=0;i<list1.size();i++){
            itemBeanList.add(new ItemBean(list1.get(i)));
        }
        listView= (ListView) findViewById(R.id.l1);
        listView.setAdapter(new MyAdapter(1,this,itemBeanList));
        initViews();
    }

    private void initData () {
        ib= (ImageButton)findViewById(R.id.imageButton1);
        Uri uri = Uri.parse("content://com.wxw.rubbishApp.provider.RUBBISH/rubbish");
        // 查询列
        String[] projection = { "name" };
        // 获得ContentResolver实例
        ContentResolver cur = getContentResolver();
        // 查询放回游标
        Cursor c = cur.query(uri, projection, "type=1", null, null);
        while (c.moveToNext())
        {
            String name=c.getString(c.getColumnIndex("name"));
            list1.add(name);
        }

    }

    private void initViews(){
        ib.setOnClickListener(new list1.turnOnClickListener());
    }

    private class turnOnClickListener implements View.OnClickListener{

        @Override
        public void onClick (View view) {
            finish();
        }
    }
}
