package com.kangren.cpr;

import com.example.kanren.cpr.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class EnterActivity extends Activity implements OnClickListener {
	private String type;
	private SharedPreferences sp;
	private boolean isFirst = false;
	//配置完毕
	private TextView enter;
	//模拟人名称
	private ClearEditText mEtCprName;
	//打印机名称
	private ClearEditText mPrinterName;
	
	private ClearEditText ip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter);
		sp = getSharedPreferences("cpr_config", MODE_PRIVATE);
		isFirst = sp.getBoolean("isFirst", true);
		if (isFirst) {
			//初次运行，显示配置界面
			initView(); 
		}else{
			//非初次运行，取出配置项，跳转MainActivity
			Intent i = new Intent(EnterActivity.this,MainActivity.class);
			startActivity(i);
			this.finish();
		}
	}

	private void initView() {
		enter = (TextView) findViewById(R.id.enter);
		mEtCprName = (ClearEditText) findViewById(R.id.cpr_name);
		mPrinterName = (ClearEditText) findViewById(R.id.printer_name);
		ip= (ClearEditText) findViewById(R.id.cpr_ip);
		enter.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.enter: 
			String cpr_name = mEtCprName.getText().toString().trim();
			String printer_name = mPrinterName.getText().toString().trim();
			
			if(cpr_name.length() == 0){
				return;
			}
			if(printer_name.length() == 0){ 
				return;
			}
			// 完成存入sp
			Editor editor = sp.edit();
			editor.putBoolean("isFirst", false);
			editor.putString("cpr_name", cpr_name);
			editor.putString("printer_name", printer_name);
			editor.putString("ip", ip.getText().toString().trim());
			editor.commit();
			
			
			Intent i = new Intent(EnterActivity.this,MainActivity.class);
			startActivity(i);
			this.finish();
			
			break;

		default:
			break;
		}
		
	}


}
