package com.jrmswell.subsonicradioandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_about:
                    mTextMessage.setText(R.string.title_about);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView stationsListView = (ListView) findViewById(R.id.stationsListView);

        HashMap<String, String> radioDesc = new HashMap<>();
        radioDesc.put("Requests", "A selection of music, chosen by our listeners");
        radioDesc.put("Background", "All instrumentals, all the time. Listen to a mix of background/area music from the parks");
        radioDesc.put("Staff Picks", "A selection of tracks picked by our Staff");
        radioDesc.put("Great Music Ride", "Only Audio of Rides");
        radioDesc.put("Main Street", "Walk in Uncle Walt's footsteps down Main Street, USA!");
        radioDesc.put("Wilderness Jct", "Hang out with the bears, camp out near your lodge, or just take the train around to see the sights");
        radioDesc.put("Future Land", "Welcome to the future -- Future World and Tomorrowland");
        radioDesc.put("Star Tunnel", "For you Star Tunnel junkies!");
        radioDesc.put("Soarin'", "For you Soarin' freaks.. Soarin' tracks played over and over and over again");
        radioDesc.put("Living Seas", "The Living Seas all the time");
        radioDesc.put("Dole-Whip", "Adventureland, Tiki, Polynesian, Hawaiian");
        radioDesc.put("Tangaroa", "Have a seat on the Tangaroa Terrace sip your colada or whip, and enjoy the music");
        radioDesc.put("WEDWay", "Take a ride on the classic WEDWay PeopleMover!");

        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});

        Iterator it = radioDesc.entrySet().iterator();
        while (it.hasNext()) {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry) it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }
        stationsListView.setAdapter(adapter);

        //mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
