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


public class VPFragment3 extends Fragment {
    ImageButton imageButton3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View VPFView3 = inflater.inflate(R.layout.fragment_vpfragment3, container, false);
        //TODO
        initView(VPFView3);
        initData();
        return VPFView3;
    }

    private void initView (View vpfView3) {
        imageButton3=(ImageButton)vpfView3.findViewById(R.id.imageButton3);
    }

    private void initData () {
        imageButton3.setOnClickListener(new VPFragment3.turnOnClickListener());
    }

    private class turnOnClickListener implements View.OnClickListener{

        @Override
        public void onClick (View view) {
            Context context = getActivity();
            Intent intent = new Intent(context ,list3.class);
            startActivity(intent);
        }
    }
}
