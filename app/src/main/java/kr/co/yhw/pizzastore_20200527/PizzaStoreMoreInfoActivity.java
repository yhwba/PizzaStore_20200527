package kr.co.yhw.pizzastore_20200527;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

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

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PermissionListener pl = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {

                        String phoneNum = binding.phoneNumTxt.getText().toString();
                        Uri muUri = Uri.parse(String.format("tel:%s", phoneNum));
                        Intent myIntent = new Intent(Intent.ACTION_CALL, muUri);
                        startActivity(myIntent);

                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(mContext, "권한이 거부되어 통화가 불가능합니다.", Toast.LENGTH_SHORT).show();
                    }
                };
                TedPermission
                        .with(mContext)
                        .setPermissionListener(pl)
                        .setDeniedMessage("거부하면 통화가 불가능합니다. \n 통화하고 싶으시면 설정을 변경을 하세요")
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .check();
            }
        });


    }

    @Override
    public void setValues() {

        mStore = (PizzaStore) getIntent().getSerializableExtra("store");
        binding.nameTxt.setText(mStore.getName());
        binding.phoneNumTxt.setText(mStore.getPhoneNum());

        Glide.with(mContext).load(mStore.getLogoImgUrl()).into(binding.logoImg);

    }
}
