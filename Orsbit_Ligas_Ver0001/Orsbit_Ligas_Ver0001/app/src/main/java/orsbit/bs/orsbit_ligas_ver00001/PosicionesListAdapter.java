package orsbit.bs.orsbit_ligas_ver00001;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by TI on 21/07/2015.
 */
public class PosicionesListAdapter extends ArrayAdapter<PosicionesItem> {
    public PosicionesListAdapter(Context context, List<PosicionesItem> items) {
        super(context, R.layout.posicioneslistview_item, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.posicioneslistview_item, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.eEscudo = (ImageView) convertView.findViewById(R.id.eEquipo);
            viewHolder.Lugar = (TextView) convertView.findViewById(R.id.Lugar);
            viewHolder.Equipo = (TextView) convertView.findViewById(R.id.Equipo);
            viewHolder.Puntos = (TextView) convertView.findViewById(R.id.Puntos);
            viewHolder.JJ = (TextView) convertView.findViewById(R.id.JJ);
            viewHolder.JG = (TextView) convertView.findViewById(R.id.JG);
            viewHolder.JE = (TextView) convertView.findViewById(R.id.JE);
            viewHolder.JP = (TextView) convertView.findViewById(R.id.JP);
            viewHolder.GF = (TextView) convertView.findViewById(R.id.GF);
            viewHolder.GC = (TextView) convertView.findViewById(R.id.GC);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        PosicionesItem item = getItem(position);

        viewHolder.eEscudo.setImageDrawable(item.eEscudo);
        viewHolder.Equipo.setText(item.Equipo);
        viewHolder.Lugar.setText(item.Lugar);
        viewHolder.Puntos.setText(item.Pts);
        viewHolder.JJ.setText(item.JJ);
        viewHolder.JG.setText(item.JG);
        viewHolder.JE.setText(item.JE);
        viewHolder.JP.setText(item.JP);
        viewHolder.GF.setText(item.GF);
        viewHolder.GC.setText(item.GC);

        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see //http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {

        ImageView eEscudo;
        TextView Lugar;
        TextView Equipo;
        TextView Puntos;
        TextView JJ;
        TextView JG;
        TextView JE;
        TextView JP;
        TextView GF;
        TextView GC;
    }
}