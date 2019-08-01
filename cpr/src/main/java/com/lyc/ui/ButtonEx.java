package com.lyc.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ButtonEx extends Button {
	public ButtonEx(Context context, AttributeSet attrs){
		super(context,attrs);
		
		this.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if(event.getAction()==MotionEvent.ACTION_DOWN){ 
				      v.getBackground().setAlpha(100);
				    }else if(event.getAction()==MotionEvent.ACTION_UP){ 
				    	  v.getBackground().setAlpha(255);
				    } 
				   
				return false;
			}
		});
	}
}
