package com.example.rathana.menu_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
