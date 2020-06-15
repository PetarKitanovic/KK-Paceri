package petarkitanovic.androidkurs.paceri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import petarkitanovic.androidkurs.paceri.model.DataIgraci;
import petarkitanovic.androidkurs.paceri.model.IgraciStatistika;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "igraci.db";

    private static final int DATABASE_VERSION = 1;

    private Dao<DataIgraci, Integer> kontaktDao = null;
    private Dao<IgraciStatistika, Integer> statistikaDao = null;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {

            TableUtils.createTable(connectionSource, DataIgraci.class);
            TableUtils.createTable(connectionSource, IgraciStatistika.class);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {


        try {
            TableUtils.dropTable(connectionSource, IgraciStatistika.class, true);
            TableUtils.dropTable(connectionSource, DataIgraci.class, true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<DataIgraci, Integer> getKontaktDao() throws SQLException {
        if (kontaktDao == null) {
            kontaktDao = getDao(DataIgraci.class);
        }

        return kontaktDao;
    }

    public Dao<IgraciStatistika, Integer> getStatistikaDao() throws SQLException {
        if (statistikaDao == null) {
            statistikaDao = getDao(IgraciStatistika.class);
        }

        return statistikaDao;
    }


    @Override
    public void close() {
        kontaktDao = null;
        statistikaDao = null;

        super.close();
    }
}
