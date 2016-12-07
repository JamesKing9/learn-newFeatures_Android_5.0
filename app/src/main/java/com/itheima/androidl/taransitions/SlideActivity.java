package com.itheima.androidl.taransitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Window;

import com.itheima.androidl.R;


public class SlideActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		getWindow().setAllowEnterTransitionOverlap(true);
		getWindow().setAllowReturnTransitionOverlap(true);
		Slide slide = new Slide();
		slide.setDuration(1000);
		getWindow().setEnterTransition(slide);
		getWindow().setExitTransition(slide);


		setContentView(R.layout.activity_animation);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finishAfterTransition();
	}
}
