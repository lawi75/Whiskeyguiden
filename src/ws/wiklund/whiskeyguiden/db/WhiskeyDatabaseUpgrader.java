package ws.wiklund.whiskeyguiden.db;

import ws.wiklund.guides.db.DatabaseUpgrader;
import ws.wiklund.guides.model.BeverageType;
import android.database.sqlite.SQLiteDatabase;

public class WhiskeyDatabaseUpgrader extends DatabaseUpgrader {

	public WhiskeyDatabaseUpgrader(SQLiteDatabase db) {
		super(db);
	}

	public int upgrade(int oldVersion, int newVersion) {
		int version = -1;

		switch (oldVersion) {
			case VERSION_1:
			case VERSION_2:
			case VERSION_3:
			case VERSION_4:
			case VERSION_5:
			case VERSION_6:
				return VERSION_7;
			default:
				break;
		}

		return version;
	}

	@Override
	public void createAndPopulateBeverageTypeTable(SQLiteDatabase db) {
		//1. create beverage type table
		db.execSQL(WhiskeyDatabaseHelper.DB_CREATE_BEVERAGE_TYPE);
		
		//2. populate beverage type table
		insertBeverageType(1, "Whiskey , Blended");
		insertBeverageType(2, "Whiskey , Malt");
		insertBeverageType(3, "Whiskey , Grain");
		insertBeverageType(4, "Whiskey , Rye");
		insertBeverageType(5, "Whiskey , Bourbon");
		insertBeverageType(BeverageType.OTHER.getId(), BeverageType.OTHER.getName());
	}
	
}
