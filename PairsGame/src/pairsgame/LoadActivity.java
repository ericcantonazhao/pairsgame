package pairsgame;

import com.zhao.pairsgame.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class LoadActivity extends Activity {
	private static final int LOAD_DISPLAY_TIME = 1500;
	     
	   /** Called when the activity is first created. */
	  @Override
	 public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	         
	       
	
	        setContentView(R.layout.load);
	
	        new Handler().postDelayed(new Runnable() {
	            public void run() {
                /* Create an Intent that will start the Main WordPress Activity. */
	            	
	               Intent mainIntent = new Intent(LoadActivity.this, MainActivity.class);
	                LoadActivity.this.startActivity(mainIntent);
	               LoadActivity.this.finish();
	         }
	      }, 1000+LOAD_DISPLAY_TIME); 
	
	    }
	 }