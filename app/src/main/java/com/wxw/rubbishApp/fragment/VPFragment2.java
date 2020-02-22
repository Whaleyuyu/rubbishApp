package com.wxw.rubbishApp.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.wxw.rubbishApp.R;
import com.wxw.rubbishApp.list.list2;


public class VPFragment2 extends Fragment {
    ImageButton imageButton2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View VPFView2 = inflater.inflate(R.layout.fragment_vpfragment2, container, false);
        //TODO
        initView(VPFView2);
        initData();
        return VPFView2;
    }

    private void initView (View vpfView2) {
        imageButton2=(ImageButton)vpfView2.findViewById(R.id.imageButton2);
    }

    private void initData () {
        imageButton2.setOnClickListener(new VPFragment2.turnOnClickListener());
    }

    private class turnOnClickListener implements View.OnClickListener{

        @Override
        public void onClick (View view) {
            Context context = getActivity();
            Intent intent = new Intent(context ,list2.class);
            startActivity(intent);
        }
    }
}
