

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

public class DbLoader extends CursorLoader {

	DbOperations dbOperations;
	public DbLoader(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	dbOperations= new DbOperations(context);
	dbOperations.openDb();
	}
	
	@Override
	public Cursor loadInBackground() {
		// TODO Auto-generated method stub
		return super.loadInBackground();
		
	}

}
