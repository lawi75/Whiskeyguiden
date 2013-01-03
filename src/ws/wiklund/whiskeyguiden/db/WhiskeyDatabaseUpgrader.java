package ws.wiklund.whiskeyguiden.db;

import ws.wiklund.guides.db.DatabaseUpgrader;
import ws.wiklund.guides.model.BeverageType;
import android.database.sqlite.SQLiteDatabase;

public class WhiskeyDatabaseUpgrader extends DatabaseUpgrader {
	//Available DB versions
	static final int VERSION_1 = 1;

	public WhiskeyDatabaseUpgrader(SQLiteDatabase db) {
		super(db);
	}

	public int upgrade(int oldVersion, int newVersion) {
		int version = -1;

		/*switch (oldVersion) {
			case VERSION_1:
				if(newVersion > VERSION_1) {
					version = moveToVersion2();
					Log.d(BeerDatabaseUpgrader.class.getName(), "Upgraded DB from version [" + oldVersion + "] to version [" + version + "]");
					
					if(version < newVersion) {
						return upgrade(version, newVersion);
					}
					
					return VERSION_2;
				}
				
				break;				
			case VERSION_2:
				if(newVersion > VERSION_2) {
					version = moveToVersion3();
					Log.d(BeerDatabaseUpgrader.class.getName(), "Upgraded DB from version [" + oldVersion + "] to version [" + version + "]");
					
					if(version < newVersion) {
						return upgrade(version, newVersion);
					}
					
					return VERSION_3;
				}
				
				break;				
			default:
				break;
		}*/

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
