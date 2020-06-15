package petarkitanovic.androidkurs.paceri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import petarkitanovic.androidkurs.paceri.model.DataIgraci;
import petarkitanovic.androidkurs.paceri.model.Igraci;
import petarkitanovic.androidkurs.paceri.model.IgraciStatistika;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    List<DataIgraci> dataIgraci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            dataIgraci = getDatabaseHelper().getKontaktDao().queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dataIgraci.isEmpty()) {
            add();
        }

    }

    public void btnRoster(View v) {
        Intent i = new Intent(this, RosterActivity.class);
        startActivity(i);
    }

    public void btnStats(View v) {
        Intent i = new Intent(this, StatsActivity.class);
        startActivity(i);
    }


    public void add() {

        ArrayList<DataIgraci> igracis = new ArrayList<>();

        igracis.add(new DataIgraci("Kitanović", "Petar", "0", "1.png", "8.20", "2.90", "0.90", "9.0", "188", "84", "27"));
        igracis.add(new DataIgraci("Bažančik", "Igor", "1", "2.png", "4.33", "1.67", "0.67", "3.33", "172", "85", "36"));
        igracis.add(new DataIgraci("Omaljev", "Dušan", "3", "3.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Mandraš", "Ivan", "5", "4.png", "7.22", "3.33", "2.11", "7.44", "187", "95", "31"));
        igracis.add(new DataIgraci("Pajić", "Dušan", "6", "5.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Jovančević", "Igor", "8", "6.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Vučetić", "Nemanja", "9", "7.png", "8.10", "6.80", "3.20", "12.90", "198", " 110", "33"));
        igracis.add(new DataIgraci("Baćović", "Jovan", "10", "8.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Stojšin", "Stevan", "11", "9.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Nenin", "Bojan", "12", "10.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Jošić", "Aleksandar", "13", "11.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Marčeta", "Predrag", "14", "12.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Stanko", "Igor", "15", "13.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Zjačić", "Branko", "16", "14.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));
        igracis.add(new DataIgraci("Zeković", "Miloš", "22", "15.png", "14.67", "3.58", "2.50", "11.17", "188", "80", "22"));
        igracis.add(new DataIgraci("Djurović", "Dimitrije", "27", "16.png", "8.10", "6.80", "3.20", "12.90", "198", "110", "33"));



        IgraciStatistika p1 = new IgraciStatistika("8.20",igracis.get(0));
        IgraciStatistika p2 = new IgraciStatistika("10.20",igracis.get(0));
        IgraciStatistika p3 = new IgraciStatistika("15.00",igracis.get(0));
        IgraciStatistika p4 = new IgraciStatistika("9.35",igracis.get(0));
        IgraciStatistika p5 = new IgraciStatistika("10.35",igracis.get(0));
        IgraciStatistika p6 = new IgraciStatistika("5.50",igracis.get(0));


        for (int i = 0; i < igracis.size(); i++) {
            try {
                getDatabaseHelper().getKontaktDao().create(igracis.get(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                getDatabaseHelper().getStatistikaDao().create(p1);
                getDatabaseHelper().getStatistikaDao().create(p2);
                getDatabaseHelper().getStatistikaDao().create(p3);
                getDatabaseHelper().getStatistikaDao().create(p4);
                getDatabaseHelper().getStatistikaDao().create(p5);
                getDatabaseHelper().getStatistikaDao().create(p6);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


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
