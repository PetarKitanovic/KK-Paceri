package petarkitanovic.androidkurs.paceri;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import petarkitanovic.androidkurs.paceri.model.DataIgraci;
import petarkitanovic.androidkurs.paceri.model.IgraciStatistika;

public class GlavniAdapter
        extends
        RecyclerView.Adapter<GlavniAdapter.MyViewHolder> {

    public List<DataIgraci> listKontakt;
    public List<IgraciStatistika> igraciStatistikas;
    DatabaseHelper databaseHelper;
    Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView tvIme;
        RecyclerView recyclerView;
        View view;
        ImageView slika;
        UnutrasnjiAdapter unutrasnjiAdapter;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvIme = itemView.findViewById(R.id.stats_text_view);
            recyclerView = itemView.findViewById(R.id.rv_child);
            slika = itemView.findViewById(R.id.rv_image_stats);


        }

        public void bind(Context context, final DataIgraci kontakt) {
            tvIme.setText(kontakt.getmIme() + "\n" + kontakt.getmPrezime());
            try {
                InputStream is = context.getAssets().open(kontakt.getmSlika());
                Drawable drawable = Drawable.createFromStream(is, "");
                slika.setImageDrawable(drawable);
            } catch (Exception e) {
                e.printStackTrace();
            }


            recyclerView.setItemViewCacheSize(20);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);


            recyclerView.setLayoutManager(layoutManager);


//            unutrasnjiAdapter = new UnutrasnjiAdapter(context, igraciStatistikas);
//
//
//            recyclerView.setAdapter(unutrasnjiAdapter);

        }
    }

    public GlavniAdapter(Context context, List<DataIgraci> listKontakt) {
        this.context = context;
        this.listKontakt = listKontakt;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.glavni_recycler_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(context, listKontakt.get(i));

        final DataIgraci glumac = listKontakt.get(i);

    }

    @Override
    public int getItemCount() {
        return listKontakt.size();
    }

    public DatabaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        }
        return databaseHelper;
    }


}
