package orsbit.bs.orsbit_ligas_ver00001;

import android.graphics.drawable.Drawable;

/**
 * Created by TI on 21/07/2015.
 */
public class PosicionesItem {
    public final Drawable eEscudo;       // the drawable for the ListView item ImageView
    public final String Equipo;        // the text for the ListView item title
    public final String Lugar;  // the text for the ListView item description
    public final String Pts;
    public final String JJ;
    public final String JG;
    public final String JE;
    public final String JP;
    public final String GF;
    public final String GC;

    public PosicionesItem(Drawable eEscudo, String Equipo, String Lugar,String Pts,
                          String JJ, String JG, String JE, String JP, String GF, String GC) {
        this.eEscudo = eEscudo;
        this.Equipo = Equipo;
        this.Lugar = Lugar;
        this.Pts = Pts;
        this.JJ = JJ;
        this.JG = JG;
        this.JE = JE;
        this.JP = JP;
        this.GF = GF;
        this.GC = GC;
    }
}