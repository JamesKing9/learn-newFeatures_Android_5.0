package com.itheima.androidl.fragment;

import android.graphics.Outline;
import android.graphics.Path;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itheima.androidl.R;

public class ShadowFragment extends BaseFragment{

	TextView tv1,tv2,circle1,circle2,cut1,cut2,cut3,cut4,cut5,cut6;
	EditText et1,et2;
	Button bt;

	protected View initView(){
		View view = View.inflate(getActivity(), R.layout.fragment_shadow,null);

		changeZ(view);

		outLine(view);

		cut(view);

		return view;
	}

	private void changeZ(View view){
		tv1 = (TextView) view.findViewById(R.id.tv1);
		tv2 = (TextView) view.findViewById(R.id.tv2);

		et1 = (EditText) view.findViewById(R.id.et1);
		et2 = (EditText) view.findViewById(R.id.et2);

		bt = (Button) view.findViewById(R.id.bt);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String str1 = et1.getText().toString();
				String str2 = et2.getText().toString();
				if (str1 == null || str1.isEmpty()){
					str1 = "0";
				}
				if (str2 == null || str2.isEmpty()){
					str2 = "0";
				}
				int z1 = Integer.valueOf(str1);
				int z2 = Integer.valueOf(str2);

				tv1.setText(z1 + "dp");
				tv2.setText(z2 + "dp");

				tv1.setElevation(z1);
				tv2.setElevation(z2);

			}
		});
	}

	private void outLine(View view){
		circle1 = (TextView) view.findViewById(R.id.tv_circle_1);
		circle2 = (TextView) view.findViewById(R.id.tv_circle_2);

		ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
			public void getOutline(View view, Outline outline) {
				// 可以指定圆形，矩形，圆角矩形，path
				outline.setOval(0, 0, view.getWidth(), view.getHeight());
			}
		};
		circle1.setOutlineProvider(viewOutlineProvider );

		viewOutlineProvider = new ViewOutlineProvider() {
			public void getOutline(View view, Outline outline) {
				// 可以指定圆形，矩形，圆角矩形，path
				outline.setOval(50, 50, view.getWidth() - 100, view.getHeight() - 100);
			}
		};
		circle2.setOutlineProvider(viewOutlineProvider);
	}

	private void cut(View view){
		cut1 = (TextView) view.findViewById(R.id.cut1);
		cut2 = (TextView) view.findViewById(R.id.cut2);
		cut3 = (TextView) view.findViewById(R.id.cut3);
		cut4 = (TextView) view.findViewById(R.id.cut4);
		cut5 = (TextView) view.findViewById(R.id.cut5);
		cut6 = (TextView) view.findViewById(R.id.cut6);

		ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
			public void getOutline(View view, Outline outline) {
				Path p = new Path();
				p.moveTo(view.getWidth()/2,0);
				p.lineTo(0,view.getHeight());
				p.lineTo(view.getWidth(),view.getHeight());
				p.close();
				outline.setConvexPath(p);
			}
		};
		cut2.setOutlineProvider(viewOutlineProvider);
		cut2.setClipToOutline(true);

		viewOutlineProvider = new ViewOutlineProvider() {
			public void getOutline(View view, Outline outline) {
				outline.setOval(0,0,view.getWidth(),view.getHeight());
			}
		};
		cut3.setOutlineProvider(viewOutlineProvider);
		cut3.setClipToOutline(true);

		viewOutlineProvider = new ViewOutlineProvider() {
			public void getOutline(View view, Outline outline) {
				outline.setRoundRect(0,0,view.getWidth(),view.getHeight(),25);
			}
		};
		cut4.setOutlineProvider(viewOutlineProvider);
		cut4.setClipToOutline(true);

		viewOutlineProvider = new ViewOutlineProvider() {
			public void getOutline(View view, Outline outline) {
				outline.setRect(-50,-50,view.getWidth() + 100,view.getHeight()+100);
			}
		};
		cut5.setOutlineProvider(viewOutlineProvider);
		cut5.setClipToOutline(true);

		cut5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),"View的测量大小:" + v.getMeasuredWidth() + "*" +v.getMeasuredHeight(),Toast.LENGTH_SHORT).show();
			}
		});

		viewOutlineProvider = new ViewOutlineProvider() {
			public void getOutline(View view, Outline outline) {
				outline.setRect(50,50,view.getWidth() - 100,view.getHeight()-100);
			}
		};
		cut6.setOutlineProvider(viewOutlineProvider);
		cut6.setClipToOutline(true);

		cut6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),"View的布局大小:" + v.getWidth() + "*" +v.getHeight(),Toast.LENGTH_SHORT).show();

			}
		});
	}

	@Override
	public String getUrl() {
		return "file:///android_asset/shadow.html";
	}
}
