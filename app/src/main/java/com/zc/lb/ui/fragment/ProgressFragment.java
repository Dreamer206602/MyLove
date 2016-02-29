package com.zc.lb.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gc.materialdesign.views.ProgressBarCircularIndeterminate;
import com.gc.materialdesign.views.ProgressBarDeterminate;
import com.gc.materialdesign.views.ProgressBarIndeterminate;
import com.gc.materialdesign.views.ProgressBarIndeterminateDeterminate;
import com.gc.materialdesign.views.Slider;
import com.zc.lb.R;
import com.zc.lb.ui.SimpleBackActivity;
import com.zc.lb.ui.fragment.base.TitleBarFragment;

import org.kymjs.kjframe.ui.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressFragment extends TitleBarFragment {

    @BindView(id = R.id.progressBarCircularIndetermininate, click = true)
    private ProgressBarCircularIndeterminate progressBarCircularIndeterminate;
    @BindView(id = R.id.progressBarIndeterminate, click = true)
    private ProgressBarIndeterminate progressBarIndeterminate;
    @BindView(id = R.id.progressBarIndeterminateDeterminate, click = true)
    private ProgressBarIndeterminateDeterminate progressBarIndeterminateDeterminate;
    @BindView(id = R.id.progressDeterminate, click = true)
    private ProgressBarDeterminate progressBarDeterminate;

    @BindView(id = R.id.slider, click = true)
    private Slider slider;
    @BindView(id = R.id.sliderNumber, click = true)
    private Slider sliderNumber;

    public static final String BACKGROUND_COLOR="background_color";
    SimpleBackActivity aty;
    String  background_color;

    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aty = (SimpleBackActivity) getActivity();
        View view = View.inflate(aty, R.layout.fragment_progress, null);
        return view;
    }

    @Override
    protected void setActionBarRes(ActionBarRes actionBarRes) {
        super.setActionBarRes(actionBarRes);
        actionBarRes.title = "进度条";
    }

    @Override
    protected void initData() {
        super.initData();
        Bundle bundleData = aty.getBundleData();
        if (bundleData != null) {
            background_color = bundleData.getString(BACKGROUND_COLOR);
            Toast.makeText(aty, background_color, Toast.LENGTH_SHORT).show();
            Log.d("sssssssssss", background_color+"");
        }
        //progressTimer.start();
    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
//        progressBarCircularIndeterminate.setBackgroundColor(Integer.parseInt(background_color));
//        progressBarDeterminate.setBackgroundColor(Integer.parseInt(background_color));
//        progressBarIndeterminate.setBackgroundColor(Integer.parseInt(background_color));
//        progressBarIndeterminateDeterminate.setBackgroundColor(Integer.parseInt(background_color));
//        slider.setBackgroundColor(Integer.parseInt(background_color));
//        sliderNumber.setBackgroundColor(Integer.parseInt(background_color));

    }

//    Thread progressTimer = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            for(int i = 0; i <= 100; i++){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handler.sendMessage(new Message());
//            }
//        }
//    });

//    Handler handler = new Handler(new Handler.Callback() {
//        int progress = 0;
//        @Override
//        public boolean handleMessage(Message msg) {
//            progressBarDeterminate.setProgress(progress++);
//            return false;
//        }
//    });
}
