package es.source.code.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import es.source.code.R;

public class LoginOrRegister extends Activity{
	
	private EditText accountEdit;
	
	private EditText passwordEdit;

	private Button loginButton;
	
	private Button returnButton;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		accountEdit = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		loginButton = (Button) findViewById(R.id.login);
		returnButton = (Button) findViewById(R.id.return_button);
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String account = accountEdit.getText().toString();
				if (ValidatName(account)) {
					Intent intent = new Intent(LoginOrRegister.this,MainScreen.class);
					intent.putExtra("extra_data", "LoginSuccess");
					startActivity(intent);
				} else {
					accountEdit.setError("输入内容不符合规则");
				}
			}
		});
		
		returnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginOrRegister.this,MainScreen.class);
				intent.putExtra("extra_data", "Return");
				startActivity(intent);
			}
		});
	}
	
	private static boolean ValidatName(String account) {
		final String strRegax = "^[A-Za-z0-9\\-]+";
		Pattern pattern = Pattern.compile(strRegax);
		Matcher matcher = pattern.matcher(account);
		return matcher.find();
	}
}
