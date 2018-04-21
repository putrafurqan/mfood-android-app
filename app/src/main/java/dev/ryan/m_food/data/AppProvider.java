package dev.ryan.m_food.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class AppProvider extends ContentProvider {

    DbHelper mDbHelper = new DbHelper(getContext());
    @Override
    public boolean onCreate() {
        mDbHelper = DbHelper.getInstance(getContext());
        return true;
    }

    @Override
    public Cursor query( Uri uri, String[] projection, String selection, String[] selectionArgs, String sortBy) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (Contract.uriMatcher.match(uri)) {
            case Contract.USERS_CASE:
                break;
            case Contract.USERS_CASE_ID:
                cursor = db.query(Contract.TABLE_USERS, projection, selection, selectionArgs, null,null,null);
            case Contract.FARM_CASE:
                break;
            case Contract.FARM_CASE_ID:
                break;
        }
        return cursor;
    }

    @Override
    public String getType( Uri uri) {
        return null;
    }

    @Override
    public Uri insert( Uri uri, ContentValues values) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        switch (Contract.uriMatcher.match(uri)) {
            case Contract.USERS_CASE:
                long userId = db.insert(Contract.TABLE_USERS, null, values);
                if (userId > 0) {
                    uri = ContentUris.withAppendedId(Contract.URI_USERS, userId);
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                    break;

            case Contract.FARM_CASE:
                long farmId = db.insert(Contract.TABLE_FARM, null, values);
                if (farmId > 0) {
                    uri = ContentUris.withAppendedId(Contract.URI_FARM, farmId);
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                break;

            default:
                Log.v("Case", "default");
                throw new SQLException("Failed to insert row into " + uri);

        }
        return uri;
    }


    @Override
    public int delete( Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update( Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
