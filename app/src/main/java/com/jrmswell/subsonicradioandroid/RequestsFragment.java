package com.jrmswell.subsonicradioandroid;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RequestsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RequestsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class RequestsFragment extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_requests);
        Button play = (Button) findViewById(R.id.button_play);
        Button pause = (Button) findViewById(R.id.button_pause);

        MediaPlayer mp = MediaPlayer.create(RequestsFragment.this,R."http://horizons.subsonicradio.com:8000/requests.mp3");
    }
}
