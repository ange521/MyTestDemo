package com.example.administrator.myz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


import com.example.administrator.myz.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {

	private TextView tvTime;
	TimePickerView pvTime;


	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvTime = (TextView) findViewById(R.id.tvTime);
//
//		// 时间选择器
//		pvTime = new TimePickerView(MainActivity.this, TimePickerView.Type.YEAR_MONTH_DAY);
//		// 控制时间范围
////		 Calendar calendar = Calendar.getInstance();
////		 pvTime.setRange(calendar.get(Calendar.YEAR) - 20,
////		 calendar.get(Calendar.YEAR));
//		pvTime.setTime(new Date());
//		pvTime.setCyclic(false);
//		pvTime.setCancelable(true);
//		// 时间选择后回调
//		pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
//
//			@Override
//			public void onTimeSelect(Date date) {
//				tvTime.setText(getTime(date));
//			}
//		});
		// 弹出时间选择器
		tvTime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, TwoACtivity.class);
				startActivity(intent);
			}
		});
	}

	public static String getTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(date);
	}
}
