/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bariq Qushoyyi
 */
import Entity.*;
import Controller.*;
import java.util.Date;
import java.util.Scanner;

public class Bariq07171_Main {

    private static Bariq07171_PasienController pasien = new Bariq07171_PasienController();
    private static Bariq07171_DokterController dokter = new Bariq07171_DokterController();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang Di Aplikasi Sistem Informasi Manajemen Puskesmas");
        dokter.dataDokter();
        pasien.dataPasien();
        menu();
    }

    static void menu() {
        int loop = 0;
        do {
            int pilih = 0;
            System.out.print(" 1. Login"
                    + "\n 2. Daftar Pasien"
                    + "\n 0. Stop"
                    + "\n Masukkan Pilihan Anda : ");
            pilih = input.nextInt();
            if (pilih == 1) {
                int pilLogin = 0;
                System.out.print(" 1. Login Dokter"
                        + "\n 2. Login Pasien"
                        + "\n Pilih : ");
                pilLogin = input.nextInt();
                if (pilLogin == 1) {
                    loginDokter();
                } else {
                    loginPasien();
                }
            } else if (pilih == 2) {
                register();
            } else {
                break;
            }
        } while (loop != 1);
    }

    static void register() {
        try {
            System.out.print("Input NIK = ");
            int nik = input.nextInt();
            System.out.print("Input Nama = ");
            String nama = input.next();
            System.out.print("Input Password = ");
            String pass = input.next();
            System.out.print("Input Alamat = ");
            String alamat = input.next();
            System.out.print("Jenis Kelamin = ");
            String jeniskelamin = input.next();
            System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
            Date tanggal = new Date(input.next());
            System.out.print("No Telp = ");
            String no_telp = input.next();
            pasien.postData(pass, nama, no_telp, alamat, jeniskelamin, nik, tanggal, "newPasien");
        } catch (Exception exception) {
            System.out.println("Format Pengisian Salah !!!");
        }
    }

    static void loginPasien() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        try {
            pasien.login(nik, password);
            System.out.println("Selamat Datang " + pasien.pasienEntity().getNama());
            menuPasien();
        } catch (Exception exception) {
            System.out.println("Data Pasien Tidak Ditemukan !!!");
        }
    }

    static void menuPasien() {
        int pilihMenuPasien;
        System.out.print("1. Edit Data"
                + "\n2. Daftar Sebagai Antrian"
                + "\n0. Back to Menu"
                + "\n Masukkan Pilihan Anda : ");
        pilihMenuPasien = input.nextInt();
        if (pilihMenuPasien == 1) {
            System.out.print("Input NIK = ");
            int nik = input.nextInt();
            System.out.print("Input Nama = ");
            String nama = input.next();
            System.out.print("Input Password = ");
            String pass = input.next();
            System.out.print("Input Alamat = ");
            String alamat = input.next();
            System.out.print("Jenis Kelamin = ");
            String jeniskelamin = input.next();
            System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
            Date tanggal = new Date(input.next());
            System.out.print("No Telp = ");
            String no_telp = input.next();
            pasien.postData(pass, nama, no_telp, alamat, jeniskelamin, nik, tanggal, "editPasien");
        } else if (pilihMenuPasien == 2) {
            pendaftaranAntrian();
        } else {
            menu();
        }
    }

    static void loginDokter() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        try {
            dokter.login(nik, password);
            System.out.println("Selamat Datang " + dokter.dokterEntity().getNama()
                    + " Dari Poli " + dokter.showPoliDokter(dokter.dokterEntity().getPoli()));
            menuDokter();
        } catch (Exception exception) {
            System.out.println("Data Dokter Tidak Ditemukan !!!");
        }
    }

    static void menuDokter() {
        int pilihMenuDokter;
        System.out.print("1. List Antrian"
                + "\n2. Delete Antrian"
                + "\n0. Back to Menu"
                + "\n Masukkan Pilihan Anda : ");
        pilihMenuDokter = input.nextInt();
        if (pilihMenuDokter == 1) {
            dokter.listAntrianPoli(dokter.dokterEntity().getPoli());
            menuDokter();
        } else if (pilihMenuDokter == 2) {
            deleteAntrianPasien();
        } else {
            menu();
        }
    }

    static void deleteAntrianPasien() {
        System.out.print("Delete Nomor Ke : ");
        int indexList = input.nextInt();
        try {
            dokter.deleteListAntrianPasien(indexList);
        } catch (Exception exception) {
            System.out.println("Data Yang Anda Inputkan Salah");
        }
    }

    static void pendaftaranAntrian() {
        System.out.println("Silahkan Pilih Poli Yang Dituju ");
        for (int i = 0; i < Bariq07171_PoliEntity.nama.length; i++) {
            System.out.println(i + ". " + Bariq07171_PoliEntity.nama[i]);
        }
        System.out.print("Pilih Poli = ");
        int pilPoli = input.nextInt();
        try {
            pasien.registerAntrian(pilPoli, pasien.pasienEntity());
            System.out.println("Anda Sudah Terdaftar Di Poli = " + pasien.showNamePoli(pilPoli));
        } catch (Exception exception) {
            System.out.println("Data Yang Anda Inputkan Salah");
        }
    }
}
