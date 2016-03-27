package orsbit.bs.orsbit_ligas_ver00001;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//import com.actionbarsherlock.app.SherlockFragmentActivity;

public class DetalleNoticia extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String titulo  = getArguments().getString("title");
        String descripcion  = getArguments().getString("description");



        // Get the view from fragmenttab1.xml
        View view = inflater.inflate(R.layout.detallenoticia, container, false);

        TextView tituloNoticia = (TextView)view.findViewById(R.id.tituloNoticia);
        tituloNoticia.setText(titulo);
        TextView descNoticia = (TextView)view.findViewById(R.id.descripcionNoticia);
        descNoticia.setText(descripcion);




        return view;
    }


}