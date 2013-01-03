package ws.wiklund.whiskeyguiden.activities;

import ws.wiklund.guides.activities.BeverageActivity;
import ws.wiklund.guides.db.BeverageDatabaseHelper;
import ws.wiklund.whiskeyguiden.db.WhiskeyDatabaseHelper;

public class WhiskeyActivity extends BeverageActivity {

	@Override
	protected BeverageDatabaseHelper getDatabaseHelper() {
		return new WhiskeyDatabaseHelper(this);
	}

	@Override
	protected Class<?> getModifyBeverageActivityClass() {
		return ModifyWhiskeyActivity.class;
	}
	
}
