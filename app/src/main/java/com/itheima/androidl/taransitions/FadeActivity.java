package com.itheima.androidl.taransitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Window;

import com.itheima.androidl.R;


public class FadeActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		getWindow().setAllowEnterTransitionOverlap(true);
		getWindow().setAllowReturnTransitionOverlap(true);
		setContentView(R.layout.activity_animation);

		Fade fade = new Fade();
		fade.setDuration(5000);
		//fade.addTarget(findViewById(R.id.view));
		getWindow().setEnterTransition(fade);
		getWindow().setExitTransition(fade);

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finishAfterTransition();
	}
}
