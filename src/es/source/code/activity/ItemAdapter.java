package es.source.code.activity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.source.code.R;

public class ItemAdapter extends ArrayAdapter<Item>{
	
	private int resourceId;
	
	public ItemAdapter(Context context,int textViewresourceId,List<Item>objects) {
		super(context,textViewresourceId,objects);
		resourceId = textViewresourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Item item = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView itemImage = (ImageView) view.findViewById(R.id.item_image);
		TextView itemName = (TextView) view.findViewById(R.id.item_name);
		itemImage.setImageResource(item.getImageId());
		itemName.setText(item.getName());
		return view;
	}
	
}
