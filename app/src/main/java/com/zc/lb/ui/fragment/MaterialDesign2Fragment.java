package com.zc.lb.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shinelw.library.ColorArcProgressBar;
import com.zc.lb.R;
import com.zc.lb.ui.MainActivity;
import com.zc.lb.ui.fragment.base.TitleBarFragment;

import org.kymjs.kjframe.ui.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialDesign2Fragment extends TitleBarFragment {
    @BindView(id=R.id.button1,click = true)
    private Button btn1;
    @BindView(id=R.id.bar1)
    private ColorArcProgressBar bar1;

    @BindView(id=R.id.button2,click = true)
    private Button btn2;
    @BindView(id=R.id.bar2)
    private ColorArcProgressBar bar2;

    @BindView(id=R.id.button3,click = true)
    private Button btn3;
    @BindView(id=R.id.bar3)
    private ColorArcProgressBar bar3;

    MainActivity aty;
    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
       aty= (MainActivity) getActivity();
        View view=View.inflate(aty,R.layout.fragment_material_design2,null);
        Thread thread=new Thread(runnable);
        thread.start();
        return view;
    }
        @Override
    protected void setActionBarRes(ActionBarRes actionBarRes) {
        super.setActionBarRes(actionBarRes);
        actionBarRes.title="新特性2";
    }

    public  Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            bar1.setCurrentValues(msg.arg1+1);
            bar2.setCurrentValues(msg.arg1+1);
            bar3.setCurrentValues(msg.arg1+1);
            return false;
        }
    });
    Runnable runnable=new Runnable() {
        int progressValue = 0;
        @Override
        public void run() {
            while (true) {
                Message msg = handler.obtainMessage();
                msg.arg1 = progressValue++;
                handler.sendMessage(msg);
//                if(progressValue>100){
//                    progressValue=0;
//                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };


    @Override
    protected void initData() {
        super.initData();


    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
    }

//    @Override
//    protected void widgetClick(View v) {
//        super.widgetClick(v);
//        switch (v.getId()){
//            case R.id.button1:
//                bar1.setCurrentValues(100);
//                break;
//            case R.id.button2:
//                bar2.setCurrentValues(100);
//                break;
//            case R.id.button3:
//                bar3.setCurrentValues(88);
//                break;
//        }
//    }
}
