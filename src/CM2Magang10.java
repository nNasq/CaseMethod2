//Hafizh Arrasyiid Syahbana
//254107060026
//SIB 1A
//https://github.com/nNasq/CaseMethod2/blob/main/src/CM2Magang10.java

import java.util.ArrayList;
import java.util.Scanner;

public class CM2Magang10 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<PendaftarMagang> data = new ArrayList<>();

    // Class untuk menyimpan data pendaftar magang
    static class PendaftarMagang {
        String nama, nim, prodi, perusahaan, status;
        int semester;

        // Konstruktor
        public PendaftarMagang(String nama, String nim, String prodi, String perusahaan, int semester,
                String status) {
            // Inisialisasi atribut
            this.nama = nama;
            this.nim = nim;
            this.prodi = prodi;
            this.perusahaan = perusahaan;
            this.semester = semester;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        // Menu utama
        while (true) {
            System.out.println("\n=== Sistem Pendaftaran Magang Mahasiswa ===");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar Magang");
            System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
            System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int menu = sc.nextInt();
            sc.nextLine();

            // Eksekusi berdasarkan pilihan menu
            if (menu == 1)
                tambahData();
            else if (menu == 2)
                tampilkanSemua();
            else if (menu == 3)
                cariBerdasarkanProdi();
            else if (menu == 4)
                hitungStatus();
            else if (menu == 5)
                break;
            else
                System.out.println("Pilihan tidak valid!");
        }
    }

    // Method untuk menambah data pendaftar magang
    static void tambahData() {
        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        System.out.print("Program Studi: ");
        String prodi = sc.nextLine();
        System.out.print("Perusahaan Tujuan Magang: ");
        String perusahaan = sc.nextLine();

        // Validasi input semester
        int semester;
        while (true) {
            System.out.print("Semester Pengambilan Magang (6 atau 7): ");
            semester = sc.nextInt();
            sc.nextLine();
            if (semester == 6 || semester == 7)
                break;
            else
                System.out.println("Semester harus 6 atau 7.");
        }

        // Validasi input status
        String status;
        while (true) {
            System.out.print("Status Magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine();
            if (status.equalsIgnoreCase("Diterima") || status.equalsIgnoreCase("Menunggu")
                    || status.equalsIgnoreCase("Ditolak"))
                break;
            else
                System.out.println("Status harus Diterima, Menunggu, atau Ditolak.");
        }
        System.out.println();

        // Menambahkan data pendaftar magang ke dalam list
        // data.add untuk menambahkan data ke dalam array list
        data.add(new PendaftarMagang(nama, nim, prodi, perusahaan, semester, status));
        // Konfirmasi penambahan data
        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + data.size());// data.size() untuk menghitung jumlah data yang sudah diinputkan
    }

    // Menampilakn Semua data
    static void tampilkanSemua() {
        // jika data kosong
        if (data.isEmpty()) {
            System.out.println("Belum ada data pendaftar magang.");
            return;
        }

        System.out.println("\nNo  Nama\tNIM\tProdi\t\tPerusahaan\tSemester\tStatus");
        int no = 1;

        // Menampilkan semua data pendaftar magang
        for (PendaftarMagang m : data) {
            System.out.printf("%d   %-10s %-10s %-15s %-15s %-8d %-10s\n",
                    no, m.nama, m.nim, m.prodi, m.perusahaan, m.semester, m.status);
            no++;
        }
    }

    // Menampilkan data sesuai prodi yang di inputkan
    static void cariBerdasarkanProdi() {
        System.out.print("Masukkan Program Studi yang dicari: ");
        String cariProdi = sc.nextLine();
        boolean ditemukan = false;

        System.out.println("\nNo  Nama\tNIM\tProdi\t\tPerusahaan\tSemester\tStatus");
        int no = 1;
        // Mencari dan menampilkan data sesuai prodi yang di inputkan
        for (PendaftarMagang m : data) {
            if (m.prodi.equalsIgnoreCase(cariProdi)) {
                System.out.printf("%d   %-10s %-10s %-15s %-15s %-8d %-10s\n",
                        no, m.nama, m.nim, m.prodi, m.perusahaan, m.semester, m.status);
                ditemukan = true;
                no++;
            }
        }

        // Jika tidak ditemukan data sesuai prodi yang di inputkan
        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar magang dari Program Studi " + cariProdi);
        }
    }

    // Menghitung Status dari semua data yang sudah diinputkan sebelumnya
    static void hitungStatus() {
        // jika data kosong
        if (data.isEmpty()) {
            System.out.println("Belum Ada Pendaftar.");
            return;
        }
        int diterima = 0, menunggu = 0, ditolak = 0;
        // Menghitung jumlah pendaftar berdasarkan status
        for (PendaftarMagang m : data) {
            switch (m.status.toLowerCase()) {
                case "diterima" -> diterima++;
                case "menunggu" -> menunggu++;
                case "ditolak" -> ditolak++;
            }
        }
        System.out.println("Diterima: " + diterima);
        System.out.println("Menunggu: " + menunggu);
        System.out.println("Ditolak: " + ditolak);
        System.out.println("Total Pendaftar: " + data.size());
    }
}
