package ws.wiklund.whiskeyguiden.activities;

import ws.wiklund.guides.activities.BeverageStatsActivity;
import ws.wiklund.guides.db.BeverageDatabaseHelper;
import ws.wiklund.whiskeyguiden.db.WhiskeyDatabaseHelper;

public class StatsActivity extends BeverageStatsActivity {

	@Override
	protected BeverageDatabaseHelper getDatabaseHelper() {
		return new WhiskeyDatabaseHelper(this);
	}

}
