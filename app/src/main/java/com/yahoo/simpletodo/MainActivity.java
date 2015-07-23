package com.yahoo.simpletodo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    EditFragment editFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up data manager
        new DataManager(this);
        lvItems = (ListView) findViewById(R.id.lvItems);

        // readItems();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DataManager.dataManager.items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    public void onAddItem(View v) {
        Util.hideKeyBoard(this);
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        // itemsAdapter.add(itemText);
        DataManager.dataManager.items.add(itemText);
        itemsAdapter.notifyDataSetChanged();
        etNewItem.setText("");
        // writeItems();
        DataManager.dataManager.daoWriteItems();
    }

    private void showEditDialog(int pos) {
        editFragment = EditFragment.newInstance(pos, DataManager.dataManager.items.get(pos), this);
        editFragment.show(getFragmentManager(), "dialog");
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                    DataManager.dataManager.items.remove(pos);
                    itemsAdapter.notifyDataSetChanged();
                    // writeItems();
                    DataManager.dataManager.daoWriteItems();
                    return true;
                }
            }
        );
        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View item, int pos, long id) {
                        showEditDialog(pos);
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
