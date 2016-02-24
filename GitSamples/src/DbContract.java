

import android.provider.BaseColumns;

public class DbContract {

	public DbContract() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 public static abstract class DbEntry implements BaseColumns {
	        public static final String TABLE_NAME = "databasename";
	        public static final String COLUMN_NAME_ENTRY_ID = "_id";
	        public static final String COLUMN_NAME_TITLE = "title";
	        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
	      
	    }

}
