package es.source.code.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import es.source.code.R;

public class SCOSEntry extends Activity {

	float x1=0;
	float x2=0;
	float y1=0;
	float y2=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	// TODO Auto-generated method stub
    	if (event.getAction()== MotionEvent.ACTION_DOWN) {
    		x1 = event.getX();
    		y1 = event.getY();
    	}
    	if(event.getAction()==MotionEvent.ACTION_UP) {
    		x2 = event.getX();
    		y2 = event.getY();
    		if ((x1-x2)>50) {
    			Intent intent = new Intent(SCOSEntry.this,MainScreen.class);
    			startActivity(intent);
//    			Toast.makeText(SCOSEntry.this, "left", Toast.LENGTH_SHORT).show();
    		}
    	}
    	return super.onTouchEvent(event);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
