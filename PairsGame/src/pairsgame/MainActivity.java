package pairsgame;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

import com.zhao.pairsgame.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView kn=(TextView) findViewById(R.id.kn);
		final Button easy=(Button) findViewById(R.id.easy);
		final Button medium=(Button) findViewById(R.id.medium);
		final Button hard=(Button) findViewById(R.id.hard);
		final TextView welcome1=(TextView) findViewById(R.id.hello);
		getKn know=new getKn();
		kn.setTextSize(25);
		try {
			kn.setText("Tips of soccer:\n"+know.getK(MainActivity.this));
			kn.setTextSize(20);
			kn.getPaint().setFakeBoldText(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		easy.setBackgroundResource(R.drawable.level1);
		Button.OnClickListener easyLis=new Button.OnClickListener(){

        	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
        		Intent easyIn = new Intent(MainActivity.this,Welcome.class);
        		startActivity(easyIn);
        		MainActivity.this.finish();
        		
        	}
    	
        };
        easy.setOnClickListener(easyLis);
		medium.setBackgroundResource(R.drawable.level2);
		Button.OnClickListener mediumLis=new Button.OnClickListener(){

        	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
        		Intent mediumIn = new Intent(MainActivity.this,Medium.class);
        		startActivity(mediumIn);
        		MainActivity.this.finish();
        	}
    	
        };
        medium.setOnClickListener(mediumLis);
		hard.setBackgroundResource(R.drawable.level3);
		Button.OnClickListener hardLis=new Button.OnClickListener(){

        	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
        		Intent hardIn = new Intent(MainActivity.this,Hard.class);
        		startActivity(hardIn);
        		MainActivity.this.finish();
        	}
    	
        };
        hard.setOnClickListener(hardLis);
		welcome1.setBackgroundResource(R.drawable.welcomeicon1);
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
	
}
