package dev.ryan.m_food.data;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

public class Contract implements BaseColumns{
    public static final String DATABASE_NAME = "data.db";
    public static final int DATABASE_VERSION = 1;


    // Users table
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "_id";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_USER_PASSWORD = "password";

    // Farm table
    public static final String TABLE_FARM = "farm";
    public static final String COLUMN_FARM_ID = "_id";
    public static final String COLUMN_FARM_TYPE = "type";
    public static final String COLUMN_FARM_NAME = "name";
    public static final String COLUMN_FARM_STOCK = "stock";
    public static final String COLUMN_FARM_IMAGE = "image";
    public static final String FARM_TYPE_ANIMAL = "0";
    public static final String FARM_TYPE_VEGETABLE = "1";

    // URI directory list
    public static final String PROVIDER_NAME = "dev.ryan.m_food";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);
    public static final Uri URI_USERS = Uri.parse(BASE_CONTENT_URI + "/users");
    public static final Uri URI_FARM = Uri.parse(BASE_CONTENT_URI + "/farm");
    public static final Uri URI_USERS_ID = Uri.parse(BASE_CONTENT_URI + "/users/*");
    public static final Uri URI_FARM_ID = Uri.parse(BASE_CONTENT_URI + "/farm/*");

    // Uri match & case
    public static final int USERS_CASE = 1;
    public static final int USERS_CASE_ID = 2;
    public static final int FARM_CASE = 3;
    public static final int FARM_CASE_ID = 4;
    public static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "users", USERS_CASE);
        uriMatcher.addURI(PROVIDER_NAME, "users/*", USERS_CASE_ID);
        uriMatcher.addURI(PROVIDER_NAME, "farm", FARM_CASE);
        uriMatcher.addURI(PROVIDER_NAME, "farm/*", FARM_CASE_ID);
    }

}
