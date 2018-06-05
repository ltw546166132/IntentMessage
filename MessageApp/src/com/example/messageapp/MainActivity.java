package com.example.messageapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private String[] smss = new String[] {"String1","String2","String3","String4","String5"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv =  (ListView) findViewById(R.id.lv_msg);
		ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), R.layout.msgitem, smss );
		lv.setAdapter(adpter);
		//给当前的listview添加一个条目的点击事件
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//parent:哪个listview被点击这个对象就被传进来
				//view:被点击的条目对应的View对象
				//被点击的View对应的条目索引
				//被点击的View所对应的数据在数据集合中的索引
				String msg = smss[position];
				Intent intent = new Intent();
				intent.setAction("android.intent.action.SEND");
				intent.setType("text/plain");
				intent.putExtra("sms_body", msg);
				startActivity(intent);
			}
		});
	}

}
