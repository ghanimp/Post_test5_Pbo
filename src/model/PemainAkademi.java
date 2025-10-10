package model;

public class PemainAkademi extends Pemain {
    private String akademi;
    private int tahunMasuk;

    public PemainAkademi(String nama, String klub, String posisi, int nomorPunggung, int usia, String akademi, int tahunMasuk) {
        super(nama, klub, posisi, nomorPunggung, usia);
        this.akademi = akademi;
        this.tahunMasuk = tahunMasuk;
    }

    public String getAkademi() {
        return akademi;
    }

    public void setAkademi(String akademi) {
        this.akademi = akademi;
    }

    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    @Override
    public void tampilkanPerforma() {
        System.out.println(getNama() + " (Akademi) berasal dari akademi " + akademi + " tahun " + tahunMasuk);
    }

    @Override
    public String toString() {
        return super.toString() + " | Akademi: " + akademi + " | Tahun Masuk: " + tahunMasuk;
    }
}