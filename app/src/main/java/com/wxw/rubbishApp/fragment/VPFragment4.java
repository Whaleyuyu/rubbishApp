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
import com.wxw.rubbishApp.list.list3;
import com.wxw.rubbishApp.list.list4;


public class VPFragment4 extends Fragment {
    ImageButton imageButton4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View VPFView4 = inflater.inflate(R.layout.fragment_vpfragment4, container, false);
        //TODO
        initView(VPFView4);
        initData();
        return VPFView4;
    }

    private void initView (View vpfView4) {
        imageButton4 =(ImageButton)vpfView4.findViewById(R.id.imageButton4);
    }

    private void initData () {
        imageButton4.setOnClickListener(new VPFragment4.turnOnClickListener());
    }

    private class turnOnClickListener implements View.OnClickListener{

        @Override
        public void onClick (View view) {
            Context context = getActivity();
            Intent intent = new Intent(context ,list4.class);
            startActivity(intent);
        }
    }
}
