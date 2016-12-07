package com.itheima.androidl.fragment;


import android.view.View;

import com.itheima.androidl.R;

public class SupportFragment extends BaseFragment{
	protected View initView(){
		return View.inflate(getActivity(), R.layout.fragment_support,null);
	}
	@Override
	public String getUrl() {
		return "file:///android_asset/support.html";
	}
}
