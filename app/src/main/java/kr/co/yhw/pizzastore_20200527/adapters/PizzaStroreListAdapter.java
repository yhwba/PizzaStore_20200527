package kr.co.yhw.pizzastore_20200527.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.co.yhw.pizzastore_20200527.R;
import kr.co.yhw.pizzastore_20200527.datas.PizzaStore;

public class PizzaStroreListAdapter extends ArrayAdapter<PizzaStore> {

    Context mContext;
    List<PizzaStore> mList;
    LayoutInflater inf;

    public PizzaStroreListAdapter(@NonNull Context context, int resource, @NonNull List<PizzaStore> objects) {
        super(context, resource, objects);
        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.pizza_store_list_item, null);
        }

        ImageView storeLogoImg = row.findViewById(R.id.storeLogoImg);
        TextView storeNameTxt = row.findViewById(R.id.storeNameTxt);

        PizzaStore data = mList.get(position);

        storeNameTxt.setText(data.getName());


        return row;
    }
}
