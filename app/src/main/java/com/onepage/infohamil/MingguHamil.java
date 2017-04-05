package com.onepage.infohamil;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

// TODO: 4/5/2017 - update UI
// TODO: 4/5/2017 - implement custom ActionBar
public class MingguHamil extends AppCompatActivity implements AdapterView.OnItemClickListener {
    DrawerLayout dlMain;
    ListView lvSettingMenu, lvMingguHamil;
    TextView tvFooter;

    private String[] settingMenu, mingguHamil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minggu_hamil);

        // call setup methods
        setup();
        setupViews();
        setupListener();
    }

    // setup methods
    private void setup() {
        mingguHamil = getResources().getStringArray(R.array.menu_info_minggu_kehamil); // TODO: 4/5/2017 - update UI list view
        settingMenu = getResources().getStringArray(R.array.menu_setting);
    }

    private void setupViews() {
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        lvSettingMenu = (ListView) findViewById(R.id.lvSettingMenu);
        lvMingguHamil = (ListView) findViewById(R.id.lvMingguHamil);
        tvFooter = (TextView) findViewById(R.id.tvFooter);

        lvMingguHamil.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mingguHamil));
        lvSettingMenu.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, settingMenu));
    }

    private void setupListener() {
        lvMingguHamil.setOnItemClickListener(this);
        lvSettingMenu.setOnItemClickListener(this);
    }

    // listener
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()) {
            case R.id.lvSettingMenu:
                switch(position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case R.id.lvMingguHamil:
                Intent nextAct;

                nextAct = new Intent(this, InfoMingguHamil.class);

                nextAct.putExtra("mingguPos", position);
                startActivity(nextAct);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
