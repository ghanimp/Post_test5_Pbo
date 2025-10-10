## Ghani Mandala Putra
## 2409116042
----
## Deskripsi Program

Program ini adalah aplikasi berbasis Java Console yang dirancang untuk mengelola data pemain sepak bola yang berlaga di Liga Inggris.
Aplikasi ini dikembangkan menggunakan konsep Object-Oriented Programming (OOP), dengan struktur kode yang terorganisir dan modular, sehingga mampu membedakan antara pemain senior dan pemain akademi dalam pengelolaannya.

Selain menggunakan prinsip OOP, program ini juga terintegrasi dengan database MySQL untuk menyimpan, memperbarui, menampilkan, dan menghapus data pemain secara permanen.
Melalui koneksi database yang diatur dalam class DatabaseConfig dan operasi CRUD (Create, Read, Update, Delete) yang diimplementasikan dalam class ServiceDatabase, seluruh data pemain dapat tersimpan dengan aman di dalam database pemain_bola.

Dengan demikian, program ini tidak hanya berfungsi sebagai sistem manajemen data berbasis konsol, tetapi juga sebagai contoh implementasi nyata dari integrasi Java dengan MySQL menggunakan JDBC (Java Database Connectivity) untuk mendukung pengelolaan data yang efisien dan terstruktur.

## Struktur Program

1. Class Pmain_Bola(Main)

Menyediakan menu utama berbasis teks:
- Tambah Pemain
- Lihat Daftar Pemain
- Update Pemain
- Hapus Pemain
- Cari Pemain
- Keluar

2. Package Database

- DatabaseConfig

Berfungsi untuk menghubungkan program ke database MySQL dan menutup koneksi saat sudah tidak digunakan.

- ServiceDatabase

Berfungsi untuk menghubungkan program Java-mu dengan database MySQL, khususnya untuk mengelola data pemain senior dan akademi.

4. Package model

- Pemain (Super Class)

Berisi data dasar pemain Liga Inggris: nama, klub, posisi, nomor punggung, usia.

- PemainAkademi (Subclass)

Berisi tambahan data akademi & tahun masuk bagi pemain muda yang terdaftar di akademi klub Liga Inggris.

- PemainSenior (Subclass)

Berisi tambahan data pengalaman atau penghargaan yang dimiliki pemain senior di Liga Inggris.

- PemainBase (Abstract class)

PemainBase ini menyimpan properti dasar nama dan klub yang dipakai oleh semua turunan, supaya kamu tidak copy-paste field itu ke setiap class.

- Performa (Interface)

Performa berfungsi sebagai kontrak yang mewajibkan setiap class yang mengimplementasikannya punya method tampilkanPerforma().

4. Package service

PemainService Menangani semua proses CRUD:

- Tambah Pemain Senior atau Pemain Akademi
- Lihat Daftar Pemain berdasarkan tipe (Semua, Senior saja, Akademi saja)
- Update Data Pemain
- Hapus Pemain
- Cari Pemain berdasarkan nama

5. Libraries

<img width="336" height="95" alt="image" src="https://github.com/user-attachments/assets/c6d40c23-3564-491e-b7d0-5cd543229890" />

Selanjutnya dipackage libraries saya menambahkaan mysql-connector-java untuk menghubungkan program Java dengan database MySQL.

----
## Penjelasan kode yang saya tambahkan

<img width="348" height="549" alt="image" src="https://github.com/user-attachments/assets/d85d084f-66c3-431f-a176-26b80edc4a76" />

Ini merupakan tampilan package terbaru saya
- Main (Pemain_Bola) sebagai class yang menjalankan program.
- Database (Database) Sebagai penghubung program ke database MySQL
- Model (Pemain) berisi model pemain, sub class pemain, abstract class, dan interface.
- Service (PemainService) berisi sistem CRUD.



<img width="1009" height="328" alt="image" src="https://github.com/user-attachments/assets/3d2935fb-7be3-441d-a01c-870331e8c491" />


- Class DatabaseConfig yang berfungsi untuk mengatur koneksi antara program Java dan database MySQL. Di dalamnya terdapat konfigurasi alamat database (URL), username (USER), dan password (PASSWORD), serta variabel connection yang menyimpan objek koneksi aktif. Library Connection, DriverManager, dan SQLException digunakan agar Java bisa terhubung ke MySQL melalui JDBC dan menangani error jika koneksi gagal.


<img width="910" height="431" alt="image" src="https://github.com/user-attachments/assets/1fd641df-78c6-415a-8185-6a1e2d51964d" />


- Method getConnection() yang berfungsi untuk membuka koneksi ke database MySQL. Di dalamnya, program memeriksa apakah koneksi masih kosong atau sudah tertutup; jika iya, maka Class.forName() memuat driver MySQL, dan DriverManager.getConnection() membuat koneksi baru menggunakan URL, USER, dan PASSWORD. Ketika berhasil, muncul pesan “Koneksi database berhasil!”. Blok catch digunakan untuk menangani kesalahan seperti driver tidak ditemukan atau koneksi gagal


<img width="782" height="276" alt="image" src="https://github.com/user-attachments/assets/ad94f4f8-aba1-4f44-8214-1ba3a0198880" />


- Method closeConnection() yang berfungsi untuk menutup koneksi database MySQL. Di dalamnya, program memeriksa apakah objek connection tidak kosong dan masih terbuka; jika iya, maka koneksi ditutup menggunakan connection.close(), lalu menampilkan pesan “Koneksi database ditutup.”. Jika terjadi kesalahan saat menutup koneksi, error akan ditangani oleh blok catch menggunakan printStackTrace().


<img width="554" height="282" alt="image" src="https://github.com/user-attachments/assets/cfde184e-638b-4df8-9d93-91ed852d312a" />


- Import dari java.sql seperti Connection, ResultSet, SQLException, dan Statement diperlukan untuk menjalankan operasi SQL seperti koneksi, eksekusi query, dan pengambilan data dari database. ArrayList dari java.util digunakan untuk menyimpan kumpulan data pemain dalam bentuk list. Sementara itu, model.Pemain, model.PemainSenior, dan model.PemainAkademi diimpor agar class ini bisa menggunakan objek-objek pemain dari package model.


<img width="1504" height="574" alt="image" src="https://github.com/user-attachments/assets/c2fa469e-5d92-4e5a-8565-4479aba6d612" />


- Kode ini berfungsi untuk menambahkan data pemain senior ke database. Metodenya bernama tambahPemainSenior, yang menerima objek PemainSenior lalu membuat koneksi ke database melalui DatabaseConfig.getConnection(). Setelah itu, query INSERT INTO dijalankan untuk memasukkan data pemain seperti nama, klub, posisi, nomor punggung, usia, penghargaan, dan catatan ke tabel pemain_senior. Jika berhasil, muncul pesan bahwa data tersimpan; jika gagal, program menampilkan pesan error dan detail kesalahan dengan printStackTrace().


<img width="1568" height="549" alt="image" src="https://github.com/user-attachments/assets/39b8a47a-e363-41b0-a5df-21d400e5cfb9" />


- Kode ini berfungsi untuk menyimpan data pemain akademi ke database. Metode tambahPemainAkademi membuat koneksi ke database melalui DatabaseConfig.getConnection(), lalu menjalankan perintah INSERT INTO pemain_akademi untuk menambahkan data seperti nama, klub, posisi, nomor punggung, usia, akademi, tahun masuk, dan catatan. Jika proses berhasil, muncul pesan bahwa data tersimpan, sedangkan jika gagal akan menampilkan pesan error dan detail kesalahannya.


<img width="853" height="841" alt="image" src="https://github.com/user-attachments/assets/a1fef253-1353-44bf-8e05-5940de17ce0e" />


- Kode ini berfungsi untuk mengambil semua data pemain senior dari tabel pemain_senior di database. Metode getAllPemainSenior() membuat koneksi ke database, menjalankan perintah SELECT * FROM pemain_senior, lalu membaca setiap baris hasil query menggunakan ResultSet. Data dari tiap baris digunakan untuk membuat objek PemainSenior yang kemudian dimasukkan ke dalam ArrayList. Jika terjadi kesalahan saat pengambilan data, program akan menampilkan pesan error di konsol.


<img width="848" height="843" alt="image" src="https://github.com/user-attachments/assets/6068d9d3-b50b-45b4-87d5-d2c6b0cdc9bf" />


- Kode ini berfungsi untuk mengambil semua data pemain akademi dari tabel pemain_akademi di database. Metode getAllPemainAkademi() membuat koneksi ke database, menjalankan perintah SELECT * FROM pemain_akademi, lalu membaca setiap baris hasil query menggunakan ResultSet. Data dari tiap baris digunakan untuk membuat objek PemainAkademi, kemudian ditambahkan ke dalam ArrayList. Jika terjadi kesalahan, program akan menampilkan pesan error di konsol.


<img width="994" height="657" alt="image" src="https://github.com/user-attachments/assets/5ada9946-c568-4e61-8f8b-71e3820dbce9" />


- Kode ini berfungsi untuk memperbarui data pemain senior di database berdasarkan nama pemain. Metode updatePemainSenior() menerima objek PemainSenior dan parameter namaLama, kemudian membuat koneksi ke database dan menjalankan perintah UPDATE untuk mengubah data seperti nama, klub, posisi, nomor punggung, usia, penghargaan, dan catatan. Query menggunakan kondisi WHERE untuk menargetkan pemain dengan nama yang sesuai dengan namaLama. Setelah eksekusi berhasil, program menampilkan pesan sukses, menutup koneksi, dan menangani error jika terjadi kegagalan dengan menampilkan pesan error di konsol.


<img width="1006" height="688" alt="image" src="https://github.com/user-attachments/assets/9b1a67bf-0a56-44a7-83b1-dcab196e3694" />


- Kode ini berfungsi untuk memperbarui data pemain akademi di database berdasarkan nama pemain. Metode updatePemainAkademi() menerima objek PemainAkademi dan parameter namaLama, kemudian membuat koneksi ke database dan menjalankan perintah UPDATE untuk mengubah data seperti nama, klub, posisi, nomor punggung, usia, akademi, tahun masuk, dan catatan. Query menggunakan kondisi WHERE untuk menargetkan pemain dengan nama yang sesuai dengan namaLama. Setelah eksekusi berhasil, program menampilkan pesan sukses, menutup koneksi, dan menangani error jika terjadi kegagalan dengan menampilkan pesan error di konsol.


<img width="996" height="421" alt="image" src="https://github.com/user-attachments/assets/270fb67d-95c9-47af-8748-9691bb13c477" />


- Kode ini berfungsi untuk menghapus data pemain senior dari database berdasarkan nama pemain. Metode hapusPemainSenior() menerima parameter nama, kemudian membuat koneksi ke database dan menjalankan perintah DELETE FROM pemain_senior dengan kondisi WHERE untuk menghapus data pemain yang memiliki nama sesuai parameter. Setelah eksekusi berhasil, program menampilkan pesan sukses, menutup koneksi, dan menangani error jika terjadi kegagalan dengan menampilkan pesan error di konsol.


<img width="1022" height="427" alt="image" src="https://github.com/user-attachments/assets/61a54d3c-7f73-4647-939b-0c80faf19833" />


- Kode ini berfungsi untuk menghapus data pemain akademi dari database berdasarkan nama pemain. Metode hapusPemainAkademi() menerima parameter nama, kemudian membuat koneksi ke database dan menjalankan perintah DELETE FROM pemain_akademi dengan kondisi WHERE untuk menghapus data pemain yang memiliki nama sesuai parameter. Setelah eksekusi berhasil, program menampilkan pesan sukses, menutup koneksi, dan menangani error jika terjadi kegagalan dengan menampilkan pesan error di konsol.


# Output


<img width="560" height="217" alt="image" src="https://github.com/user-attachments/assets/e7a2ea42-7c44-49bc-8ae2-f69757ac17be" />


- Tampilan Awal dari sistem.


<img width="944" height="343" alt="image" src="https://github.com/user-attachments/assets/e1de8381-1cc6-4da7-8337-9f06736231d0" />


- Tampilan ketika user memilih pilihan satu, user akan melakukan pemilihan apakah akan memasukan pemain senior atau akademi lalu memasukan data pemain sesuai yang dipilih, kemudia user akan memilih apakah akan membuat catatan performa pemain atau tidak. Lalu akan menampilkan "nama pemain yang dimasukan bermain di klub yang dimasukan. kemudian catatan sesuai yang user masukan", dan menampilkan "Data pemain berhasil disimpan ke database!".


<img width="1810" height="496" alt="image" src="https://github.com/user-attachments/assets/3df8bb4c-3301-4a0d-9c9f-a63a6586ba4b" />


- Selanjutnya ini adalah tampilan saat user ingin melihat daftar pemain yang ada, dimana user bisa memilih daftar pemain apa yang ingin dilihat, apakah ingin memilih menampilkan semua, pemain senior, atau pemain akademi. Lalu user akan diberikan pilihan apakah akan menampilkan catatan pemain atau tidak.


<img width="896" height="343" alt="image" src="https://github.com/user-attachments/assets/868e5b93-f3b9-457b-9e47-9b082d421bfb" />


- Tampilan saat user melakukan update, dimana terdapat pilihan untuk mengantisipasi adanya kesamaan data dari pemain senior dan pemain junior jika tidak dipisahkan.


<img width="858" height="369" alt="image" src="https://github.com/user-attachments/assets/b79f6c0b-f9a6-4089-acd5-c8ea3b3db6b3" />


- Tampilan saat menghapus pemain.


<img width="1368" height="107" alt="image" src="https://github.com/user-attachments/assets/8419babb-4ec9-41c7-a83a-e0ec074a09e5" />


- Tampilan saat user mencari pemain yang ingin dicari.


<img width="800" height="122" alt="image" src="https://github.com/user-attachments/assets/9e2750be-7044-4a45-a596-9465cf0a0c8f" />


- Tampilan saat user keluar program.


# Data Pada MYSQL


<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/057bea05-2844-4fbf-8361-de46109e24c0" />


- Terdapat 2 table pada database pemain_bola yaitu table pemain_akademi dan pemain_senior.


<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/75f33f4d-9f90-487b-8647-4a9fb07b2b31" />


- Tampilan data pada pemain_akademi.


<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/3c5dbc65-e5cd-4129-a8e7-3e79290786f0" />


- Tampilan data pada tabel pemain_senior.
