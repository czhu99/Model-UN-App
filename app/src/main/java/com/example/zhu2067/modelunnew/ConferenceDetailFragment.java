package com.example.zhu2067.modelunnew;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


public class ConferenceDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ConferenceDetailFragment() {
    }

    private Conference conf;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If intent arguments have a course object, get it
        if (getArguments().containsKey("conference")) {
            conf = getArguments().getParcelable("conference");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_conference_detail, container, false);

        // Display the selected Conference, or just a welcome message
        if (conf != null) {
            ((TextView) rootView.findViewById(R.id.conference_detail)).setText(conf.name + " Research");
        }
        else {
            ((TextView) rootView.findViewById(R.id.conference_detail)).setText("Welcome to First Master/Detail");
        }

        return rootView;
    }

    public View onCreateListView()
    {

        View confList = (ListView) findViewById(R.id.fileListView);
        return confList;
    }



}
