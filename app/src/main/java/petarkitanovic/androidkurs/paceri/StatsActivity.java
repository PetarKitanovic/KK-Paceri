package petarkitanovic.androidkurs.paceri;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.List;

import petarkitanovic.androidkurs.paceri.model.DataIgraci;
import petarkitanovic.androidkurs.paceri.model.IgraciStatistika;

public class StatsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    DataIgraci dataIgraci;
    GlavniAdapter glavniAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        recyclerView = findViewById(R.id.rv_stats);

        recyclerView.addItemDecoration(new DividerKlasa(recyclerView.getContext(), DividerKlasa.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<DataIgraci> listaIgraca = null;

        try {
            listaIgraca = getDatabaseHelper().getKontaktDao().queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        glavniAdapter = new GlavniAdapter(StatsActivity.this, listaIgraca);


        recyclerView.setAdapter(glavniAdapter);


    }

    public DatabaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

}
