package petarkitanovic.androidkurs.paceri.model;

public class Igraci {

    public static Igraci[] igrac = {
            new Igraci(0, "Kitanovic", "Petar", 0, "petar.png", "8.20", "2.90", "0.90", "9.0", 188, 84, 27),
            new Igraci(1, "Bazancik", "Igor", 1, "leonardo.png", "4.33", "1.67", "0.67", "3.33", 172, 85, 36),
            new Igraci(2, "Omaljev", "Dusan", 3, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(3, "Mandras", "Ivan", 5, "vucetic.png", "7.22", "3.33", "2.11", "7.44", 187, 95, 31),
            new Igraci(4, "Pajic", "Dusan", 6, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(5, "Jovancevic", "Igor", 8, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(6, "Vucetic", "Nemanja", 9, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(7, "Bacovic", "Jovan", 10, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(8, "Stojsin", "Stevan", 11, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(9, "Nenin", "Bojan", 12, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(10, "Josic", "Aleksandar", 13, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(11, "Marceta", "Predrag", 14, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(12, "Stanko", "Igor", 15, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(13, "Zjacic", "Branko", 16, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33),
            new Igraci(14, "Zekovic", "Milos", 22, "vucetic.png", "14.67", "3.58", "2.50", "11.17", 188, 80, 22),
            new Igraci(15, "Djurovic", "Dimitrije", 27, "vucetic.png", "8.10", "6.80", "3.20", "12.90", 198, 110, 33)

    };

    private int id;
    private String prezime;
    private String ime;
    private int broj;
    private String imageFileName;
    private String ppg;
    private String rpg;
    private String apg;
    private String eff;
    private int visina;
    private int tezina;
    private int god;

    public Igraci(int id, String prezime, String ime, int broj, String imageFileName,
                  String ppg, String rpg, String apg, String eff, int visina, int tezina, int god) {
        this.id = id;
        this.prezime = prezime;
        this.ime = ime;
        this.broj = broj;
        this.imageFileName = imageFileName;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
        this.eff = eff;
        this.visina = visina;
        this.tezina = tezina;
        this.god = god;
    }

    public static Igraci[] getIgrac() {
        return igrac;
    }

    public static void setIgrac(Igraci[] igrac) {
        Igraci.igrac = igrac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getPpg() {
        return ppg;
    }

    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    public String getRpg() {
        return rpg;
    }

    public void setRpg(String rpg) {
        this.rpg = rpg;
    }

    public String getApg() {
        return apg;
    }

    public void setApg(String apg) {
        this.apg = apg;
    }

    public String getEff() {
        return eff;
    }

    public void setEff(String eff) {
        this.eff = eff;
    }

    public int getVisina() {
        return visina;
    }

    public void setVisina(int visina) {
        this.visina = visina;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public int getGod() {
        return god;
    }

    public void setGod(int god) {
        this.god = god;
    }
}
