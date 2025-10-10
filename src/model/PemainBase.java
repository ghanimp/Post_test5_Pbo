package model;

public abstract class PemainBase {
    private String nama;
    private String klub;

    public PemainBase(String nama, String klub) {
        this.nama = nama;
        this.klub = klub;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKlub() {
        return klub;
    }

    public void setKlub(String klub) {
        this.klub = klub;
    }

    public abstract void infoPosisi();
}