package kr.co.yhw.pizzastore_20200527;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;

import kr.co.yhw.pizzastore_20200527.databinding.ActivityPizzaStoreMoreInfoBinding;
import kr.co.yhw.pizzastore_20200527.datas.PizzaStore;

public class PizzaStoreMoreInfoActivity extends BaseActivity {

    ActivityPizzaStoreMoreInfoBinding binding;

    PizzaStore mStore;

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

        mStore = (PizzaStore) getIntent().getSerializableExtra("store");
        binding.nameTxt.setText(mStore.getName());
        binding.phoneNumTxt.setText(mStore.getPhoneNum());

        Glide.with(mContext).load(mStore.getLogoImgUrl()).into(binding.logoImg);

    }
}
