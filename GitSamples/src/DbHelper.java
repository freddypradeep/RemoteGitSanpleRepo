

import com.example.database.DbContract.DbEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Constants;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME="FeedReader.db";
	public static final int DATABASE_VERSION=1;
	private String tag="DbHelper";
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
	    "CREATE TABLE " + DbEntry.TABLE_NAME + " (" +
	    DbEntry.COLUMN_NAME_ENTRY_ID + " INTEGER PRIMARY KEY," +
	    DbEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
	    DbEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE+
	     // Any other options for the CREATE command
	    " );";

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i(tag,"onCreate");
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
