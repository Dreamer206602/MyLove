package com.zc.lb.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RadioButton;

import com.zc.lb.R;
import com.zc.lb.ui.fragment.MaterialDesign2Fragment;
import com.zc.lb.ui.fragment.MaterialDesign3Fragment;
import com.zc.lb.ui.fragment.MaterialDesignFragment;
import com.zc.lb.ui.fragment.base.TitleBarFragment;
import com.zc.lb.utils.KJAnimations;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJActivityStack;

public class MainActivity extends TitleBarActivity {

    @BindView(id = R.id.bottombar_content1, click = true)
    private RadioButton mRbtnContent1;
    @BindView(id = R.id.bottombar_content2, click = true)
    private RadioButton mRbtnContent2;
    @BindView(id = R.id.bottombar_content3, click = true)
    private RadioButton mRbtnContent3;

    private TitleBarFragment contentFragment1;
    private TitleBarFragment contentFragment2;
    private TitleBarFragment contentFragment3;
    private TitleBarFragment currentFragment;
    private float titleBarHeight;
    private boolean isOnKeyBacking;


    @Override
    public void setRootView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initData() {
        super.initData();
        contentFragment1 = new MaterialDesignFragment();
        contentFragment2 = new MaterialDesign2Fragment();
        contentFragment3 = new MaterialDesign3Fragment();
        titleBarHeight = getResources().getDimension(R.dimen.titlebar_height);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        changeFragment(contentFragment1);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.bottombar_content1:
                //contentFragment1.getActivity().setTitle("1");
                changeFragment(contentFragment1);

                break;
            case R.id.bottombar_content2:
                //contentFragment1.getActivity().setTitle("2");
                changeFragment(contentFragment2);
                break;
            case R.id.bottombar_content3:
                //contentFragment1.getActivity().setTitle("3");
                changeFragment(contentFragment3);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onBackClick() {
        super.onBackClick();
        currentFragment.onBackClick();

    }


    @Override
    protected void onMenuClick() {
        super.onMenuClick();
        currentFragment.onMenuClick();
    }

    public void changeFragment(TitleBarFragment targetFragment) {
        currentFragment = targetFragment;
        super.changeFragment(R.id.main_content, targetFragment);
    }


    /********************** 再按一下退出 *****************************/

    /**
     * 取消退出
     */
    private void cancleExit() {
        Animation anim = KJAnimations.getTranslateAnimation(0, 0,
                titleBarHeight, 0, 300);
        mTvTitle.startAnimation(anim);
        Animation anim2 = KJAnimations.getTranslateAnimation(0, 0,
                titleBarHeight, 300, 0);
        anim2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mTvDoubleClickTip.setVisibility(View.GONE);
            }
        });
        mTvDoubleClickTip.startAnimation(anim2);
    }

    /**
     * 显示退出提示
     */
    private void showExitTip() {
        mTvDoubleClickTip.setVisibility(View.VISIBLE);
        Animation anim = KJAnimations.getTranslateAnimation(0, 0, 0,
                titleBarHeight, 300);
        mTvTitle.startAnimation(anim);
        Animation anim2 = KJAnimations.getTranslateAnimation(0, 0,
                titleBarHeight, 0, 300);
        mTvDoubleClickTip.startAnimation(anim2);
    }

    private final Runnable onBackTimeRunnable = new Runnable() {
        @Override
        public void run() {
            isOnKeyBacking = false;
            cancleExit();
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isOnKeyBacking) {
                mMainLoopHandler.removeCallbacks(onBackTimeRunnable);
                isOnKeyBacking = false;
                // UIHelper.toHome(aty);
                KJActivityStack.create().AppExit(aty);
            } else {
                isOnKeyBacking = true;
                showExitTip();
                mMainLoopHandler.postDelayed(onBackTimeRunnable, 2000);
            }
            return true;
            // } else if (keyCode == KeyEvent.KEYCODE_MENU) {
            // return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    };


}
