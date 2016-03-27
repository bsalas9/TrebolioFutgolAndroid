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
public class GoleoAdapter extends ArrayAdapter<GoleoItem> {

    public GoleoAdapter(Context context, List<GoleoItem> items) {
        super(context, R.layout.goleo_item, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.goleo_item, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.goleoAvatar);
            viewHolder.jugador = (TextView) convertView.findViewById(R.id.goleoJugador);
            viewHolder.equipo = (TextView) convertView.findViewById(R.id.goleoEquipo);
            viewHolder.goles = (TextView) convertView.findViewById(R.id.goleoGoles);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        GoleoItem item = getItem(position);
        viewHolder.avatar.setImageDrawable(item.icon);
        viewHolder.jugador.setText(item.Jugador);
        viewHolder.equipo.setText(item.Equipo);
        viewHolder.goles.setText(item.Goles);
        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see //http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {
        ImageView avatar;
        TextView jugador;
        TextView equipo;
        TextView goles;
    }
}