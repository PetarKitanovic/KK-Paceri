package petarkitanovic.androidkurs.paceri.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = IgraciStatistika.TABLE_NAME)
public class IgraciStatistika {

    public static final String TABLE_NAME = "statistika";

    public static final String FIELD_ID = "id";
    public static final String FIELD_STATISTIKA = "stat";
    public static final String FIELD_IGRAC = "igrac";

    @DatabaseField(columnName = FIELD_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = FIELD_STATISTIKA)
    private String mStat;


    @DatabaseField(columnName = FIELD_IGRAC,foreign = true,foreignAutoRefresh = true)
    private DataIgraci mIgrac;


    public IgraciStatistika() {
    }

    public IgraciStatistika(String mStat, DataIgraci mIgrac) {
        this.mStat = mStat;
        this.mIgrac = mIgrac;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmStat() {
        return mStat;
    }

    public void setmStat(String mStat) {
        this.mStat = mStat;
    }

    public DataIgraci getmIgrac() {
        return mIgrac;
    }

    public void setmIgrac(DataIgraci mIgrac) {
        this.mIgrac = mIgrac;
    }

    @Override
    public String toString() {
        return  mStat ;
    }
}
