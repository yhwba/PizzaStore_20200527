package kr.co.yhw.pizzastore_20200527.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.co.yhw.pizzastore_20200527.datas.PizzaStore;

public class PizzaStroreListAdapter extends ArrayAdapter<PizzaStore> {

    Context mContext;
    List<PizzaStore> mList;
    LayoutInflater inf;

    public PizzaStroreListAdapter (@NonNull Context context, int resource, @NonNull List<PizzaStore> objects) {
        super(context, resource, objects);
        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.room_list_item, null);
        }
        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressAndFloorTxt = row.findViewById(R.id.addressAndFloorTxt);
        TextView descTxt = row.findViewById(R.id.descTxt);

        PizzaStore data = mList.get(position);


        storeNameTxt.setText(data.getFormattedPrice());
        addressAndFloorTxt.setText(String.format("%s,%s",data.getAddress(),data.getFormattedFloor()));
        descTxt.setText(data.getDescription());

        return row;
    }


}
