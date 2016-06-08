package es.source.code.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import es.source.code.R;

public class MainScreen extends Activity {

	private String[] data = { "µã²Ë", "²é¿´¶©µ¥", "µÇÂ¼/×¢²á", "ÏµÍ³°ïÖú" };

	private List<Item> itemList = new ArrayList<Item>();

	boolean isLoginSuccess;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen);
		Intent intent = getIntent();
		String data = intent.getStringExtra("extra_data");
		if (("FromEntry".equals(data)) || ("LoginSuccess".equals(data))) {
			isLoginSuccess = true;
		}
		if (isLoginSuccess)
			initItems();
		else
			initItemsLess();
		ItemAdapter adapter = new ItemAdapter(MainScreen.this,
				R.layout.itemlayout, itemList);
		ListView listView = (ListView) findViewById(R.id.navigation);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Item item = itemList.get(position);
				if ("µÇÂ¼/×¢²á".equals(item.getName())) {
					Intent intent = new Intent(MainScreen.this,
							LoginOrRegister.class);
					startActivity(intent);
				}
				 Toast.makeText(MainScreen.this, item.getName(),
				 Toast.LENGTH_SHORT).show();
			}
		});

	}

	private void initItemsLess() {
		Item i3 = new Item(data[2], R.drawable.login);
		itemList.add(i3);
		Item i4 = new Item(data[3], R.drawable.help);
		itemList.add(i4);
	}

	private void initItems() {
		Item i1 = new Item(data[0], R.drawable.order);
		itemList.add(i1);
		Item i2 = new Item(data[1], R.drawable.menu);
		itemList.add(i2);
		Item i3 = new Item(data[2], R.drawable.login);
		itemList.add(i3);
		Item i4 = new Item(data[3], R.drawable.help);
		itemList.add(i4);
	}

}
