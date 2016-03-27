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
public class JorResAdapter extends ArrayAdapter<JornadasItem> {

    public JorResAdapter(Context context, List<JornadasItem> items) {
        super(context, R.layout.jorres_item, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.jorres_item, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.eLocal = (ImageView) convertView.findViewById(R.id.eLocal);
            viewHolder.eVisita = (ImageView) convertView.findViewById(R.id.eVisita);
            viewHolder.Local = (TextView) convertView.findViewById(R.id.local);
            viewHolder.Visita = (TextView) convertView.findViewById(R.id.visita);
            viewHolder.gLocal = (TextView) convertView.findViewById(R.id.glocal);
            viewHolder.gVisita = (TextView) convertView.findViewById(R.id.gvisita);

            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        JornadasItem item = getItem(position);

        viewHolder.eLocal.setImageDrawable(item.eLocal);
        viewHolder.eVisita.setImageDrawable(item.eVisita);
        viewHolder.Local.setText(item.local);
        viewHolder.Visita.setText(item.visita);
        viewHolder.gLocal.setText(item.gLocal);
        viewHolder.gVisita.setText(item.gVisita);
        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see //http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {

        ImageView eLocal;
        ImageView eVisita;
        TextView Local;
        TextView Visita;
        TextView gLocal;
        TextView gVisita;
    }
}