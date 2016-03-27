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

import java.util.ArrayList;
import java.util.List;


public class Jornadas_Fragment extends ListFragment {
    private List<NewsItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<NewsItem>();
        Resources resources = getResources();

        mItems.add(new NewsItem(null, "Jornada 1", "Jugada"));
        mItems.add(new NewsItem(null, "Jornada 2", "Jugada"));
        mItems.add(new NewsItem(null, "Jornada 3", "Jugada"));

        // initialize and set the list adapter
        setListAdapter(new NewsListAdapter(getActivity(), mItems));
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
        NewsItem item = mItems.get(position);

        // do something
        //Paso 1: Obtener la instancia del administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager();


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        JorRes_Fragment fragment = new JorRes_Fragment();
        //Bundle parametro = new Bundle();
        //parametro.putString("title",item.title);
        //parametro.putString("description",item.description);
        //fragment.setArguments(parametro);

        transaction.replace(R.id.container, fragment);

        transaction.addToBackStack(null);
        transaction.commit();



        //Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();


    }

}

