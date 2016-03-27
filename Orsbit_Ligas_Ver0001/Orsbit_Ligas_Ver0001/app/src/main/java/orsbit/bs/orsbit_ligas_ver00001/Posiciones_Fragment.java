package orsbit.bs.orsbit_ligas_ver00001;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TI on 21/07/2015.
 */
public class Posiciones_Fragment extends ListFragment {
    private List<PosicionesItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<PosicionesItem>();
        Resources resources = getResources();

        mItems.add(new PosicionesItem(null,                                           "Equipo  ", "Lugar","Pts","JJ","JG","JE","JP","",""));
        mItems.add(new PosicionesItem(resources.getDrawable(R.drawable.escudobarca) , "Barcelona", "1     ","5   ","3  ","1  ","2  ","0  ","",""));
        mItems.add(new PosicionesItem(resources.getDrawable(R.drawable.escudomadrid), "Real Madrid", "2     ","2   ","3  ","0  ","2  ","1  ","",""));

        // initialize and set the list adapter
        setListAdapter(new PosicionesListAdapter(getActivity(), mItems));
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
        PosicionesItem item = mItems.get(position);

        /*
        // do something
        //Paso 1: Obtener la instancia del administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager();


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        DetalleNoticia fragment = new DetalleNoticia();
        Bundle parametro = new Bundle();
        parametro.putString("title",item.title);
        parametro.putString("description",item.description);

        fragment.setArguments(parametro);

        transaction.replace(R.id.container, fragment);

        transaction.addToBackStack(null);
        transaction.commit();*/



        Toast.makeText(getActivity(), item.Equipo, Toast.LENGTH_SHORT).show();


    }

}

