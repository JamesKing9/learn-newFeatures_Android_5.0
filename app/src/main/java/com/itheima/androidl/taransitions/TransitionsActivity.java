package com.itheima.androidl.taransitions;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.*;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.itheima.androidl.R;



public class TransitionsActivity extends Activity implements View.OnClickListener {
	Button bt1,bt2,bt3,bt4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		//getWindow().setAllowEnterTransitionOverlap(true);
		//getWindow().setAllowReturnTransitionOverlap(true);
		setContentView(R.layout.activity_transitions);


		bt1 = (Button) findViewById(R.id.bt1);
		bt2 = (Button) findViewById(R.id.bt2);
		bt3 = (Button) findViewById(R.id.bt3);
		bt4 = (Button) findViewById(R.id.bt4);

		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		Transition transition = null;
		switch (v.getId()) {
			case R.id.bt1:
                //
				transition = new Explode();
				intent = new Intent(TransitionsActivity.this, ExplodeActivity.class);
				break;
			case R.id.bt2:
                //淡入淡出
				transition = new Fade();
				intent = new Intent(TransitionsActivity.this, FadeActivity.class);
				break;
			case R.id.bt3:
                //滑动
				transition = new Slide();
				intent = new Intent(TransitionsActivity.this, SlideActivity.class);
				break;
			case R.id.bt4:
				break;

		}

		if (v.getId() != R.id.bt4) {
			transition.setDuration(1000);
			getWindow().setEnterTransition(transition);
			getWindow().setExitTransition(transition);
			getWindow().setReturnTransition(transition);
			getWindow().setReenterTransition(transition);
			startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(TransitionsActivity.this).toBundle());
		} else {
			TransitionSet set = new TransitionSet();
			set.addTransition(new Explode());
			set.addTransition(new Fade());
			set.setDuration(1000);
			getWindow().setReturnTransition(set);
			getWindow().setReenterTransition(set);
			getWindow().setEnterTransition(set);
			getWindow().setExitTransition(set);

			bt4.setTransitionName("bt4");
			TransitionSet transitionSet = new TransitionSet();
			transitionSet.addTransition(new ChangeTransform());
			transitionSet.addTransition(new ChangeBounds());
			transitionSet.addTarget("bt4");
			transitionSet.setDuration(1000);
			getWindow().setSharedElementEnterTransition(transitionSet);
			getWindow().setSharedElementExitTransition(transitionSet);
			getWindow().setSharedElementReturnTransition(transitionSet);
			getWindow().setSharedElementReenterTransition(transitionSet);
			intent = new Intent(this, ShareActivity.class);

			ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, bt4, "bt4");
			startActivity(intent, options.toBundle());

		}
	}
}
