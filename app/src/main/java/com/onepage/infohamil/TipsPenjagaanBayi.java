package com.onepage.infohamil;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// TODO: 4/5/2017 - update UI
// TODO: 4/5/2017 - implement custom ActionBar
public class TipsPenjagaanBayi extends AppCompatActivity implements AdapterView.OnItemClickListener {
    DrawerLayout dlMain;
    ListView lvSettingMenu, lvTip;

    private String[] settingMenu, tipMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_penjagaan_bayi);

        // call setup methods
        setup();
        setupViews();
        setupListener();
    }

    // setup methods
    private void setup() {
        tipMenu = getResources().getStringArray(R.array.menu_tip);
        settingMenu = getResources().getStringArray(R.array.menu_setting);
    }

    private void setupViews() {
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        lvSettingMenu = (ListView) findViewById(R.id.lvSettingMenu);
        lvTip = (ListView) findViewById(R.id.lvTip); // TODO: 4/5/2017 - update UI listview

        lvSettingMenu.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, settingMenu));
        lvTip.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, tipMenu));
    }

    private void setupListener() {
        lvSettingMenu.setOnItemClickListener(this);
        lvTip.setOnItemClickListener(this);
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
            case R.id.lvTip:
                // TODO: 4/5/2017 - implement link utk setiap tips
                break;
        }
    }
}
