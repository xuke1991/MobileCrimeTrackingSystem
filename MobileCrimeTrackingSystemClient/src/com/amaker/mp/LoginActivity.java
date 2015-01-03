package com.amaker.mp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.amaker.util.HttpUtil;

public class LoginActivity extends Activity {
	
	private Button cancelBtn,loginBtn;
	private EditText userEditText,pwdEditText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Mobile Crime Tracking System");
		setContentView(R.layout.login_system);
		
		cancelBtn = (Button)findViewById(R.id.cancelButton);
		loginBtn = (Button)findViewById(R.id.loginButton);
		
		userEditText = (EditText)findViewById(R.id.userEditText);
		pwdEditText = (EditText)findViewById(R.id.pwdEditText);
		
		
		cancelBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		loginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(validate()){
					if(login()){
						Intent intent = new Intent(LoginActivity.this,MainActivity.class);
						startActivity(intent);
					}else{
						showDialog("Invaild Account or Password!");
					}
				}
			}
		});
	}
	
	private boolean login(){
		String username = userEditText.getText().toString();
		String pwd = pwdEditText.getText().toString();
		String result=query(username,pwd);
		if(result!=null&&result.equals("1")){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean validate(){
		String username = userEditText.getText().toString();
		if(username.equals("")){
			showDialog("Account is empty!");
			return false;
		}
		String pwd = pwdEditText.getText().toString();
		if(pwd.equals("")){
			showDialog("Password is emppty!");
			return false;
		}
		return true;
	}
	private void showDialog(String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
		       .setCancelable(false)
		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	private String query(String username,String password){
		String queryString = "username="+username+"&password="+password;
		String url = HttpUtil.BASE_URL+"servlet/LoginServlet?"+queryString;
		return HttpUtil.queryStringForPost(url);
    }
}