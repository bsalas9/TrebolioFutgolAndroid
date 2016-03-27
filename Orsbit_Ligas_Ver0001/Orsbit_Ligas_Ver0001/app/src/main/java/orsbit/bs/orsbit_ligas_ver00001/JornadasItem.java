package orsbit.bs.orsbit_ligas_ver00001;

import android.graphics.drawable.Drawable;

/**
 * Created by TI on 21/07/2015.
 */
public class JornadasItem {
    public final Drawable eLocal;       // the drawable for the ListView item ImageView
    public final Drawable eVisita;

    public final String local;        // the text for the ListView item title
    public final String visita;
    public final String lugar;  // the text for the ListView item description
    public final String fecha;

    public final String jornada;
    public final String gLocal;
    public final String gVisita;

    public JornadasItem(Drawable eLocal, Drawable eVisita, String local, String visita,
                        String lugar,String fecha,String jornada,String gLocal,String gVisita) {
        this.eLocal = eLocal;
        this.eVisita = eVisita;
        this.local = local;
        this.visita = visita;
        this.lugar = lugar;
        this.fecha = fecha;
        this.jornada = jornada;
        this.gLocal = gLocal;
        this.gVisita = gVisita;
    }
}