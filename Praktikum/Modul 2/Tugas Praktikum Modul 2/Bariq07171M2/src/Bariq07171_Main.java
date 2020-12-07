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
import Model.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bariq07171_Main {

    private static Bariq07171_DokterModel dokterModel = new Bariq07171_DokterModel();
    private static Bariq07171_PasienModel pasienModel = new Bariq07171_PasienModel();
    private static Bariq07171_DaftarPasienModel DaftarpasienModel = new Bariq07171_DaftarPasienModel();
    private static Scanner input = new Scanner(System.in);
    static int cekDokter, cekPasien;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Selamat Datang Di Aplikasi Sistem Informasi Manajemen Puskesmas");
        menu();
    }

    static void menu() {
        int loop = 0;
        //dataAslab();
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
                    login();
                }
            } else if (pilih == 2) {
                register();
            } else if (pilih == 3) {
                //aslabModel.view();
            } else {
                break;
            }
        } while (loop != 1);
    }

    static void register() {
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
        pasienModel.insertPasien(new Bariq07171_PasienEntity(pass, nama, no_telp, alamat, jeniskelamin, nik, tanggal));
    }

    static void login() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        cekPasien = pasienModel.cekData(nik, password);
        System.out.println("Selamat Datang " + pasienModel.getPasienArrayList(cekPasien).getNama());
    }

    static void loginDokter() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        cekDokter = dokterModel.cekData(nik, password);
        System.out.println("Selamat Datang " + dokterModel.showDataDokter(cekDokter).getNama());
    }
}
