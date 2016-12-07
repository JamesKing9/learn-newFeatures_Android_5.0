package com.itheima.androidl.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;

import com.itheima.androidl.R;
import com.itheima.androidl.taransitions.TransitionsActivity;

public class AnimationFragment extends BaseFragment implements View.OnClickListener {
	Button bt1,bt2,transitions;
	View curved,state,vector;
	protected View initView(){
		View view = View.inflate(getActivity(), R.layout.fragment_animation,null);
		bt1 = (Button) view.findViewById(R.id.bt1);
		bt2 = (Button) view.findViewById(R.id.bt2);
		curved = view.findViewById(R.id.curved);
		state = view.findViewById(R.id.state_anim);
		vector = view.findViewById(R.id.vector_anim);
		transitions = (Button) view.findViewById(R.id.transitions);

		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		curved.setOnClickListener(this);
		state.setOnClickListener(this);
		vector.setOnClickListener(this);
		transitions.setOnClickListener(this);
		return view;
	}
	@Override
	public String getUrl() {
		return "file:///android_asset/animation.html";
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.bt1:
				Animator animator1 = ViewAnimationUtils.createCircularReveal(bt1, bt1.getWidth() / 2, bt1.getHeight() / 2, bt1.getWidth(), 0);
				animator1.setInterpolator(new LinearInterpolator());
				animator1.setDuration(1000);
				animator1.start();

				break;
			case R.id.bt2:
				Animator animator2 = ViewAnimationUtils.createCircularReveal(bt2,0,bt2.getHeight(),0,(float) Math.hypot(bt2.getWidth(), bt2.getHeight()));
				animator2.setDuration(1000);
				animator2.start();
				break;

			case R.id.curved:
				curved();
				break;

			case R.id.vector_anim:
				vector();
				break;
			case R.id.transitions:
				transitions();
				break;
		}
	}


	private void curved(){
		Path path = new Path();
		//path.moveTo(view.getX(), view.getY());
		//path.lineTo(200, 200);
		//path.lineTo(600, 600);
		//path.arcTo(r,0,180,false);
		//path.rQuadTo(500,300,300,700);
		//path.cubicTo(100,100,500,300,300,700);
		//path.rCubicTo(100,100,500,300,300,700);
		//path.addArc(100,100,1000,700,-180,180);
		//path.cubicTo(100,100,200,200,300,300);
		path.moveTo(100,100);
		path.quadTo(1000,300,300,700);


		ObjectAnimator mAnimator = ObjectAnimator.ofFloat(curved, View.X, View.Y, path);

		Path p = new Path();
		p.lineTo(0.6f, 0.9f);
		p.lineTo(0.75f, 0.2f);
		p.lineTo(1f, 1f);
		mAnimator.setInterpolator(new PathInterpolator(p));

		mAnimator.setDuration(3000);
		mAnimator.start();
	}

	public void vector(){
		Drawable drawable = vector.getBackground();
		if (drawable instanceof Animatable) {
			((Animatable) drawable).start();
		}
	}

	public void transitions(){
		Intent intent = new Intent(getActivity(),TransitionsActivity.class);
		getActivity().startActivity(intent);

	}
}
