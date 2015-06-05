package pairsgame;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Random;

import com.zhao.pairsgame.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends Activity {

	
	public int step=0;
	private int preV=-1;
	private int preId=-1;
	pairList P=new pairList(8);
    Button.OnClickListener[] listener=new Button.OnClickListener[16];
   
    ArrayList<Integer> list=new ArrayList<Integer>();
    ArrayList<Boolean> bingo=new ArrayList<Boolean>();
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Intent easy = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //pairs[] P=new pairs[8];
        getRecord gr=new getRecord();
        record r;
        try {
			r=gr.getRecord(Welcome.this, 1);
			final TextView recordShow=(TextView) findViewById(R.id.record);
	        recordShow.setText("Easy Level Record: "+r.getN()+" "+r.getT()+"s");
	        recordShow.setTextSize(20);
			recordShow.getPaint().setFakeBoldText(true);
		} catch (StreamCorruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        for(int i=1;i<17;i++){
        	list.add(i);
        	bingo.add(false);
        }//give the list 1 to 16 buttons
        int n=16;
        for(int i=0;i<8;i++){
        	Random random = new Random();
        	int a = random.nextInt(n);
        	int num1=list.get(a);
        	list.remove(a);
        	n--;
        	int b = random.nextInt(n);
        	int num2=list.get(b);
        	list.remove(b);
        	n--;
        	P.add(i,num1,num2);
        	//final Button button1=(Button) findViewById(2131034172+num1-1);
        	//final Button button2=(Button) findViewById(2131034172+num2-1);
        	//button1.setText(String.valueOf(i));
        	//button2.setText(String.valueOf(i));
        }

        final Button[] b=new Button[16];
        for(int i=0;i<16;i++){
        	b[i]=(Button) findViewById(R.id.b1+i);//2131034172 is R.id.b1
        }
        final TextView steps = (TextView) findViewById(R.id.steps);
     
        for( int i=0;i<16;i++){
        	final int j=i;
        	listener[i]=new Button.OnClickListener() 
    		{
        		int time=0;
        		TextView TV=(TextView)findViewById(R.id.clock);
        		final Handler handler=new Handler();
        		Runnable runnable;
        		public void onClick(View v)
    			{	
    				
    				if(bingo.get(j)==false&&preId!=j){
    					step++;
    					if(preV!=-1&&preId!=-1){
    						if(preV==P.getValue(j+1)){
    							bingo.set(j,true);
    							bingo.set(preId,true);
    							P.setRight();

    						}else{
    							if(bingo.get(preId)==false){
    								final Button button2=(Button) findViewById(R.id.b1+preId);
    								//button2.setText("");
    								button2.setBackgroundResource(R.drawable.lconfootball);
    							}
    						}
    					}
    					final Button button1=(Button) findViewById(R.id.b1+j);
    					//button1.setText(String.valueOf(P.getValue(j+1)));
    					button1.setBackgroundResource(R.drawable.lcon1+P.getValue(j+1));//this is the id of lcon1(little icon1)
    					if(P.ifAllRight()==true){
    						steps.setText("Done!\n"+"Moves\n"+String.valueOf(step));
    						
    						
    					}else{
    						steps.setText("Moves\n"+String.valueOf(step));
    					}
    				}
    					if(preId==-1){
        					
        					
        					runnable=new Runnable(){
        						public void run(){
        							time++;
        							TV.setText("Time: "+time+"s");
        							if(P.ifAllRight()==false){
        								handler.postDelayed(this,1000);
        								
        							}
        							if(P.ifAllRight()==true){
        								checkRecord cr=new checkRecord();
        								try {
        									cr.check(1, time, Welcome.this);
        								} catch (ClassNotFoundException e) {
        									// TODO Auto-generated catch block
        									e.printStackTrace();
        								} catch (IOException e) {
        									// TODO Auto-generated catch block
        									e.printStackTrace();
        								}
        								
        							}
        							
        						}
        					};
        					
        					handler.postDelayed(runnable,1000);
        				}//clock..
    					if(bingo.get(j)==false&&preId!=j){
    						preId=j;
    						preV=P.getValue(j+1);
    					
    					
    					}
    					
    			}
    		};
        }
       
        for(int j=0;j<16;j++){
        	b[j].setOnClickListener(listener[j]);
        }
        		
        Button restart=(Button) findViewById(R.id.restart);
        restart.setBackgroundResource(R.drawable.restart);
        Button.OnClickListener restartLis=new Button.OnClickListener(){

        	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
        		Intent intent = getIntent();
        		finish();
        		startActivity(intent);
        	}
    	
        };
        restart.setOnClickListener(restartLis);
        Button back=(Button) findViewById(R.id.back);
        back.setBackgroundResource(R.drawable.back);
        Button.OnClickListener backLis=new Button.OnClickListener(){
        	public void onClick(View v){
        		Intent intent=new Intent(Welcome.this,MainActivity.class);
        		startActivity(intent);
        		Welcome.this.finish();
        	}
        };
        back.setOnClickListener(backLis);
        
    }

    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
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
