package dev.ryan.m_food;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import dev.ryan.m_food.data.Contract;
import dev.ryan.m_food.data.DbHelper;
import dev.ryan.m_food.listview.FarmDataModel;
import dev.ryan.m_food.listview.FarmListAdapter;

public class FarmStock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farm_stock);
        getData();
    }

    // Get all of the data from FARM_TABLE
    // Display it as ListView
    public void getData() {
        String[] projection = {Contract.COLUMN_FARM_TYPE,
                               Contract.COLUMN_FARM_NAME,
                               Contract.COLUMN_FARM_STOCK};
        String selection = Contract.COLUMN_FARM_TYPE + "=?";
        String[] whereArgs = {Contract.FARM_TYPE_ANIMAL};

        Cursor cursor = getContentResolver().query(Contract.URI_FARM, projection, selection, whereArgs, null);
        ArrayList<FarmDataModel> array = new ArrayList<FarmDataModel>();
        try {

            int idColumnIndex = cursor.getColumnIndex(Contract.COLUMN_FARM_ID);
            int nameColumnIndex = cursor.getColumnIndex(Contract.COLUMN_FARM_NAME);
            int stockColumnIndex = cursor.getColumnIndex(Contract.COLUMN_FARM_STOCK);
            int imageColumnIndex = cursor.getColumnIndex(Contract.COLUMN_FARM_IMAGE);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                int stock = cursor.getInt(stockColumnIndex);
                int image = cursor.getInt(imageColumnIndex);
                String name = cursor.getString(nameColumnIndex);
                FarmDataModel data = new FarmDataModel(id,image,name,stock);
                array.add(data);
            }

        } finally {
            viewData(array);
        }
    }

    public void viewData(ArrayList<FarmDataModel> array) {
        ListView lv = findViewById(R.id.farm_lv);
        FarmListAdapter adapter = new FarmListAdapter(this, array);
        lv.setAdapter(adapter);
    }

    public void addDummy(View view) {
        ContentValues value = new ContentValues();
        value.put(Contract.COLUMN_FARM_NAME, "Cow");
        value.put(Contract.COLUMN_FARM_TYPE, Contract.FARM_TYPE_ANIMAL);
        value.put(Contract.COLUMN_FARM_STOCK, "40");
        value.put(Contract.COLUMN_FARM_IMAGE, R.drawable.ic_launcher_foreground);
        getContentResolver().insert(Contract.URI_FARM, value);
    }
}

