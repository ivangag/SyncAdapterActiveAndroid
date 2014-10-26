package com.example.android.network.sync.basicsyncadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.greenrobot.event.EventBus;


public class MainActivity extends Activity {

    String TAG = "MainActivity" ;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView)findViewById(R.id.imageChartApi);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(DownloadEvent downloadEvent){
        String msgEvent = downloadEvent.toString();
        Toast.makeText(this,"EventBus downloadEvent: " + msgEvent + " at " + TAG,Toast.LENGTH_LONG).show();
    }

    public void onEventMainThread(DownloadEvent downloadEvent){
        String msgEvent = downloadEvent.toString();
        Toast.makeText(this,"EventBusMainThread downloadEvent: " + msgEvent + " at " + TAG,Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    String urlPicassoTest = "http://chart.apis.google.com/chart?cht=p3&chs=500x200&chd=e:TNTNTNGa&chts=000000,16&chtt=A+Better+Web&chl=Hello|Hi|anas|Explorer&chco=FF5533,237745,9011D3,335423&chdl=Apple|Mozilla|Google|Microsoft";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_test){
            try {
                Picasso.with(this).load(urlPicassoTest).into(mImageView);
            }catch (Exception e){
                Toast.makeText(this, "Picasso error:" + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_gotofeed) {
            Intent intent = new Intent(this,EntryListActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
