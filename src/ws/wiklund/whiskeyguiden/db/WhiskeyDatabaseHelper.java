package ws.wiklund.whiskeyguiden.db;

import ws.wiklund.guides.db.BeverageDatabaseHelper;
import ws.wiklund.guides.db.DatabaseUpgrader;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class WhiskeyDatabaseHelper extends BeverageDatabaseHelper {
	private static final long serialVersionUID = -5292283554948327267L;

	public static final String DATABASE_NAME = "beerguide.db";
	private static final int DATABASE_VERSION = WhiskeyDatabaseUpgrader.VERSION_1;

	public WhiskeyDatabaseHelper(Context context) {
		this(context, DATABASE_NAME);
	}

	//Used for testing so that db can be created and dropped with out destroying dev data
	public WhiskeyDatabaseHelper(Context context, String dbName) {
		super(context, dbName, DATABASE_VERSION);
	}

	@Override
	public DatabaseUpgrader getDatabaseUpgrader(SQLiteDatabase db) {
		return new WhiskeyDatabaseUpgrader(db);
	}

}
