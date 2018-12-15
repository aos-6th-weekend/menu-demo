package com.example.rathana.menu_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnContextMenu;
    Button btnActionMode;
    ActionMode mActionMode;

    Button btnPopupMenu;


    ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.context_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case  R.id.download:
                    Toast.makeText(MainActivity.this, "Downloading ...", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.share:
                    return true;
                case R.id.getLink:
                    return  true;
                default: return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mActionMode=null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContextMenu=findViewById(R.id.btnContextMenu);
        btnActionMode=findViewById(R.id.btnActionMode);
        btnPopupMenu=findViewById(R.id.btnPopupMenu);

        registerForContextMenu(btnContextMenu);

        btnActionMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode!=null)
                    return false;

                mActionMode= startActionMode(actionModeCallback);
                v.setSelected(true);
                return true;
            }
        });

        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu=new PopupMenu(MainActivity.this,v);
                menu.inflate(R.menu.context_menu);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch ( item.getItemId()){
                            case R.id.download:
                                Toast.makeText(MainActivity.this, "downloading ...", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.share:
                                return true;
                            case R.id.getLink:
                                return  true;
                            default: return  false;
                        }
                    }
                });

                menu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);

        MenuItem menuItem=menu.findItem(R.id.search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.e("search", "onQueryTextChange: "+s);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:

                ///your code for searching
                Toast.makeText(this, "Search item menu is clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:

                return true;
            case R.id.share:

                return true;

            case R.id.copy:
                Toast.makeText(this, "copy item menu is clicked", Toast.LENGTH_SHORT).show();
                return true;

                default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.download:
                Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.share:
                return true;
            case R.id.getLink:
                return true;
            default: return false;
        }
    }
}
