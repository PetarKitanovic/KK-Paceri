package petarkitanovic.androidkurs.paceri;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.io.InputStream;
import java.sql.SQLException;

import petarkitanovic.androidkurs.paceri.model.DataIgraci;
import petarkitanovic.androidkurs.paceri.model.Igraci;

public class SecondActivity extends AppCompatActivity {

    private int kontakt_id;
    private DataIgraci kontakt;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalji_layout);


        kontakt_id = getIntent().getIntExtra("kontakt_id", -1);
        if (kontakt_id < 0) {
            Toast.makeText(this, "Greska! " + kontakt_id + " ne pstoji", Toast.LENGTH_SHORT).show();
            finish();
        }

        try {
            kontakt = getDatabaseHelper().getKontaktDao().queryForId(kontakt_id);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        TextView imePrezime = findViewById(R.id.textImePrezime);
        imePrezime.setText("#" + kontakt.getmBroj() + " " + kontakt.getmIme() + " " + kontakt.getmPrezime());

        TextView tv4 = findViewById(R.id.textPpg);
        tv4.setText("PTS\n" + kontakt.getmPpg());

        TextView tv5 = findViewById(R.id.textRpg);
        tv5.setText("REB\n" + kontakt.getmRpg());

        TextView tv6 = findViewById(R.id.textApg);
        tv6.setText("AST\n" + kontakt.getmApg());

        TextView tv7 = findViewById(R.id.textEff);
        tv7.setText("EFF\n" + kontakt.getmEff());

        TextView tv8 = findViewById(R.id.textVisina);
        tv8.setText("HT\n" + kontakt.getmVisina() + "cm");

        TextView tv9 = findViewById(R.id.textTezina);
        tv9.setText("WT\n" + kontakt.getmTezina() + "kg");

        TextView tv10 = findViewById(R.id.textGod);
        tv10.setText("AGE\n" + kontakt.getmGod());


        ImageView iv = findViewById(R.id.slika);
        try {
            InputStream is = getAssets().open(kontakt.getmSlika());
            Drawable drawable = Drawable.createFromStream(is, "");
            iv.setImageDrawable(drawable);
        } catch (Exception e) {
            e.printStackTrace();
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
