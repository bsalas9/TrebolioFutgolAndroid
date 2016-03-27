package orsbit.bs.orsbit_ligas_ver00001;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class JorRes_Fragment extends ListFragment {
    private List<JornadasItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<JornadasItem>();
        Resources resources = getResources();

        mItems.add(new JornadasItem(resources.getDrawable(R.drawable.escudomadrid),resources.getDrawable(R.drawable.escudobarca), "Real Madrid", "Barcelona","4","4","1","4","4"));
        mItems.add(new JornadasItem(resources.getDrawable(R.drawable.escudobarca),resources.getDrawable(R.drawable.escudomadrid), "Barcelona", "Real Madrid","10","2","2","10","2"));
        mItems.add(new JornadasItem(resources.getDrawable(R.drawable.escudomadrid),resources.getDrawable(R.drawable.escudobarca), "Real Madrid", "Barcelona","5","5","3","5","5"));

        // initialize and set the list adapter
        setListAdapter(new JorResAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }
}

