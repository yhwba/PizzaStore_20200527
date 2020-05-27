package kr.co.yhw.pizzastore_20200527;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import kr.co.yhw.pizzastore_20200527.databinding.ActivityPizzaStoreMoreInfoBinding;

public class PizzaStoreMoreInfoActivity extends BaseActivity {

    ActivityPizzaStoreMoreInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pizza_store_more_info);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {



    }

    @Override
    public void setValues() {



    }
}
