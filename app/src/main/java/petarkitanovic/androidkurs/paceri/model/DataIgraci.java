package petarkitanovic.androidkurs.paceri.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = DataIgraci.TABLE_NAME)

public class DataIgraci {

    public static final String TABLE_NAME = "kontakti";

    public static final String FIELD_ID = "id";
    public static final String FIELD_IME = "ime";
    public static final String FIELD_PREZIME = "prezime";
    public static final String FIELD_BROJ = "broj";
    public static final String FIELD_SLIKA = "slika";
    public static final String FIELD_PPG = "ppg";
    public static final String FIELD_RPG = "rpg";
    public static final String FIELD_APG = "apg";
    public static final String FIELD_EFF = "eff";
    public static final String FIELD_VISINA = "visina";
    public static final String FIELD_TEZINA = "tezina";
    public static final String FIELD_GOD = "god";
    public static final String FIELD_STATISTIKA = "statistika";


    @DatabaseField(columnName = FIELD_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = FIELD_IME)
    private String mIme;

    @DatabaseField(columnName = FIELD_PREZIME)
    private String mPrezime;

    @DatabaseField(columnName = FIELD_BROJ)
    private String mBroj;

    @DatabaseField(columnName = FIELD_SLIKA)
    private String mSlika;

    @DatabaseField(columnName = FIELD_PPG)
    private String mPpg;

    @DatabaseField(columnName = FIELD_RPG)
    private String mRpg;

    @DatabaseField(columnName = FIELD_APG)
    private String mApg;

    @DatabaseField(columnName = FIELD_EFF)
    private String mEff;

    @DatabaseField(columnName = FIELD_VISINA)
    private String mVisina;

    @DatabaseField(columnName = FIELD_TEZINA)
    private String mTezina;

    @DatabaseField(columnName = FIELD_GOD)
    private String mGod;

    @ForeignCollectionField(columnName = FIELD_STATISTIKA, eager = true)
    private ForeignCollection<IgraciStatistika> mStatistika;

    public DataIgraci() {
    }

    public DataIgraci(String mPrezime,String mIme,  String mBroj, String mSlika, String mPpg, String mRpg, String mApg, String mEff, String mVisina, String mTezina, String mGod) {
        this.mIme = mIme;
        this.mPrezime = mPrezime;
        this.mBroj = mBroj;
        this.mSlika = mSlika;
        this.mPpg = mPpg;
        this.mRpg = mRpg;
        this.mApg = mApg;
        this.mEff = mEff;
        this.mVisina = mVisina;
        this.mTezina = mTezina;
        this.mGod = mGod;

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmIme() {
        return mIme;
    }

    public void setmIme(String mIme) {
        this.mIme = mIme;
    }

    public String getmPrezime() {
        return mPrezime;
    }

    public void setmPrezime(String mPrezime) {
        this.mPrezime = mPrezime;
    }

    public String getmBroj() {
        return mBroj;
    }

    public void setmBroj(String mBroj) {
        this.mBroj = mBroj;
    }

    public String getmSlika() {
        return mSlika;
    }

    public void setmSlika(String mSlika) {
        this.mSlika = mSlika;
    }

    public String getmPpg() {
        return mPpg;
    }

    public void setmPpg(String mPpg) {
        this.mPpg = mPpg;
    }

    public String getmRpg() {
        return mRpg;
    }

    public void setmRpg(String mRpg) {
        this.mRpg = mRpg;
    }

    public String getmApg() {
        return mApg;
    }

    public void setmApg(String mApg) {
        this.mApg = mApg;
    }

    public String getmEff() {
        return mEff;
    }

    public void setmEff(String mEff) {
        this.mEff = mEff;
    }

    public String getmVisina() {
        return mVisina;
    }

    public void setmVisina(String mVisina) {
        this.mVisina = mVisina;
    }

    public String getmTezina() {
        return mTezina;
    }

    public void setmTezina(String mTezina) {
        this.mTezina = mTezina;
    }

    public String getmGod() {
        return mGod;
    }

    public void setmGod(String mGod) {
        this.mGod = mGod;
    }

    public ForeignCollection<IgraciStatistika> getmStatistika() {
        return mStatistika;
    }

    public void setmStatistika(ForeignCollection<IgraciStatistika> mStatistika) {
        this.mStatistika = mStatistika;
    }

    @Override
    public String toString() {
        return mIme + " " + mPrezime;
    }
}
