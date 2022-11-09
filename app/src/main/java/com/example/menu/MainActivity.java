package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Link those objects with their respective id's
// that we have given in .XML file
        textView = (TextView) findViewById(R.id.textView);
        relativeLayout = (RelativeLayout) findViewById(R.id.relLayout);
// here you have to register a view for context menu
// you can register any view like listview, image view,
// textview, button etc
        registerForContextMenu(textView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
// you can set menu header with title icon etc
        menu.setHeaderTitle("Choose a color");
// add menu items
        menu.add(0, v.getId(), 0, "Pink");
        menu.add(0, v.getId(), 0, "Green");
        menu.add(0, v.getId(), 0, "Grey");
    }
    // menu item select listener
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Pink") {
            relativeLayout.setBackgroundColor(Color.MAGENTA);
        } else if (item.getTitle() == "Green") {
            relativeLayout.setBackgroundColor(Color.GREEN);
        } else if (item.getTitle() == "Grey") {
            relativeLayout.setBackgroundColor(Color.LTGRAY);
        }
        return true;
    }
}