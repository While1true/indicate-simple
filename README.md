# indicate-simple
this is a simple indicate for ViewPager, easy to ues.

使用步骤， folloow this steps to use it.
1.在布局中引用
 <android.support.v4.view.ViewPager
        android:id="@+id/vp_home"
        android:layout_width="match_parent"
        android:layout_height="200dp" />

    <com.example.mynews.tools.MyIndicate
        android:id="@+id/myIndicate"
        android:layout_width="match_parent"
        android:layout_height="18dp"
        android:layout_alignParentBottom="true"
        android:background="#10000000" />
        
        
2.找到控件
indicate = (MyIndicate) headerview.findViewById(R.id.myIndicate);

3.在ViewPager设置适配器后设置参数
//初始化Indicate
				indicate.setCircleNum(mTopStories.size());
				indicate.setCircleIndex(currentPager%mTopStories.size());
				
4.时时更新，随着ViewPager的滑动
	mViewpager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				//滑动时让自定义View指示目标生效
				currentPager=arg0;
				indicate.setCircleIndex(currentPager%mTopStories.size());
				
			}
