package dev.ryan.m_food;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import dev.ryan.m_food.data.Contract;

public class LoginActivity extends AppCompatActivity {
    /**
     * This is LoginActivity
     * You need to Login to access the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClick(View view) {
        EditText userNameContainer = findViewById(R.id.username_edit);
        EditText passwordContainer = findViewById(R.id.password_edit);

        String username = userNameContainer.getText().toString();
        String password = passwordContainer.getText().toString();

        loginMatcher(username, password);
    }

    // Signup/Create account for the app
    public void signUpClick(View view) {
        EditText userNameContainer = findViewById(R.id.username_edit);
        EditText passwordContainer = findViewById(R.id.password_edit);

        String username = userNameContainer.getText().toString();
        String password = passwordContainer.getText().toString();

        ContentValues values = new ContentValues();
        values.put(Contract.COLUMN_USER_NAME, username);
        values.put(Contract.COLUMN_USER_PASSWORD, password);

        getContentResolver().insert(Contract.URI_USERS, values);
    }
    // Validate the username and password
    private void loginMatcher(String username, String password) {
        String[] projection = {Contract.COLUMN_USER_NAME,
                Contract.COLUMN_USER_PASSWORD};
        String selection = Contract.COLUMN_USER_NAME + "=?";
        String[] selectionArgs = {username};

        Cursor cursor = getContentResolver().query(Contract.URI_USERS_ID, projection, selection, selectionArgs, null);

        try {

            final int passwordColumnIndex = cursor.getColumnIndex(Contract.COLUMN_USER_PASSWORD);
            while (cursor.moveToNext()) {
                boolean success = password.equals(cursor.getString(passwordColumnIndex));
                if (success) {
                    Intent intent = new Intent(this, FarmStock.class);
                    startActivity(intent);
                } else {
                    TextView errorTv = findViewById(R.id.error_tv);
                    errorTv.setVisibility(View.VISIBLE);
                }
            }
        } finally {
            cursor.close();
        }
    }

}

