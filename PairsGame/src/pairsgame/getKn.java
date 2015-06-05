package pairsgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.zhao.pairsgame.R;

import android.content.Context;

public class getKn {

	public String getK(Context con) throws IOException{
		InputStream inputStream = con.getResources().openRawResource(R.raw.kn);
		int n=0;
		Random random = new Random();
    	n = random.nextInt(28);
		InputStreamReader inputStreamReader = null;
		inputStreamReader = new InputStreamReader(inputStream);  
		BufferedReader reader = new BufferedReader(inputStreamReader);    
	    String line =reader.readLine();  
	    String kn=line;
	    int i=0;
	    try {  
	        while ((line = reader.readLine()) != null ) {  
	        	if(i==n){
	        		break;
	        	}
	            i++; 
	        	kn=line;
	        }  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    return kn;  
	}
}
