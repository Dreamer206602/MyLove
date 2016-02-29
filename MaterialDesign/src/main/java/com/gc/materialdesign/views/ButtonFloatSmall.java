package com.gc.materialdesign.views;

//import com.gc.materialdesign.R;
import com.gc.materialdesign.utils.Utils;
import com.gc.materialdesigndemo.R;

import android.content.Context;
import android.util.AttributeSet;

public class ButtonFloatSmall extends ButtonFloat {
	
	public ButtonFloatSmall(Context context, AttributeSet attrs) {
		super(context, attrs);
		sizeRadius = 20;
		sizeIcon = 20;
		setDefaultProperties();
		LayoutParams params = new LayoutParams(Utils.dpToPx(sizeIcon, getResources()),Utils.dpToPx(sizeIcon, getResources()));
		params.addRule(CENTER_IN_PARENT, TRUE);
		icon.setLayoutParams(params);
	}
	
	protected void setDefaultProperties(){
		rippleSpeed = Utils.dpToPx(2, getResources());
		rippleSize = 10;		
		// Min size
		setMinimumHeight(Utils.dpToPx(sizeRadius*2, getResources()));
		setMinimumWidth(Utils.dpToPx(sizeRadius*2, getResources()));
		// Background shape
		setBackgroundResource(R.drawable.background_button_float);
//		setBackgroundColor(backgroundColor);
	}

}