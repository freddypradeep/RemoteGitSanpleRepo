

import com.example.database.DbContract.DbEntry;
import com.example.database.util.Constants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/*this class has all db operations
 */
public class DbOperations {
	private static final String tag = "DbOperations";
	DbHelper dbhelper;
     SQLiteDatabase database;
	public DbOperations(Context context) {
		dbhelper=new DbHelper(context);
		// TODO Auto-generated constructor stub
	}
	/*this method is to insert a row in the table*/
	public void createRow(String title,String subtitle)
	{
		Log.i(tag, Constants.log_msg.createRow);
		ContentValues values=new ContentValues();
		values.put(DbEntry.COLUMN_NAME_TITLE,title);
		values.put(DbEntry.COLUMN_NAME_SUBTITLE,subtitle);
		database.insert(DbEntry.TABLE_NAME, null, values);
	}
	/*this method is used to read the row from the table*/
	public String readrow()
	{
		Log.i(tag, Constants.log_msg.readRow);
		Cursor cursor=database.query(DbEntry.TABLE_NAME, null, null, null, null, null, null);
		cursor.moveToFirst();
		int columnIndex =cursor.getColumnIndexOrThrow(DbEntry.COLUMN_NAME_TITLE);
		int columnIndex1 =cursor.getColumnIndexOrThrow(DbEntry.COLUMN_NAME_SUBTITLE);
		String result=cursor.getString(columnIndex)+cursor.getString(columnIndex1);
		return result;
	}
/*	this method is used to update a row in the table*/
	public void updateRow()
	{
		Log.i(tag, Constants.log_msg.update);
		ContentValues values=new ContentValues();
		values.put(DbEntry.COLUMN_NAME_TITLE,"title");
		values.put(DbEntry.COLUMN_NAME_SUBTITLE,"subtitle");
		database.update(DbEntry.TABLE_NAME,values, DbEntry.COLUMN_NAME_TITLE+" LIKE ?",new String[]{"cognizant"});
		

	}
/*	this method is used to delete row from the table*/
	public void deleteRow()
	{
		Log.i(tag, Constants.log_msg.delete_row);
		int noRows=database.delete(DbEntry.TABLE_NAME, DbEntry.COLUMN_NAME_TITLE + " LIKE ?", new String[]{"freddy"});
		Log.i(tag, "no of rows deleted = "+noRows);

	}
	/**this method is used to open database
	 * @see SQLiteOpenHelper#getWritableDatabase()
	 */
	public void openDb()
	{
		Log.i(tag,Constants.log_msg.openDb);
		database=dbhelper.getWritableDatabase();

	}
	/**this method is used to close database
	 * @see sqlite.SQLiteOpenHelper#close()*/
	public void closeDb()
	{
		Log.i(tag, Constants.log_msg.closedb);
		dbhelper.close();

	}
	public Cursor readRows()
	{
		Cursor cursor=database.query(DbEntry.TABLE_NAME, null, null, null, null, null, null);
		return cursor;
		
	}
}

