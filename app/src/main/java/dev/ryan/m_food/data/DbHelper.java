package dev.ryan.m_food.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, Contract.DATABASE_NAME , null, Contract.DATABASE_VERSION);
    }
    private static DbHelper mInstance = null;
    public static DbHelper getInstance(Context ctx) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an abddgdgdgzzzqqwertyuipzxzcvcbnbnmnm,.   vity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (mInstance == null) {
            mInstance = new DbHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String user_table = "CREATE TABLE "
                + Contract.TABLE_USERS + "("
                + Contract.COLUMN_USER_ID + " INTEGER PRIMARY KEY,"
                + Contract.COLUMN_USER_NAME + " STRING NOT NULL,"
                + Contract.COLUMN_USER_PASSWORD + " STRING NOT NULL"
                + ")";

        final String farm_table = "CREATE TABLE "
                + Contract.TABLE_FARM + "("
                + Contract.COLUMN_FARM_ID + " INTEGER PRIMARY KEY,"
                + Contract.COLUMN_FARM_TYPE + " INTEGER NOT NULL,"
                + Contract.COLUMN_FARM_NAME + " STRING NOT NULL,"
                + Contract.COLUMN_FARM_STOCK + " INTEGER NOT NULL,"
                + Contract.COLUMN_FARM_IMAGE + " INTEGER NOT NULL"
                + ")";

        db.execSQL(user_table);
        db.execSQL(farm_table);
    }

    //TODO: Upgrade farm_table (add "picture" column), INTEGER NOT NULL (picture drawable directory converted to int)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
