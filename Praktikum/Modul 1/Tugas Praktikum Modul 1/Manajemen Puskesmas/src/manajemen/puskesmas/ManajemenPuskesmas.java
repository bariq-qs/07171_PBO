package manajemen.puskesmas;

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenPuskesmas {
    static ArrayList<Bariq07171_Orang> dataOrang = new ArrayList();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang Di Puskesmas ABC !!!");
        int pil;
        do {
            System.out.println("1. Daftar Akun Baru");
            System.out.println("2. List Akun Terdaftar");
            System.out.println("3. Login");
            System.out.println("0. Exit");
            System.out.print("Pilih = ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    daftar();
                    break;
                case 2:
                    listView();
                    break;
                case 3:
                    System.out.print("NIK = ");
                    int nik = input.nextInt();
                    System.out.print("Password = ");
                    String pass = input.next();
                    Login(nik, pass);
                    break;
            }
        } while (pil != 0);
    }

    static void daftar() {
        System.out.print("Input Nama = ");
        String nama = input.next();
        System.out.print("Input NIK = ");
        int nik = input.nextInt();
        System.out.print("Input Alamat = ");
        String alamat = input.next();
        System.out.print("Input Jenis Kelamin = ");
        String jeniskelamin = input.next();
        System.out.print("Input Password = ");
        String password = input.next();
        dataOrang.add(new Bariq07171_Orang(nama, alamat, password, jeniskelamin, nik));
    }

    static void Login(int nik, String password) {
        for (int i = 0; i < dataOrang.size(); i++) {
            if (nik == dataOrang.get(i).getBariq07171_NIK() 
                    && password.equals(dataOrang.get(i).getBariq07171_Password())) {
                System.out.println("Nama = " + dataOrang.get(i).getBariq07171_Nama());
                System.out.println("NIK = " + dataOrang.get(i).getBariq07171_NIK());
                System.out.println("Alamat = " + dataOrang.get(i).getBariq07171_Alamat());
                System.out.println("Jenis Kelamin = " + dataOrang.get(i).getBariq07171_NIK());
                int pilihan;
                do {
                    System.out.println("1. Edit Akun");
                    System.out.println("2. Hapus Akun");
                    System.out.println("3. Logout");
                    System.out.print("Pilih = ");
                    pilihan = input.nextInt();
                    switch (pilihan) {
                        case 1:
                            EditAkun(nik, i);
                            break;
                        case 2: 
                            DeleteAkun(i);
                            System.out.println("Data Berhasil Dihapus");
                        case 3:
                            System.out.println("Terima Kasih");
                    }
                } while (pilihan != 2 && pilihan !=3);
            }
        }
    }
    
    static void listView(){
        for (int i = 0; i < dataOrang.size(); i++) {
            if (dataOrang.size() > 0){
            System.out.println("<================================================>");
            System.out.println("Nama = " + dataOrang.get(i).getBariq07171_Nama());
            System.out.println("NIK = " + dataOrang.get(i).getBariq07171_NIK());
            System.out.println("Alamat = " + dataOrang.get(i).getBariq07171_Alamat());
            System.out.println("Jenis Kelamin = " + dataOrang.get(i).getBariq07171_NIK());
            System.out.println("<================================================>");
            }else{
                System.out.println("Data Kosong");
            }
        }
    }

    static void EditAkun(int nik, int index) {
        System.out.print("Input Nama = ");
        String nama = input.next();
        System.out.print("Input Alamat = ");
        String alamat = input.next();
        System.out.print("Input Jenis Kelamin = ");
        String jeniskelamin = input.next();
        System.out.print("Input Password = ");
        String password = input.next();
        dataOrang.set(index, new Bariq07171_Orang(nama, alamat, password, jeniskelamin, nik));
    }
    
    static void DeleteAkun (int index){
        dataOrang.remove(index);
    }

}
