package com.example.mynews.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyIndicate extends View {
	// 控件大小
	private int w, h;
	private Paint whitePaint;
	private Paint grayPaint;
	// 圆点大小和距离
	private int circleWidth = dp2px(4);
	private int circleMargin = dp2px(4);

	// 第一个圆的起始位置
	private int circleStart;
	// 圆的数量
	private int circleNum;
	// 被选中的圆
	private int circleIndex;

	public MyIndicate(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyIndicate(Context context) {
		this(context, null);
	}

	public MyIndicate(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initPaint();
	}

	private void initPaint() {
		whitePaint = new Paint();
		whitePaint.setColor(Color.WHITE);
		whitePaint.setAntiAlias(true);

		grayPaint = new Paint();
		grayPaint.setColor(Color.GRAY);
		grayPaint.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (circleNum <= 0) {
			return;
		}
//		System.out.println("w:"+w+"h:"+h+"circleNum:"+circleNum+"circleIndex:"+circleIndex+"circleWidth:"+circleWidth);
		circleStart = w / 2 - ((2 * circleNum - 1) * circleWidth) + circleWidth / 2;
		for (int i = 0; i < circleNum; i++) {
			if (i == circleIndex)
				canvas.drawCircle(circleStart + 4 * i * circleWidth, h / 2, circleWidth, whitePaint);
			else
				canvas.drawCircle(circleStart + 4 * i * circleWidth, h / 2, circleWidth, grayPaint);
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		this.w = w;
		this.h = h;
	}

	/**
	 * dp转为像素
	 * 
	 * @param dp
	 * @return
	 */
	private int dp2px(float dp) {
		float density = getContext().getResources().getDisplayMetrics().density;
		int mpx = (int) (dp * (density) + 0.5f);
		return mpx;
	}

	public void setCircleWidth(int circleWidth) {
		this.circleWidth = circleWidth;
	}

	public void setCircleNum(int circleNum) {
		this.circleNum = circleNum;
	}

	public void setCircleIndex(int circleIndex) {
		this.circleIndex = circleIndex;
		this.invalidate();
	}
}
