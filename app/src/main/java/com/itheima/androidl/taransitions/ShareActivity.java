package com.itheima.androidl.taransitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.*;
import android.view.Window;

import com.itheima.androidl.R;


public class ShareActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		getWindow().setAllowEnterTransitionOverlap(true);
		getWindow().setAllowReturnTransitionOverlap(true);
		getWindow().setSharedElementsUseOverlay(true);

		TransitionSet transitionSet = new TransitionSet();
		transitionSet.addTransition(new Fade());
		transitionSet.addTransition(new ChangeTransform());
		transitionSet.addTransition(new ChangeBounds());
		transitionSet.addTarget("bt4");
		transitionSet.setDuration(1000);
		getWindow().setSharedElementEnterTransition(transitionSet);
		getWindow().setSharedElementExitTransition(transitionSet);
		getWindow().setSharedElementReturnTransition(transitionSet);
		getWindow().setSharedElementReenterTransition(transitionSet);


		setContentView(R.layout.activity_share);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finishAfterTransition();
	}
}
