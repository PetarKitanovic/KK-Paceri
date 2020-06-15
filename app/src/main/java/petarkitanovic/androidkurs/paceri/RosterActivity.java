package petarkitanovic.androidkurs.paceri;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import petarkitanovic.androidkurs.paceri.model.DataIgraci;
import petarkitanovic.androidkurs.paceri.model.Igraci;

public class RosterActivity extends AppCompatActivity implements AdapterKontakt.OnRecyclerItemClickListener {


    DatabaseHelper databaseHelper;


    RecyclerView recyclerView;

    AdapterKontakt adapterKontakt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);


        recyclerView = findViewById(R.id.lvLista);

        recyclerView.addItemDecoration(new DividerKlasa(recyclerView.getContext(), DividerKlasa.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            adapterKontakt = new AdapterKontakt(RosterActivity.this,getDatabaseHelper().getKontaktDao().queryForAll(), RosterActivity.this);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        recyclerView.setAdapter(adapterKontakt);

    }

    @Override
    public void onRVItemClick(DataIgraci kontakt) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("kontakt_id", kontakt.getmId());
        startActivity(intent);
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

