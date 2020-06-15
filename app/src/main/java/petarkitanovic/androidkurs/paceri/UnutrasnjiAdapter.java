package petarkitanovic.androidkurs.paceri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import petarkitanovic.androidkurs.paceri.model.IgraciStatistika;

public class UnutrasnjiAdapter
        extends RecyclerView.Adapter<UnutrasnjiAdapter.MyViewHolder> {



    private List<IgraciStatistika> slike;
    Context context;


    public UnutrasnjiAdapter(Context context, List<IgraciStatistika> slike) {
        this.context = context;
        this.slike = slike;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unutrasnji_recycler_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


       holder.bind(slike.get(position));


    }

    @Override
    public int getItemCount() {
        return slike.size();
    }

    public IgraciStatistika get(int position) {
        return slike.get(position);
    }

    public void clear() {
        slike.clear();
    }

    public void addAll(List<IgraciStatistika> slikeList) {
        slike.addAll(slikeList);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.child_textView);


        }

        public void bind(final IgraciStatistika igraciStatistika) {

            this.textView.setText(igraciStatistika.getmStat());
        }
    }

}