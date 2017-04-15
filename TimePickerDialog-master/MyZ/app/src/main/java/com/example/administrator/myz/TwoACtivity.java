package com.example.administrator.myz;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myz.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/12.
 */

public class TwoACtivity extends Activity {

    private TextView tvTime;
    TimePickerView pvTime;
    RelativeLayout Rl;


    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = (TextView) findViewById(R.id.tvTime);
        Rl = (RelativeLayout) findViewById(R.id.t);
        Rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TwoACtivity.this.finish();
            }
        });
        // 时间选择器
        pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
        // 控制时间范围
//		 Calendar calendar = Calendar.getInstance();
//		 pvTime.setRange(calendar.get(Calendar.YEAR) - 20,
//		 calendar.get(Calendar.YEAR));
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);

        Log.d("----------","-----------11111111===="+pvTime.decorView.hasFocusable());

        if (!pvTime.decorView.hasFocusable())

            Log.d("----------","-----------3333===="+pvTime.decorView.hasFocusable());
//            TwoACtivity.this.finish();


        // 时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                Toast.makeText(TwoACtivity.this,getTime(date),Toast.LENGTH_SHORT).show();
                TwoACtivity.this.finish();
            }
        });

        pvTime.setOnTimeUnSelectListener(new TimePickerView.OnTimeUnSelectListener() {
            @Override
            public void onTimeUnSelect() {
                Toast.makeText(TwoACtivity.this,"取消了",Toast.LENGTH_SHORT).show();
                TwoACtivity.this.finish();
            }
        });
//        // 弹出时间选择器
        tvTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pvTime.show();
            }
        });
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        TwoACtivity.this.finish();
        return super.onKeyDown(keyCode, event);

    }
}
