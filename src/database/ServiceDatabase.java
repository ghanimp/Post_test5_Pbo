package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pemain;
import model.PemainSenior;
import model.PemainAkademi;

public class ServiceDatabase {
    public void tambahPemainSenior(PemainSenior pemain) {
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "INSERT INTO pemain_senior (nama, klub, posisi, nomor_punggung, usia, penghargaan, catatan) " +
                    "VALUES ('" + pemain.getNama() + "', '" + pemain.getKlub() + "', '" + 
                    pemain.getPosisi() + "', " + pemain.getNomorPunggung() + ", " + 
                    pemain.getUsia() + ", '" + pemain.getPenghargaan() + "', '" + 
                    pemain.getCatatan() + "')";
            
            stmt.executeUpdate(query);
            System.out.println("Data pemain senior berhasil disimpan ke database!");
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan data pemain senior!");
            e.printStackTrace();
        }
    }

    public void tambahPemainAkademi(PemainAkademi pemain) {
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "INSERT INTO pemain_akademi (nama, klub, posisi, nomor_punggung, usia, akademi, tahun_masuk, catatan) " +
                    "VALUES ('" + pemain.getNama() + "', '" + pemain.getKlub() + "', '" + 
                    pemain.getPosisi() + "', " + pemain.getNomorPunggung() + ", " + 
                    pemain.getUsia() + ", '" + pemain.getAkademi() + "', " + 
                    pemain.getTahunMasuk() + ", '" + pemain.getCatatan() + "')";
            
            stmt.executeUpdate(query);
            System.out.println("Data pemain akademi berhasil disimpan ke database!");
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan data pemain akademi!");
            e.printStackTrace();
        }
    }

    public ArrayList<Pemain> getAllPemainSenior() {
        ArrayList<Pemain> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "SELECT * FROM pemain_senior";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                PemainSenior pemain = new PemainSenior(
                    rs.getString("nama"),
                    rs.getString("klub"),
                    rs.getString("posisi"),
                    rs.getInt("nomor_punggung"),
                    rs.getInt("usia"),
                    rs.getString("penghargaan")
                );
                pemain.setCatatan(rs.getString("catatan"));
                list.add(pemain);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pemain senior!");
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Pemain> getAllPemainAkademi() {
        ArrayList<Pemain> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "SELECT * FROM pemain_akademi";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                PemainAkademi pemain = new PemainAkademi(
                    rs.getString("nama"),
                    rs.getString("klub"),
                    rs.getString("posisi"),
                    rs.getInt("nomor_punggung"),
                    rs.getInt("usia"),
                    rs.getString("akademi"),
                    rs.getInt("tahun_masuk")
                );
                pemain.setCatatan(rs.getString("catatan"));
                list.add(pemain);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pemain akademi!");
            e.printStackTrace();
        }
        return list;
    }

    public void updatePemainSenior(PemainSenior pemain, String namaLama) {
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "UPDATE pemain_senior SET " +
                    "nama='" + pemain.getNama() + "', " +
                    "klub='" + pemain.getKlub() + "', " +
                    "posisi='" + pemain.getPosisi() + "', " +
                    "nomor_punggung=" + pemain.getNomorPunggung() + ", " +
                    "usia=" + pemain.getUsia() + ", " +
                    "penghargaan='" + pemain.getPenghargaan() + "', " +
                    "catatan='" + pemain.getCatatan() + "' " +
                    "WHERE nama='" + namaLama + "'";
            
            stmt.executeUpdate(query);
            System.out.println("Data pemain senior berhasil diupdate di database!");
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal update data pemain senior!");
            e.printStackTrace();
        }
    }

    public void updatePemainAkademi(PemainAkademi pemain, String namaLama) {
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "UPDATE pemain_akademi SET " +
                    "nama='" + pemain.getNama() + "', " +
                    "klub='" + pemain.getKlub() + "', " +
                    "posisi='" + pemain.getPosisi() + "', " +
                    "nomor_punggung=" + pemain.getNomorPunggung() + ", " +
                    "usia=" + pemain.getUsia() + ", " +
                    "akademi='" + pemain.getAkademi() + "', " +
                    "tahun_masuk=" + pemain.getTahunMasuk() + ", " +
                    "catatan='" + pemain.getCatatan() + "' " +
                    "WHERE nama='" + namaLama + "'";
            
            stmt.executeUpdate(query);
            System.out.println("Data pemain akademi berhasil diupdate di database!");
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal update data pemain akademi!");
            e.printStackTrace();
        }
    }

    public void hapusPemainSenior(String nama) {
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "DELETE FROM pemain_senior WHERE nama='" + nama + "'";
            stmt.executeUpdate(query);
            System.out.println("Data pemain senior berhasil dihapus dari database!");
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal menghapus data pemain senior!");
            e.printStackTrace();
        }
    }

    public void hapusPemainAkademi(String nama) {
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "DELETE FROM pemain_akademi WHERE nama='" + nama + "'";
            stmt.executeUpdate(query);
            System.out.println("Data pemain akademi berhasil dihapus dari database!");
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal menghapus data pemain akademi!");
            e.printStackTrace();
        }
    }
}