package dev.ryan.m_food.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dev.ryan.m_food.R;

public class FarmListAdapter extends ArrayAdapter<FarmDataModel> {
    public FarmListAdapter(Context context, ArrayList<FarmDataModel> array) {
        super(context, 0, array);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.farm_stock_item, parent, false);
        }

        FarmDataModel currentData = getItem(position);

        final ImageView itemImage = listItemView.findViewById(R.id.item_iv);
        itemImage.setImageResource(currentData.getImage());

        final TextView stockTv = listItemView.findViewById(R.id.stock_tv);
        stockTv.setText(currentData.getStock());

        final Button decreaseButton = listItemView.findViewById(R.id.button_decrease);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int stock = Integer.parseInt(stockTv.getText().toString());
                stockTv.setText(stock-- + "");
            }
        });

        final Button increaseButton = listItemView.findViewById(R.id.button_increase);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int stock = Integer.parseInt(stockTv.getText().toString());
                stockTv.setText(stock++ + "");
            }
        });

        return listItemView;
    }
}
