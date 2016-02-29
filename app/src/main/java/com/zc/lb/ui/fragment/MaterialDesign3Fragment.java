package com.zc.lb.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zc.lb.R;
import com.zc.lb.ui.MainActivity;
import com.zc.lb.ui.fragment.base.TitleBarFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialDesign3Fragment extends TitleBarFragment {


    MainActivity aty;
    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aty= (MainActivity) getActivity();
        View view=View.inflate(aty,R.layout.fragment_material_design3,null);
        return view;
    }

//    @Override
//    protected void setTitle(CharSequence text) {
//        super.setTitle(text);
//        //outsideAty.mTvTitle.setText("新特性3");
//        aty.setTitle("新特性3");
//    }

        @Override
    protected void setActionBarRes(ActionBarRes actionBarRes) {
        super.setActionBarRes(actionBarRes);
        actionBarRes.title="新特性3";
    }
}
