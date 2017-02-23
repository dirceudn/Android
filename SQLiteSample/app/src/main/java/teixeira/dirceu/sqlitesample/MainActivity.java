package teixeira.dirceu.sqlitesample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact(111, "Alberto", "Bernard", "Alberto@gmail.com","228338102"));
        db.addContact(new Contact(122, "Simone", "Santos Silva", "Simone@gmail.com","152760963"));
        db.addContact(new Contact(123, "Maria", "Nunes", "Maria@gmail.com","831787752"));
        db.addContact(new Contact(124, "João", "Oliveira", "Joao@gmail.com","166909064"));
        db.addContact(new Contact(125, "Marina", "José", "Marina@gmail.com","812531884"));
        db.addContact(new Contact(12647, "Almir", "Roberto", "Almir@gmail.com","372909549"));


        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getContact_id()+" ,Name: " + cn.getFirst_name() + " ,Phone: " + cn.getPhone();
            // Writing Contacts to log
            Log.d("Name: ", log);

        }

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
