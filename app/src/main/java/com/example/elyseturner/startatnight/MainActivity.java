package com.example.elyseturner.startatnight;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AlertDialog;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends Activity implements AppCompatCallback {

    @ViewById
    Button openingButton;

    @Override
    public void onSupportActionModeStarted(ActionMode mode) {
        //let's leave this empty, for now
    }

    @Override
    public void onSupportActionModeFinished(ActionMode mode) {
        // let's leave this empty, for now
    }

    private AppCompatDelegate delegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //let's create the delegate, passing the activity at both arguments (Activity, AppCompatCallback)
        delegate = AppCompatDelegate.create(this, this);

        //we need to call the onCreate() of the AppCompatDelegate
        delegate.onCreate(savedInstanceState);

        //we use the delegate to inflate the layout
        delegate.setContentView(R.layout.activity_main);

        //Finally, let's add the Toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.my_awesome_toolbar);

        delegate.setSupportActionBar(toolbar);

        delegate.getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setTitle("Stars at Night");


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

    @Click(R.id.openingButton)
    void myButtonWasClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);
        builder.setTitle("My new appcompat dialog droids");
        builder.setMessage("zombie apocalypse");
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Cancel", null);
        builder.show();

    }
}
