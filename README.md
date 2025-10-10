## Ghani Mandala Putra
## 2409116042
----
## Deskripsi Program

Program ini adalah aplikasi berbasis Java Console yang dirancang untuk mengelola data pemain sepak bola yang berlaga di Liga Inggris. Program ini dibangun menggunakan konsep OOP (Object-Oriented Programming) dengan struktur yang rapi, sehingga mampu memisahkan pemain senior dan pemain akademi.

## Struktur Program

1. Class Post_test1 (Main)

Menyediakan menu utama berbasis teks:
- Tambah Pemain
- Lihat Daftar Pemain
- Update Pemain
- Hapus Pemain
- Cari Pemain
- Keluar

2. Package model

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

3. Package service

PemainService Menangani semua proses CRUD:

- Tambah Pemain Senior atau Pemain Akademi
- Lihat Daftar Pemain berdasarkan tipe (Semua, Senior saja, Akademi saja)
- Update Data Pemain
- Hapus Pemain
- Cari Pemain berdasarkan nama
----
## Penjelasan kode yang saya tambahkan

<img width="391" height="328" alt="image" src="https://github.com/user-attachments/assets/2a031fc0-c5ba-44cb-a209-ab203f75ee13" />

Ini merupakan tampilan package terbaru saya
- Main (Post_test1) sebagai class yang menjalankan program.
- Model (Pemain) berisi model pemain, sub class pemain, abstract class, dan interface.
- Service (PemainService) berisi sistem CRUD.


<img width="453" height="175" alt="image" src="https://github.com/user-attachments/assets/39f5551d-d72f-4e92-b7de-094b58111126" />


- Interface Performa digunakan sebagai kontrak yang mewajibkan setiap class pemain memiliki metode tampilkanPerforma() dan tampilkanInfo(). Melalui interface ini program dapat memanfaatkan konsep abstraction dan polymorphism, di mana setiap class pemain memiliki implementasi berbeda walaupun metode yang dipanggil sama.


<img width="787" height="71" alt="image" src="https://github.com/user-attachments/assets/d6dc347b-bf36-49b2-9863-8c9afab2e0e2" />


- Baris kode public class Pemain extends PemainBase implements Performa menerapkan abstraction dengan menggabungkan abstract class dan interface. Keyword extends mewarisi PemainBase, sedangkan implements menjalankan kontrak dari interface Performa. Kombinasi keduanya membuktikan penggunaan abstract class dan interface secara bersamaan.


<img width="667" height="269" alt="image" src="https://github.com/user-attachments/assets/f5be1492-53b4-49fd-af15-0ae34d878f28" />


- Abstract class PemainBase berperan sebagai kerangka dasar bagi seluruh jenis pemain. Class ini menyimpan atribut umum seperti nama dan klub serta menyediakan method abstrak infoPosisi() yang harus diimplementasikan oleh setiap subclass. Dengan penerapan ini, program memanfaatkan konsep abstraction agar atribut dan perilaku dasar tersentralisasi dan lebih mudah dikelola.


<img width="1021" height="411" alt="image" src="https://github.com/user-attachments/assets/2d244983-49f5-42bd-ab09-2370e913ff48" />


- Kode ini terlihat penerapan polymorphism melalui overriding. Method tampilkanPerforma(), tampilkanInfo(), dan toString() di-override dari interface atau superclassnya untuk menyesuaikan perilaku khusus pemain senior. Hal ini memungkinkan setiap class turunan memiliki cara sendiri dalam menampilkan data, meskipun dipanggil dengan nama method yang sama.


<img width="1319" height="272" alt="image" src="https://github.com/user-attachments/assets/1deefd3c-656f-45bf-a0e9-d9b2b9ab41bc" />


- Kode ini terlihat penerapan polymorphism melalui overriding. Method tampilkanPerforma() dan toString() diimplementasikan ulang secara khusus di class pemain akademi untuk menampilkan informasi akademi dan tahun masuk. Hal ini memungkinkan setiap class turunan menampilkan data yang berbeda meskipun dipanggil dengan nama method yang sama.


<img width="1237" height="248" alt="image" src="https://github.com/user-attachments/assets/0ae9fac4-769b-4d10-9f12-3e5d8b4b8ffe" />


- Bagian ini menerapan method overloading pada method tampilkanPerforma(). Method pertama tanpa parameter, method kedua dengan parameter String tambahan. Perbedaan parameter ini memungkinkan Java membedakan kedua method meskipun namanya sama, sehingga terbukti menerapkan polymorphism jenis overloading.


# Output


<img width="558" height="212" alt="image" src="https://github.com/user-attachments/assets/3c7cdb20-d0ed-49b1-b478-fa25c705b02d" />


- Tampilan Awal dari sistem.


<img width="865" height="338" alt="image" src="https://github.com/user-attachments/assets/fb4d6207-af6c-4071-877c-97df1e48220f" />


- Tampilan ketika user memilih pilihan satu, user akan melakukan pemilihan apakah akan memasukan pemain senior atau akademi lalu memasukan data pemain sesuai yang dipilih, kemudia user akan memilih apakah akan membuat catatan performa pemain atau tidak. Lalu akan menampilkan "nama pemain yang dimasukan bermain di klub yang dimasukan. kemudian catatan sesuai yang user masukan".


<img width="1403" height="266" alt="image" src="https://github.com/user-attachments/assets/7fd3825d-ca3a-4bd4-bc5d-6427dea3d106" />


- Selanjutnya ini adalah tampilan saat user ingin melihat daftar pemain yang ada, dimana user bisa memilih daftar pemain apa yang ingin dilihat, apakah ingin memilih menampilkan semua, pemain senior, atau pemain akademi.


<img width="629" height="360" alt="image" src="https://github.com/user-attachments/assets/e954ad3c-0c26-47a8-a0ee-0b4e095f8e8e" />


- Tampilan saat user melakukan update, dimana terdapat pilihan untuk mengantisipasi adanya kesamaan data dari pemain senior dan pemain junior jika tidak dipisahkan.


<img width="858" height="369" alt="image" src="https://github.com/user-attachments/assets/b79f6c0b-f9a6-4089-acd5-c8ea3b3db6b3" />


- Tampilan saat menghapus pemain.


<img width="1368" height="107" alt="image" src="https://github.com/user-attachments/assets/8419babb-4ec9-41c7-a83a-e0ec074a09e5" />


- Tampilan saat user mencari pemain yang ingin dicari.


<img width="800" height="122" alt="image" src="https://github.com/user-attachments/assets/9e2750be-7044-4a45-a596-9465cf0a0c8f" />


- Tampilan saat user keluar program.

























