package com.onepage.infohamil;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

// TODO: 4/5/2017 - update UI
// TODO: 4/5/2017 - implement custom ActionBar
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    DrawerLayout dlMain;
    ListView lvSettingMenu, lvMainMenu;

    private String[] settingMenu, mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call setup methods
        setup();
        setupViews();
        setupListener();
    }

    // setup methods
    private void setup() {
        mainMenu = getResources().getStringArray(R.array.menu_utama);
        settingMenu = getResources().getStringArray(R.array.menu_setting);
    }

    private void setupViews() {
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        lvMainMenu = (ListView) findViewById(R.id.lvMainMenu);
        lvSettingMenu = (ListView) findViewById(R.id.lvSettingMenu);

        lvMainMenu.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mainMenu));
        lvSettingMenu.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, settingMenu));
    }

    private void setupListener() {
        lvMainMenu.setOnItemClickListener(this);
        lvSettingMenu.setOnItemClickListener(this);
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
            case R.id.lvMainMenu:
                switch (position) {
                    case 0:
                        startActivity(new Intent(this, TandaHamil.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(this, MingguHamil.class));
                        break;
                    case 3:
                        startActivity(new Intent(this, TipsPenjagaanIbu.class));
                        break;
                    case 4:
                        startActivity(new Intent(this, TipsPenjagaanBayi.class));
                        break;
                }
                break;
        }
    }
}
