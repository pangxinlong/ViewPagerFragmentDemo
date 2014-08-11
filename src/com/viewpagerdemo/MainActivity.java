package com.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<Fragment> fragmentList;
//	private ImageView image;
//	private TextView view1, view2, view3, view4;
//	private int currIndex;// 当前页卡编号
//	private int bmpW;// 横线图片宽度
//	private int offset;// 图片移动的偏移量

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);

	//	InitTextView();
	//	InitImage();
		InitViewPager();
	}

	/*
	 * 初始化标签名
	 */
/*	public void InitTextView() {
		view1 = (TextView) findViewById(R.id.tv_guid1);
		view2 = (TextView) findViewById(R.id.tv_guid2);
		view3 = (TextView) findViewById(R.id.tv_guid3);
		view4 = (TextView) findViewById(R.id.tv_guid4);

		view1.setOnClickListener(new txListener(0));
		view2.setOnClickListener(new txListener(1));
		view3.setOnClickListener(new txListener(2));
		view4.setOnClickListener(new txListener(3));
	}

	public class txListener implements View.OnClickListener {
		private int index = 0;

		public txListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mViewPager.setCurrentItem(index);
		}
	}
*/
	/*
	 * 初始化图片的位移像素
	 */
/*	public void InitImage() {
		image = (ImageView) findViewById(R.id.cursor);
		bmpW = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher).getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (screenW / 4 - bmpW) / 2;

		// imgageview设置平移，使下划线平移到初始位置（平移一个offset）
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		image.setImageMatrix(matrix);
	}
*/
	/*
	 * 初始化ViewPager
	 */
	public void InitViewPager() {
		fragmentList = new ArrayList<Fragment>();
		
		Fragment firstFragment = new TestFragment();
		Fragment secondFragment =new TestFragment();
		Fragment thirdFragment = new TestFragment();
		
		fragmentList.add(firstFragment);
		fragmentList.add(secondFragment);
		fragmentList.add(thirdFragment);

		// 给ViewPager设置适配器
		MyFragmentPagerAdapter myAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
		mViewPager.setAdapter(myAdapter);
		mViewPager.setCurrentItem(0);// 设置当前显示标签页为第一页
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());// 页面变化时的监听器
		}

	public class MyOnPageChangeListener implements OnPageChangeListener {
	//	private int one = offset * 2 + bmpW;// 两个相邻页面的偏移量

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
	//		Animation animation = new TranslateAnimation(currIndex * one, arg0
	//				* one, 0, 0);// 平移动画
	//		currIndex = arg0;
	//		animation.setFillAfter(true);// 动画终止时停留在最后一帧，不然会回到没有执行前的状态
	//		animation.setDuration(200);// 动画持续时间0.2秒
		//	image.startAnimation(animation);// 是用ImageView来显示动画的
			int i = arg0 + 1;
			Toast.makeText(MainActivity.this, "您选择了第" + i + "个页卡",
					Toast.LENGTH_SHORT).show();
		}
	}



	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}