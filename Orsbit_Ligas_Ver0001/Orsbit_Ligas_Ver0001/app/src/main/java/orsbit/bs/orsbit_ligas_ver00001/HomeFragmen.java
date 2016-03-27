package orsbit.bs.orsbit_ligas_ver00001;

/**
 * Created by TI on 21/07/2015.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.support.v4.app.ListFragment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.ListAdapter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;




public class HomeFragmen extends ListFragment {
    //private List<NewsItem> mItems;        // ListView items list

    // URL to get contacts JSON
    private static String url = "http://futgol.x10host.com/Futgol/Endpoints/Get_All_News.php";

    // JSON Node names
    private static final String TAG_NEWS = "news";

    private static final String TAG_ID = "id";
    private static final String TAG_TITLE = "title";
    private static final String TAG_CONTENT = "content";
    private static final String TAG_DATE = "publish_Date";
    private static final Image  TAG_IMAGE = null;

    // contacts JSONArray
    JSONArray news = null;

    private ProgressDialog pDialog;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> newsList;
    private List<NewsItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialize the items list
        mItems = new ArrayList<NewsItem>();

        // Calling async task to get json
        //new GetContacts().execute();

        TareaWSListar tarea = new TareaWSListar();
        tarea.execute();
    }


    //Tarea As�ncrona para llamar al WS de listado en segundo plano
    private class TareaWSListar extends AsyncTask<String,Integer,Boolean> {

        private String[] clientes;

        protected Boolean doInBackground(String... params) {

            boolean resul = true;

            HttpClient httpClient = new DefaultHttpClient();

            HttpGet del =
                    new HttpGet("http://futgol.x10host.com/Futgol/Endpoints/Get_All_News.php");

            del.setHeader("content-type", "application/json");

            try
            {
                HttpResponse resp = httpClient.execute(del);
                String respStr = EntityUtils.toString(resp.getEntity());

                JSONArray respJSON = new JSONArray(respStr);

                clientes = new String[respJSON.length()];

                for(int i=0; i<respJSON.length(); i++)
                {
                    JSONObject obj = respJSON.getJSONObject(i);

                    //int idCli = obj.getInt("id");
                    String nombCli = obj.getString("title");
                    String telefCli = obj.getString("content");

                    //clientes[i] = "" + idCli + "-" + nombCli + "-" + telefCli;
                    mItems.add(new NewsItem(null, nombCli, telefCli));
                }
            }
            catch(Exception ex)
            {
                Log.e("ServicioRest","Error!", ex);
                resul = false;
            }

            return resul;
        }

        protected void onPostExecute(Boolean result) {

            if (result)
            {
                //Rellenamos la lista con los nombres de los clientes
                //Rellenamos la lista con los resultados

                setListAdapter(new NewsListAdapter(getActivity(), mItems));
            }
        }
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
        DetalleNoticia fragment = new DetalleNoticia();
        Bundle parametro = new Bundle();
        parametro.putString("title",item.title);
        parametro.putString("description",item.description);

        fragment.setArguments(parametro);

        transaction.replace(R.id.container, fragment);

        transaction.addToBackStack(null);
        transaction.commit();
    }

}
