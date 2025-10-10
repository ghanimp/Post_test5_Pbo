package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pemain;
import model.PemainSenior;
import model.PemainAkademi;
import database.ServiceDatabase;

public class PemainService {
    private ArrayList<Pemain> pemainList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private ServiceDatabase dao = new ServiceDatabase();

    // Load data dari database saat program dimulai
    public void loadDataFromDatabase() {
        pemainList.clear();
        pemainList.addAll(dao.getAllPemainSenior());
        pemainList.addAll(dao.getAllPemainAkademi());
        System.out.println("Data berhasil dimuat dari database!\n");
    }

    public void tambahPemain() {
        System.out.println("\n=== Tambah Pemain ===");

        String jenis;
        while (true) {
            System.out.print("Jenis Pemain (1 = Senior, 2 = Akademi): ");
            jenis = input.nextLine();
            if (jenis.equals("1") || jenis.equals("2")) {
                break;
            } else {
                System.out.println("Input salah! Masukkan 1 untuk Senior atau 2 untuk Akademi.\n");
            }
        }

        System.out.print("Masukkan Nama Pemain: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Nama Klub: ");
        String klub = input.nextLine();

        System.out.print("Masukkan Posisi Pemain: ");
        String posisi = input.nextLine();

        int nomorPunggung;
        while (true) {
            System.out.print("Masukkan Nomor Punggung: ");
            try {
                nomorPunggung = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nomor punggung harus angka!");
            }
        }

        int usia;
        while (true) {
            System.out.print("Masukkan Usia Pemain: ");
            try {
                usia = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Usia harus angka!");
            }
        }

        Pemain pemainBaru = null;
        
        if (jenis.equals("1")) {
            // Pemain Senior
            System.out.print("Masukkan Penghargaan Individu Pemain Senior: ");
            String penghargaan = input.nextLine();
            pemainBaru = new PemainSenior(nama, klub, posisi, nomorPunggung, usia, penghargaan);
        } else if (jenis.equals("2")) {
            // Pemain Akademi
            System.out.print("Masukkan Nama Akademi: ");
            String akademi = input.nextLine();

            int tahunMasuk;
            while (true) {
                System.out.print("Masukkan Tahun Masuk Akademi: ");
                try {
                    tahunMasuk = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Tahun masuk harus angka!");
                }
            }
            pemainBaru = new PemainAkademi(nama, klub, posisi, nomorPunggung, usia, akademi, tahunMasuk);
        }

        // Tampilkan performa dengan catatan tambahan
        System.out.print("Tambahkan catatan performa? (y/n): ");
        String pilihan = input.nextLine().trim().toLowerCase();
        
        if (pilihan.equals("y")) {
            System.out.print("Masukkan catatan: ");
            String catatan = input.nextLine();
            pemainBaru.setCatatan(catatan);
            pemainBaru.tampilkanPerforma(catatan);
        } else {
            pemainBaru.setCatatan(""); // Set kosong jika tidak ada catatan
            pemainBaru.tampilkanPerforma();
        }

        pemainList.add(pemainBaru);

        if (pemainBaru instanceof PemainSenior) {
            dao.tambahPemainSenior((PemainSenior) pemainBaru);
        } else if (pemainBaru instanceof PemainAkademi) {
            dao.tambahPemainAkademi((PemainAkademi) pemainBaru);
        }
        
        System.out.println("Pemain berhasil ditambahkan!\n");
    }

    public void tampilkanPemain() {
        if (pemainList.isEmpty()) {
            System.out.println("Belum ada data pemain.\n");
            return;
        }

        System.out.println("\n=== Pilih Jenis Pemain yang Ditampilkan ===");
        System.out.println("1. Semua Pemain");
        System.out.println("2. Pemain Senior Saja");
        System.out.println("3. Pemain Akademi Saja");
        System.out.print("Pilih: ");
        String pilihan = input.nextLine();

        System.out.println("\n=== DAFTAR PEMAIN ===");
        int i = 1;
        for (Pemain p : pemainList) {

            boolean tampil = false;
            if (pilihan.equals("1")) {
                tampil = true;
            } else if (pilihan.equals("2") && p instanceof PemainSenior) {
                tampil = true;
            } else if (pilihan.equals("3") && p instanceof PemainAkademi) {
                tampil = true;
            }

            if (tampil) {
                System.out.print(i + ". ");
                p.tampilkanInfo();
                i++;
            }
        }

        if (i == 1) {
            System.out.println("Tidak ada pemain sesuai kategori ini.");
        } else {
            // Menampilkan catatan yang sudah disimpan
            System.out.print("\nLihat performa pemain dengan catatan? (y/n): ");
            String opsi = input.nextLine().trim().toLowerCase();
            
            if (opsi.equals("y")) {
                System.out.print("Masukkan nomor pemain: ");
                try {
                    int nomor = Integer.parseInt(input.nextLine());
                    if (nomor >= 1 && nomor < i) {
                        // Cari pemain sesuai nomor yang ditampilkan
                        int counter = 1;
                        for (Pemain p : pemainList) {
                            boolean cocok = false;
                            if (pilihan.equals("1")) {
                                cocok = true;
                            } else if (pilihan.equals("2") && p instanceof PemainSenior) {
                                cocok = true;
                            } else if (pilihan.equals("3") && p instanceof PemainAkademi) {
                                cocok = true;
                            }
                            
                            if (cocok) {
                                if (counter == nomor) {
                                    System.out.println("\n--- Performa Pemain ---");
                                    // Cek apakah ada catatan tersimpan
                                    if (p.getCatatan() != null && !p.getCatatan().isEmpty()) {
                                        p.tampilkanPerforma(p.getCatatan()); // Pakai catatan yang tersimpan
                                    } else {
                                        p.tampilkanPerforma(); // Tanpa catatan
                                        System.out.println("(Belum ada catatan untuk pemain ini)");
                                    }
                                    break;
                                }
                                counter++;
                            }
                        }
                    } else {
                        System.out.println("Nomor tidak valid!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka!");
                }
            }
        }
        System.out.println();
    }

    public void updatePemain() {
        if (pemainList.isEmpty()) {
            System.out.println("Belum ada data pemain.\n");
            return;
        }

        String pilihan;
        while (true) {
            System.out.println("\n=== Pilih Jenis Pemain yang Akan Diupdate ===");
            System.out.println("1. Pemain Senior");
            System.out.println("2. Pemain Akademi");
            System.out.print("Pilih (1/2): ");
            pilihan = input.nextLine().trim();
            if (pilihan.equals("1") || pilihan.equals("2")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid! Masukkan 1 atau 2.\n");
            }
        }

        System.out.print("Masukkan nama pemain yang akan diupdate: ");
        String namaCari = input.nextLine().toLowerCase();

        Pemain p = null;
        for (Pemain pemain : pemainList) {
            boolean cocok = pemain.getNama().toLowerCase().equals(namaCari);

            if (pilihan.equals("1") && pemain instanceof PemainSenior && cocok) {
                p = pemain; 
                break;
            } 
            else if (pilihan.equals("2") && pemain instanceof PemainAkademi && cocok) {
                p = pemain; 
                break;
            }
        }

        if (p != null) {
            String namaLama = p.getNama();
            
            System.out.print("Nama Baru (" + p.getNama() + "): ");
            String nama = input.nextLine();
            if (!nama.isEmpty()) p.setNama(nama);

            System.out.print("Klub Baru (" + p.getKlub() + "): ");
            String klub = input.nextLine();
            if (!klub.isEmpty()) p.setKlub(klub);

            System.out.print("Posisi Baru (" + p.getPosisi() + "): ");
            String posisi = input.nextLine();
            if (!posisi.isEmpty()) p.setPosisi(posisi);

            System.out.print("Nomor Punggung Baru (" + p.getNomorPunggung() + "): ");
            String num = input.nextLine();
            if (!num.isEmpty()) {
                try {
                    p.setNomorPunggung(Integer.parseInt(num));
                } catch (NumberFormatException e) {
                    System.out.println("Nomor punggung harus angka, tidak diubah.");
                }
            }

            System.out.print("Usia Baru (" + p.getUsia() + "): ");
            String usia = input.nextLine();
            if (!usia.isEmpty()) {
                try {
                    p.setUsia(Integer.parseInt(usia));
                } catch (NumberFormatException e) {
                    System.out.println("Usia harus angka, tidak diubah.");
                }
            }

            if (p instanceof PemainSenior) {
                PemainSenior ps = (PemainSenior) p;
                System.out.print("Penghargaan Baru (" + ps.getPenghargaan() + "): ");
                String penghargaan = input.nextLine();
                if (!penghargaan.isEmpty()) ps.setPenghargaan(penghargaan);
                
                // Update database
                dao.updatePemainSenior(ps, namaLama);
            }

            if (p instanceof PemainAkademi) {
                PemainAkademi pa = (PemainAkademi) p;
                System.out.print("Akademi Baru (" + pa.getAkademi() + "): ");
                String akademi = input.nextLine();
                if (!akademi.isEmpty()) pa.setAkademi(akademi);

                System.out.print("Tahun Masuk Baru (" + pa.getTahunMasuk() + "): ");
                String tahun = input.nextLine();
                if (!tahun.isEmpty()) {
                    try {
                        pa.setTahunMasuk(Integer.parseInt(tahun));
                    } catch (NumberFormatException e) {
                        System.out.println("Tahun masuk harus angka, tidak diubah.");
                    }
                }
                
                // Update database
                dao.updatePemainAkademi(pa, namaLama);
            }

            System.out.println("Data pemain berhasil diupdate!\n");
        } else {
            System.out.println("Pemain dengan nama tersebut tidak ditemukan atau bukan tipe yang dipilih.\n");
        }
    }

    public void hapusPemain() {
        if (pemainList.isEmpty()) {
            System.out.println("Belum ada data pemain.\n");
            return;
        }

        System.out.print("Masukkan nama pemain yang akan dihapus: ");
        String namaCari = input.nextLine().toLowerCase();

        Pemain p = null;
        for (Pemain pemain : pemainList) {
            if (pemain.getNama().toLowerCase().equals(namaCari)) {
                p = pemain;
                break;
            }
        }

        if (p != null) {
            pemainList.remove(p);
            
            // Hapus dari database
            if (p instanceof PemainSenior) {
                dao.hapusPemainSenior(p.getNama());
            } else if (p instanceof PemainAkademi) {
                dao.hapusPemainAkademi(p.getNama());
            }
            
            System.out.println("Pemain berhasil dihapus!\n");
        } else {
            System.out.println("Pemain dengan nama tersebut tidak ditemukan.\n");
        }
    }

    public void cariPemain() {
        if (pemainList.isEmpty()) {
            System.out.println("Belum ada data pemain.\n");
            return;
        }

        System.out.print("\nMasukkan nama pemain yang dicari: ");
        String keyword = input.nextLine().toLowerCase();

        boolean found = false;
        for (Pemain p : pemainList) {
            if (p.getNama().toLowerCase().contains(keyword)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nPemain tidak ditemukan.\n");
        } else {
            System.out.println();
        }
    }
}