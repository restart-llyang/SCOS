package es.source.code.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import es.source.code.activity.MainScreen;

public class TestMain extends Activity {
	
	private Button run;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		run = (Button) findViewById(R.id.run);
		run.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestMain.this,MainScreen.class);
				startActivity(intent);
			}
		});
	}
}
