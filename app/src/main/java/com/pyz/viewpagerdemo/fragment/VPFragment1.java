package com.pyz.viewpagerdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.pyz.viewpagerdemo.R;
import com.pyz.viewpagerdemo.StartActivity;
import com.pyz.viewpagerdemo.list.list1;


public class VPFragment1 extends Fragment {
    ImageButton imageButton1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View VPFView1 = inflater.inflate(R.layout.fragment_vpfragment1, container, false);
        //TODO
        initView(VPFView1);
        initData();
        return VPFView1;
    }

    private void initView (View vpfView1) {
        imageButton1=(ImageButton)vpfView1.findViewById(R.id.imageButton1);
    }

    private void initData () {
        imageButton1.setOnClickListener(new turnOnClickListener());
    }

    private class turnOnClickListener implements View.OnClickListener{

        @Override
        public void onClick (View view) {
            Context context = getActivity();
            Intent intent = new Intent(context ,list1.class);
            startActivity(intent);
        }
    }
}
