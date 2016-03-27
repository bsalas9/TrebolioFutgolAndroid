package orsbit.bs.orsbit_ligas_ver00001;

/**
 * Created by TI on 21/07/2015.
 */

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Goleo_Fragmen extends ListFragment {
    private List<GoleoItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<GoleoItem>();
        Resources resources = getResources();

        mItems.add(new GoleoItem(resources.getDrawable(R.drawable.avatar), "Brian","Barcelona","18"));
        mItems.add(new GoleoItem(resources.getDrawable(R.drawable.avatar), "Diego","Real Madrid","8"));
        mItems.add(new GoleoItem(resources.getDrawable(R.drawable.avatar), "Chuy Najar","Real Madrid","3"));

        // initialize and set the list adapter
        setListAdapter(new GoleoAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        GoleoItem item = mItems.get(position);

        // do something
        //Paso 1: Obtener la instancia del administrador de fragmentos



        Toast.makeText(getActivity(), item.Jugador, Toast.LENGTH_SHORT).show();


    }

}
