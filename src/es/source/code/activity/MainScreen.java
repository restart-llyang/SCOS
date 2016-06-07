package es.source.code.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import es.source.code.R;

public class MainScreen extends Activity {

	private String[] data = { "点菜", "查看订单", "登录/注册", "系统帮助" };

	private List<Item> itemList = new ArrayList<Item>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen);
		initItems();
		ItemAdapter adapter = new ItemAdapter(MainScreen.this,
				R.layout.itemlayout, itemList);
		ListView listView = (ListView) findViewById(R.id.navigation);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Item item = itemList.get(position);
				Toast.makeText(MainScreen.this, item.getName(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void initItems() {
		Item i1 = new Item(data[0], R.drawable.ic_launcher);
		itemList.add(i1);
		Item i2 = new Item(data[1], R.drawable.ic_launcher);
		itemList.add(i2);
		Item i3 = new Item(data[2], R.drawable.ic_launcher);
		itemList.add(i3);
		Item i4 = new Item(data[3], R.drawable.ic_launcher);
		itemList.add(i4);
	}

}
