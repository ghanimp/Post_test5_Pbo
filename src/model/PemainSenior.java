package model;

public class PemainSenior extends Pemain {
    private String penghargaan;

    public PemainSenior(String nama, String klub, String posisi, int nomorPunggung, int usia, String penghargaan) {
        super(nama, klub, posisi, nomorPunggung, usia);
        this.penghargaan = penghargaan;
    }

    public String getPenghargaan() {
        return penghargaan;
    }

    public void setPenghargaan(String penghargaan) {
        this.penghargaan = penghargaan;
    }

    @Override
    public void tampilkanPerforma() {
        System.out.println(getNama() + " (Senior) punya penghargaan: " + penghargaan);
    }

    @Override
    public void tampilkanInfo() {
    System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Penghargaan: " + penghargaan;
    }
}