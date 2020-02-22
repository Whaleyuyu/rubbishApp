package com.wxw.rubbishApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Switch;

import com.wxw.rubbishApp.R;
import com.wxw.rubbishApp.bean.ItemBean;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<ItemBean> list;
    private LayoutInflater inflater;
    private int num;

    public MyAdapter (int num,Context context, List<ItemBean> list){
        this.num=num;
        this.list=list;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount () {
        return list.size();
    }

    @Override
    public Object getItem (int i) {
        return list.get(i);
    }

    @Override
    public long getItemId (int i) {
        return i;
    }

    @Override
    public View getView (int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //如果view没有被实例化，缓存池没有相应的缓存
        if (convertView==null){
            viewHolder=new ViewHolder();
            //由于我们只需要把XML转化为View，并不涉及具体的布局，所以第二个参数通常设置为null
            if(num==1){
                convertView= inflater.inflate(R.layout.btn1_layout, null);
                //对viewHolder的属性进行赋值
                viewHolder.button = (Button) convertView.findViewById(R.id.btn1);
            }else if(num==2){
                convertView= inflater.inflate(R.layout.btn2_layout, null);
                //对viewHolder的属性进行赋值
                viewHolder.button = (Button) convertView.findViewById(R.id.btn2);
            }else if(num==3){
                convertView= inflater.inflate(R.layout.btn3_layout, null);
                //对viewHolder的属性进行赋值
                viewHolder.button = (Button) convertView.findViewById(R.id.btn3);
            }else if(num==4){
                convertView= inflater.inflate(R.layout.btn4_layout, null);
                //对viewHolder的属性进行赋值
                viewHolder.button = (Button) convertView.findViewById(R.id.btn4);
            }




            //通过setTag将convertView和viewHolder关联
            convertView.setTag(viewHolder);
        }else {//若有缓存，则直接取出viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }


//        获取相应索引的itemBean对象
        ItemBean bean = list.get(i);

        /*设置控件的相应属性值*/
        viewHolder.button.setText((CharSequence) bean.itemButtonName);
        return convertView;
    }

    //用于缓存控件，三个属性分别对应testlayout文件三个控件
    class ViewHolder{
        public Button button;
    }

}
