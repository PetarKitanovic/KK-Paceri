package petarkitanovic.androidkurs.paceri;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

import petarkitanovic.androidkurs.paceri.model.DataIgraci;
import petarkitanovic.androidkurs.paceri.model.Igraci;

public class AdapterKontakt extends
        RecyclerView.Adapter<AdapterKontakt.MyViewHolder> {

    public List<DataIgraci> listKontakt;
    public OnRecyclerItemClickListener listener;
    Context context;

    public interface OnRecyclerItemClickListener {
        void onRVItemClick(DataIgraci kontakt);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvIme;
        TextView tvPrezime;
        ImageView slika;
        View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvIme = itemView.findViewById( R.id.tv_recycler_ime);
            tvPrezime = itemView.findViewById( R.id.tv_recycler_prezime);
            slika = itemView.findViewById(R.id.rv_image_kontakta);


        }

        public void bind(Context context,final DataIgraci kontakt, final OnRecyclerItemClickListener listener) {
            tvIme.setText(kontakt.getmIme());
            tvPrezime.setText(kontakt.getmPrezime());


            try {
                InputStream is = context.getAssets().open(kontakt.getmSlika());
                Drawable drawable = Drawable.createFromStream(is, "");
                slika.setImageDrawable(drawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onRVItemClick(kontakt);
                }
            });
        }
    }

    public AdapterKontakt(Context context,List<DataIgraci> listKontakt, OnRecyclerItemClickListener listener) {
        this.context = context;
        this.listKontakt = listKontakt;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_single_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(context,listKontakt.get(i), listener);

        final DataIgraci glumac = listKontakt.get(i);

    }

    @Override
    public int getItemCount() {
        return listKontakt.size();
    }


    public void addGlumac(DataIgraci kontakt) {
        listKontakt.add(kontakt);
        notifyDataSetChanged();
    }
}
