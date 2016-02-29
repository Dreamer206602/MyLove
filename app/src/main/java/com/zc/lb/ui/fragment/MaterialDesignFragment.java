package com.zc.lb.ui.fragment;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gc.materialdesign.views.ButtonFloatSmall;
import com.gc.materialdesign.views.LayoutRipple;
import com.gc.materialdesign.widgets.ColorSelector;
import com.nineoldandroids.view.ViewHelper;
import com.zc.lb.R;
import com.zc.lb.entity.SimpleBackPage;
import com.zc.lb.ui.MainActivity;
import com.zc.lb.ui.SimpleBackActivity;
import com.zc.lb.ui.fragment.base.TitleBarFragment;

import org.kymjs.kjframe.ui.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialDesignFragment extends TitleBarFragment implements ColorSelector.OnColorSelectedListener{

    @BindView(id=R.id.buttonColorSelector,click = true)
    private ButtonFloatSmall buttonFloatSmall;
    @BindView(id=R.id.itemButtons,click = true)
    private LayoutRipple itemButtons;
    @BindView(id=R.id.itemProgress,click = true)
    private LayoutRipple itemsProgress;
    @BindView(id=R.id.itemSwitches,click = true)
    private LayoutRipple itemSwitches;
    @BindView(id=R.id.itemWidgets,click = true)
    private LayoutRipple itemsWidgets;



    int backgroundColor = Color.parseColor("#1E88E5");
    private TitleBarFragment titleBarFragment;
    MainActivity aty;

    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {

        aty= (MainActivity) getActivity();
        View view =View.inflate(aty,R.layout.fragment_material_design,null);
        return  view;
    }

//    @Override
//    protected void setTitle(CharSequence text) {
//        super.setTitle(text);
//        //outsideAty.mTvTitle.setText("新特性");
//        aty.setTitle("新特性");
//    }

    @Override
    protected void setActionBarRes(ActionBarRes actionBarRes) {
        super.setActionBarRes(actionBarRes);
        actionBarRes.title = "新特性";
//        actionBarRes.backImageId = R.mipmap.titlebar_back;
//        actionBarRes.menuImageId = R.mipmap.titlebar_add;
    }

    @Override
    protected void initData() {
        super.initData();
        setOriginRiple(itemButtons);
        setOriginRiple(itemsProgress);
        setOriginRiple(itemsWidgets);
        setOriginRiple(itemSwitches);



    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
    }
    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.buttonColorSelector:
                buttonFloatSmall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //                        ColorSelector colorSelector = new ColorSelector(outsideAty.aty, backgroundColor,outsideAty.aty.);
                        //                        colorSelector.show();
                    }
                });
                break;
            case  R.id.itemButtons:
                SimpleBackActivity.postShowWith(outsideAty, SimpleBackPage.BUTTONS);
                break;
            case R.id.itemProgress:
                Bundle bundle=new Bundle();
                bundle.putString(ProgressFragment.BACKGROUND_COLOR,"#1E88E5");
                SimpleBackActivity.postShowWith(aty, SimpleBackPage.PROGRESS, bundle);
                break;
            case R.id.itemSwitches:
                SimpleBackActivity.postShowWith(outsideAty,SimpleBackPage.SWITCH);
                break;
            case R.id.itemWidgets:
                SimpleBackActivity.postShowWith(outsideAty,SimpleBackPage.WIDGETS);
            default:
                break;


        }


    }


    @Override
    public void onColorSelected(int color) {
        backgroundColor=color;
        buttonFloatSmall.setBackgroundColor(color);
    }
    private void setOriginRiple(final LayoutRipple layoutRipple){

        layoutRipple.post(new Runnable() {

            @Override
            public void run() {
                View v = layoutRipple.getChildAt(0);
                layoutRipple.setxRippleOrigin(ViewHelper.getX(v) + v.getWidth() / 2);
                layoutRipple.setyRippleOrigin(ViewHelper.getY(v) + v.getHeight() / 2);

                layoutRipple.setRippleColor(Color.parseColor("#1E88E5"));

                layoutRipple.setRippleSpeed(30);
            }
        });

    }

}


