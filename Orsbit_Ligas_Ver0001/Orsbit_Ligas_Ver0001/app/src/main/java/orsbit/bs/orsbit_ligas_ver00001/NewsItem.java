package orsbit.bs.orsbit_ligas_ver00001;

import android.graphics.drawable.Drawable;

/**
 * Created by TI on 21/07/2015.
 */
public class NewsItem {
    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the ListView item title
    public final String description;  // the text for the ListView item description

    public NewsItem(Drawable icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }


}