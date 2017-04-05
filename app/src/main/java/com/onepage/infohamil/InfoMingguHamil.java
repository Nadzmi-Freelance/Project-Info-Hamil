package com.onepage.infohamil;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.IntegerRes;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import static com.onepage.infohamil.R.id.info;
import static com.onepage.infohamil.R.id.lvMainMenu;
import static com.onepage.infohamil.R.id.lvSettingMenu;

// TODO: 4/5/2017 - update UI
// TODO: 4/5/2017 - implement custom ActionBar
public class InfoMingguHamil extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    DrawerLayout dlMain;
    ListView lvSettingMenu;
    LinearLayout llMingguSebelum, llMingguBerikut;
    TextView tvDescBayi, tvDescIbu;
    ImageView ivGambarInfo;

    private String[] settingMenu;
    private String descIbu, descBayi;
    private int descImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_minggu_hamil);

        // call setup methods
        setup();
        setupViews();
        setupListener();
    }

    // setup methods
    private void setup() {
        Bundle prevAct;
        int position;
        TypedArray imgList;

        prevAct = getIntent().getExtras();

        position = prevAct.getInt("mingguPos");
        imgList = getResources().obtainTypedArray(R.array.desc_img_minggu_hamil);
        descIbu = getResources().getStringArray(R.array.desc_ibu_minggu_hamil)[position];
        descBayi = getResources().getStringArray(R.array.desc_bayi_minggu_hamil)[position];
        descImg = imgList.getResourceId(position, -1);

        settingMenu = getResources().getStringArray(R.array.menu_setting);
    }

    private void setupViews() {
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        lvSettingMenu = (ListView) findViewById(R.id.lvSettingMenu);
        llMingguSebelum = (LinearLayout) findViewById(R.id.llMingguSebelum);
        llMingguBerikut = (LinearLayout) findViewById(R.id.llMingguBerikut);
        tvDescBayi = (TextView) findViewById(R.id.tvDescBayi);
        tvDescIbu = (TextView) findViewById(R.id.tvDescIbu);
        ivGambarInfo = (ImageView) findViewById(R.id.ivGambarInfo);

        lvSettingMenu.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, settingMenu));

        ivGambarInfo.setImageResource(descImg);
        tvDescIbu.setText(descIbu);
        tvDescBayi.setText(descBayi);
    }

    private void setupListener() {
        lvSettingMenu.setOnItemClickListener(this);

        llMingguSebelum.setOnClickListener(this);
        llMingguBerikut.setOnClickListener(this);
    }

    // Listeners
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()) {
            case R.id.lvSettingMenu:
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                dlMain.closeDrawers();
                break;
        }
    }

    // TODO: 4/5/2017 - implement '->' link & '<-' link
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.llMingguSebelum:
                break;
            case R.id.llMingguBerikut:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
