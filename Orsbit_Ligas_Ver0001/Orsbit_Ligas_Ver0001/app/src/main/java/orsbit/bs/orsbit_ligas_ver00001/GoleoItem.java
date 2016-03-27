package orsbit.bs.orsbit_ligas_ver00001;

import android.graphics.drawable.Drawable;

/**
 * Created by TI on 21/07/2015.
 */
public class GoleoItem {
    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String Jugador;        // the text for the ListView item title
    public final String Equipo;  // the text for the ListView item description
    public final String Goles;

    public GoleoItem(Drawable icon, String Jugador,String Equipo,String Goles) {
        this.icon = icon;
        this.Jugador = Jugador;
        this.Equipo = Equipo;
        this.Goles = Goles;
    }
}