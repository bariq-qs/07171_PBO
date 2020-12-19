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
    private static int pilPrak;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Selamat Datang Di Aplikasi Sistem Informasi Manajemen Puskesmas");
        dataDokter();
        dataPasien();
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
        pasienModel.insertPasien(new Bariq07171_PasienEntity(pass, nama, no_telp, alamat, jeniskelamin, nik, tanggal) {});
    }

    static void login() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        cekPasien = pasienModel.cekData(nik, password);
        System.out.println("Selamat Datang " + pasienModel.getPasienArrayList(cekPasien).getNama());
        pendaftaranAntrian();
    }

    static void loginDokter() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        cekDokter = dokterModel.cekData(nik, password);
        System.out.println("Selamat Datang " + dokterModel.showDataDokter(cekDokter).getNama());
        showDataPasien(dokterModel.showDataDokter(cekDokter).getPoli());
    }

    static void showDataPasien(int Poli) {
        for (int i = 0; i < DaftarpasienModel.getDaftarpasienArrayList().size(); i++) {
            if (Poli == DaftarpasienModel.getDaftarpasienArrayList().get(i).getNamaPoli()) {
                System.out.println(i+". "+ DaftarpasienModel.getDaftarpasienArrayList().get(i).getPasien().getNama());
            }
        }
    }

    static void dataDokter() {
        int nikDokter[] = {01, 02, 03};
        String passDokter[] = {"01", "02", "03"};
        String namaDokter[] = {"Yuli", "Farid", "Ananda"};
        String notelpDokter[] = {"01", "02", "03"};
        int poli[] = {0, 1, 2};
        String jenis[] = {"Perempuan", "Pria", "Perempuan"};
        String alamatDokter[] = {"Kemayoran", "Dupak", "TP"};
        String tglLahirDokter[] = {"04/05/2000", "01/12/2000", "03/03/2000"};
        for (int i = 0; i < nikDokter.length; i++) {
            dokterModel.insertDokter(new Bariq07171_DokterEntity(poli[i], passDokter[i], namaDokter[i], notelpDokter[i], alamatDokter[i], jenis[i], nikDokter[i], new Date(tglLahirDokter[i])));
        };
    }

    static void dataPasien() {
        int nik[] = {01, 02, 03};
        String pass[] = {"01", "02", "03"};
        String nama[] = {"Bariq", "Qushoyyi", "Shobriy"};
        String no_telp[] = {"01", "02", "03"};
        String jeniskelamin[] = {"Perempuan", "Pria", "Perempuan"};
        String alamat[] = {"Kemayoran", "Dupak", "TP"};
        String tanggal[] = {"04/05/2000", "01/12/2000", "03/03/2000"};
        for (int i = 0; i < nik.length; i++) {
            pasienModel.insertPasien(new Bariq07171_PasienEntity(pass[i], nama[i], no_telp[i], alamat[i], jeniskelamin[i], nik[i], new Date(tanggal[i])) {});
        };
    }

    static void pendaftaranAntrian() {
        System.out.println("Pilih Poli = ");
        for (int i = 0; i < Bariq07171_PoliEntity.nama.length; i++) {
            System.out.println(i + ". " + Bariq07171_PoliEntity.nama[i]);
        }
        System.out.print("Pilih Poli = ");
        pilPrak = input.nextInt();
        DaftarpasienModel.insertDataDaftarpasien(new Bariq07171_DaftarPasienEntity(pasienModel.getPasienArrayList(cekPasien), pilPrak));
    }
}
