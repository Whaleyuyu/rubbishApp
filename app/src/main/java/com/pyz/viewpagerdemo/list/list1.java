package com.pyz.viewpagerdemo.list;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.pyz.viewpagerdemo.R;
import com.pyz.viewpagerdemo.adapter.MyAdapter;
import com.pyz.viewpagerdemo.bean.ItemBean;
import com.pyz.viewpagerdemo.fragment.VPFragment1;

import java.util.ArrayList;
import java.util.List;

public class list1 extends Activity {
    private String[] list = {"可回收垃圾","有害垃圾","厨余垃圾","其他垃圾","可回收垃圾","有害垃圾","厨余垃圾","其他垃圾","可回收垃圾","有害垃圾",
            "厨余垃圾","其他垃圾","可回收垃圾","有害垃圾","厨余垃圾","其他垃圾","可回收垃圾","有害垃圾","厨余垃圾","其他垃圾"
    ,"可回收垃圾","有害垃圾","厨余垃圾","其他垃圾"};
    ListView listView;
    ImageButton ib;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        隐藏状态栏
        setContentView(R.layout.list1_layout);
//        linearLayout= (LinearLayout) findViewById(R.id.linearLayout);
        List<ItemBean> itemBeanList = new ArrayList<>();
        for (int i=0;i<20;i++){
            itemBeanList.add(new ItemBean(list[i]));
        }
        listView= (ListView) findViewById(R.id.l1);
        listView.setAdapter(new MyAdapter(this,itemBeanList));
        initData();
        initViews();
    }

    private void initData () {
        ib= (ImageButton)findViewById(R.id.imageButton1);

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
