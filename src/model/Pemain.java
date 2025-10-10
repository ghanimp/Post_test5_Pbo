package model;

public class Pemain extends PemainBase implements Performa {
    private String posisi;
    private int nomorPunggung;
    private int usia;
    private String catatan; 

    public Pemain(String nama, String klub, String posisi, int nomorPunggung, int usia) {
        super(nama, klub);
        this.posisi = posisi;
        this.nomorPunggung = nomorPunggung;
        this.usia = usia;
        this.catatan = ""; 
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public int getNomorPunggung() {
        return nomorPunggung;
    }

    public void setNomorPunggung(int nomorPunggung) {
        this.nomorPunggung = nomorPunggung;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    @Override
    public void infoPosisi() {
        System.out.println(getNama() + " bermain sebagai " + posisi);
    }

    @Override
    public void tampilkanPerforma() {
        System.out.println(getNama() + " bermain di " + getKlub());
    }

    public void tampilkanPerforma(String tambahan) {
        System.out.println(getNama() + " bermain di " + getKlub() + ". Catatan: " + tambahan);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String info = "Nama: " + getNama() + " | Klub: " + getKlub() + " | Posisi: " + posisi
                + " | Nomor: " + nomorPunggung + " | Usia: " + usia;

        if (catatan != null && !catatan.isEmpty()) {
            info += " | Catatan: " + catatan;
        }
        
        return info;
    }
}