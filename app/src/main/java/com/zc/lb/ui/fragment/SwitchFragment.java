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
public class SwitchFragment extends TitleBarFragment {

    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view=View.inflate(outsideAty,R.layout.fragment_switch,null);
        return view;
    }

    @Override
    protected void setActionBarRes(ActionBarRes actionBarRes) {
        super.setActionBarRes(actionBarRes);
        actionBarRes.title="Switch按钮";
        actionBarRes.backImageId=R.mipmap.titlebar_back;
    }

    @Override
    public void onBackClick() {
        super.onBackClick();
        outsideAty.finish();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
    }

    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
    }
}
