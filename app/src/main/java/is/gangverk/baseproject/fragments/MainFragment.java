package is.gangverk.baseproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import is.gangverk.baseproject.R;
import is.gangverk.baseproject.application.GangverkApplication;

/**
 * Created by Arnaldur on 22/09/14.
 */
public class MainFragment extends Fragment {
    private final static String BUNDLE_SOME_VAR = GangverkApplication.createIdentifier("MainFragment.someVar");

    /**
     * MARK: Instance Handling
     */
    public static MainFragment newInstance(int someVariable) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_SOME_VAR,someVariable);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {}

    /**
     * MARK: Lifecycle Methods
     */

    //Set variables and init, no views ready here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments().putInt(BUNDLE_SOME_VAR,savedInstanceState.getInt(BUNDLE_SOME_VAR));
    }

    //Reference all views owned by this fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    //The activity is ready here
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //Init the UI here
    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * MARK: Overrides
     */

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //If the state is complex then create a inner parcelable holder class representing the state
        outState.putInt(BUNDLE_SOME_VAR,getSomeVar());
    }

    /**
     * MARK: Private Methods
     */
    private int getSomeVar() {
        return getArguments().getInt(BUNDLE_SOME_VAR);
    }
}