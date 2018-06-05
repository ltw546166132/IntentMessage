# IntentMessage
实现ListView条目的点击事件，传字符串给系统发短信Activity并打开此Activity

//ListView条目添加点击事件：
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
