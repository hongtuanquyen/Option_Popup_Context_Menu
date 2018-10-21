package com.firstapp.quyen.option_popup_context_menu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPopup;
    Button btnContextMenu;
    RelativeLayout layoutMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPopup = findViewById(R.id.btn_Popup);
        btnContextMenu = findViewById(R.id.btn_ContextMenu);
        layoutMain = findViewById(R.id.layout_main);

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });

        btnContextMenu = findViewById(R.id.btn_ContextMenu);
        layoutMain = findViewById(R.id.layout_main);  // RelativeLayout
        registerForContextMenu(btnContextMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_Setting:
                Toast.makeText(MainActivity.this,"Setting was clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_Adjust:
                Toast.makeText(MainActivity.this,"Adjust was clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_Share:
                Toast.makeText(MainActivity.this,"Share was clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_Search:
                Toast.makeText(MainActivity.this,"Search was clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPopup(){
        PopupMenu popupMenu = new PopupMenu(this,btnPopup);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_Properties:
                        Toast.makeText(MainActivity.this,"Properties was clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_Delete:
                        Toast.makeText(MainActivity.this,"Delete was clicked",Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Choose color");
        menu.setHeaderIcon(R.drawable.multicolor);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_MauHong:
                layoutMain.setBackgroundColor(ContextCompat.getColor( MainActivity.this, R.color.colorAccent));
                break;
            case R.id.menu_MauXanhLa:
                layoutMain.setBackgroundColor(ContextCompat.getColor( MainActivity.this, R.color.colorGreen));
                break;
        }
        return super.onContextItemSelected(item);
    }
}

