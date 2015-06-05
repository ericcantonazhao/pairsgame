package pairsgame;

import android.app.AlertDialog;
import android.content.Context;

public class justSs {
	public justSs(Context context,int time){
		AlertDialog.Builder good =new AlertDialog.Builder(context);
		good.setTitle("Good job! Try harder to break the record!\nYour time is "+time);
		good.setNegativeButton("Yes", null);
		good.show();
	}
	
}
