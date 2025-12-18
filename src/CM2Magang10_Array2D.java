//Hafizh Arrasyiid Syahbana
//254107060026
//SIB 1A
//https://github.com/nNasq/CaseMethod2/blob/main/src/CM2Magang10.java

import java.util.Scanner;

public class CM2Magang10_Array2D {
    static Scanner sc = new Scanner(System.in);

    // Maksimal 100 pendaftar
    static String[][] data = new String[100][6];
    // index kolom:
    // 0=nama, 1=nim, 2=prodi, 3=perusahaan, 4=semester, 5=status

    // jumlah data tersimpan
    static int count = 0;

    public static void main(String[] args) {
        int menu;

        do {
            System.out.println("\n=== Sistem Pendaftaran Magang Mahasiswa ===");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar Magang");
            System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
            System.out.println("4. Cari Pendaftar berdasarkan Perusahaan Magang");
            System.out.println("5. Hitung Jumlah Pendaftar untuk Setiap Status");
            // System.out.println("5. Hitung Total Pendaftar per Program Studi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> tambahData();
                case 2 -> tampilkanSemua();
                case 3 -> cariBerdasarkanProdi();
                case 4 -> cariBerdasarkanMagang();
                case 5 -> hitungStatus();
                // case 5 -> hitungTotalPerProdi();
                case 6 -> System.out.println("Terima kasih telah menggunakan sistem.");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (menu != 5);

    }

    // 1. Tambah Data ke dalam Array
    static void tambahData() {
        if (count >= 100) {
            System.out.println("Kapasitas penuh! Tidak bisa menambah data.");
            return;
        }

        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        System.out.print("Program Studi: ");
        String prodi = sc.nextLine();
        System.out.print("Perusahaan Tujuan Magang: ");
        String perusahaan = sc.nextLine();

        // Validasi semester
        String semester;
        while (true) {
            System.out.print("Semester Pengambilan Magang (6 atau 7): ");
            semester = sc.nextLine();
            if (semester.equals("6") || semester.equals("7"))
                break;
            System.out.println("Semester harus 6 atau 7.");
        }

        // Validasi status
        String status;
        while (true) {
            System.out.print("Status Magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine();
            if (status.equalsIgnoreCase("Diterima") ||
                    status.equalsIgnoreCase("Menunggu") ||
                    status.equalsIgnoreCase("Ditolak"))
                break;
            System.out.println("Status harus Diterima, Menunggu, atau Ditolak.");
        }

        // Simpan ke array 2D
        data[count][0] = nama;
        data[count][1] = nim;
        data[count][2] = prodi;
        data[count][3] = perusahaan;
        data[count][4] = semester;
        data[count][5] = status;

        count++;

        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + count);
        System.out.println("Data berhasil disimpan! dengan NIM : " + nim);
    }

    // 2. Tampilkan Semua Data
    static void tampilkanSemua() {
        if (count == 0) {
            System.out.println("Belum ada data pendaftar magang.");
            return;
        }

        System.out.println("\nNo  Nama\tNIM\tProdi\t\tPerusahaan\tSemester\tStatus");

        for (int i = 0; i < count; i++) {
            System.out.printf("%d   %-10s %-10s %-15s %-15s %-8s %-10s %-10s\n",
                    i + 1, data[i][0], data[i][1], data[i][2], data[i][3],
                    data[i][4], data[i][5]);
        }
    }

    // 3. Cari Berdasarkan Prodi
    static void cariBerdasarkanProdi() {
        System.out.print("Masukkan Program Studi yang dicari: ");
        String cariProdi = sc.nextLine();

        boolean ditemukan = false;

        System.out.println("\nNo  Nama\tNIM\tProdi\t\tPerusahaan\tSemester\tStatus");

        int no = 1;
        for (int i = 0; i < count; i++) {
            if (data[i][2].equalsIgnoreCase(cariProdi)) {
                System.out.printf("%d   %-10s %-10s %-15s %-15s %-8s %-10s\n",
                        no, data[i][0], data[i][1], data[i][2], data[i][3],
                        data[i][4], data[i][5]);
                ditemukan = true;
                no++;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar magang dari Program Studi " + cariProdi);
        }
    }

    static void cariBerdasarkanMagang() {
        System.out.print("Masukkan perusahaan tujuan magang yang dicari: ");
        String cariMagang = sc.nextLine();

        boolean ditemukan = false;
        int total = 0;

        System.out.println("\nNo  Nama\tNIM\tProdi\t\tSemester\tStatus");

        int no = 1;
        for (int i = 0; i < count; i++) {
            if (data[i][3].equalsIgnoreCase(cariMagang)) {
                System.out.printf("%d   %-10s %-10s %-15s %-8s %-10s\n",
                        no, data[i][0], data[i][1], data[i][2],
                        data[i][4], data[i][5]);
                ditemukan = true;
                total++;
                no++;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar magang dari perusahaan tujuan magang " + cariMagang);
        } else {
            System.out.println("\nTotal pendaftar magang di perusahaan " + cariMagang + ": " + total);
        }
    }

    // 4. Hitung Status Magang
    static void hitungStatus() {
        if (count == 0) {
            System.out.println("Belum Ada Pendaftar.");
            return;
        }

        int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < count; i++) {
            String status = data[i][5].toLowerCase();

            switch (status) {
                case "diterima" -> diterima++;
                case "menunggu" -> menunggu++;
                case "ditolak" -> ditolak++;
            }
        }

        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
        System.out.println("Total Pendaftar : " + count);
    }

    // static void hitungTotalPerProdi() {
    // String[] prodiList = new String[100];
    // int[] totalProdi = new int[100];
    // int jumlahProdi = 0;

    // for (int i = 0; i < count; i++) {
    // String prodi = data[i][2];
    // boolean ditemukan = false;

    // for (int j = 0; j < jumlahProdi; j++) {
    // if (prodiList[j].equalsIgnoreCase(prodi)) {
    // totalProdi[j]++;
    // ditemukan = true;
    // break;
    // }
    // }

    // if (!ditemukan) {
    // prodiList[jumlahProdi] = prodi;
    // totalProdi[jumlahProdi] = 1;
    // jumlahProdi++;
    // }
    // }

    // System.out.println("\n=== Total Pendaftar per Program Studi ===");
    // for (int i = 0; i < jumlahProdi; i++) {
    // System.out.println(prodiList[i] + " : " + totalProdi[i]);
    // }
    // }

}
