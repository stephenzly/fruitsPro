package zly.com.fruitsFight;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class blFragment extends Fragment {


    public blFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab03, container, false);
    }

}
