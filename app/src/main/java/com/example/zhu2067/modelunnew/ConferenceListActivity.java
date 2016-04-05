package com.example.zhu2067.modelunnew;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import java.util.ArrayList;

public class ConferenceListActivity extends Activity
        implements ConferenceListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    private static  String TAG = "ConferenceListActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get Conferences from a file named courses.txt
        DataModel dataModel = new DataModel(this, "conferences");
        ArrayList<Conference> conferences = dataModel.getCourses();

        FragmentManager fm = getFragmentManager();
        setContentView(R.layout.activity_conference_list);

        if (findViewById(R.id.conference_detail_container) != null) {
            mTwoPane = true;
            // Its a tablet, so create a new detail fragment if one does not already exist
            ConferenceDetailFragment df = (ConferenceDetailFragment) fm.findFragmentByTag("Detail");
            if (df == null) {
                // Initialize new detail fragment
                df = new ConferenceDetailFragment();
                Bundle args = new Bundle();
                args.putParcelable("conference", new Conference("Welcome to First Master/Detail"));
                df.setArguments(args);
                fm.beginTransaction().replace(R.id.conference_detail_container, df, "Detail").commit();
            }
        }

        // Initialize a new Conference list fragment, if one does not already exist
        ConferenceListFragment cf = (ConferenceListFragment) fm.findFragmentByTag("List");
        if ( cf == null) {
            cf = new ConferenceListFragment();
            Bundle arguments = new Bundle();
            arguments.putParcelableArrayList("conferences", dataModel.getCourses());
            cf.setArguments(arguments);
            fm.beginTransaction().replace(R.id.conference_list, cf, "List").commit();
        }
    }

    /**
     * Callback method from {@link ConferenceListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(Conference c) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            // Pass the selected Conference object to the DetailFragment
            arguments.putParcelable("conference", c);
            ConferenceDetailFragment fragment = new ConferenceDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.conference_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ConferenceDetailActivity.class);
            // Pass the selected Golfcourse object to the DetailActivity
            detailIntent.putExtra("conference", c);
            startActivity(detailIntent);
        }
    }
}
