/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Bariq07171_DaftarPasienEntity;
import Entity.Bariq07171_PasienEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Bariq07171_DaftarPasienModel implements Bariq07171_ModelInterfaces {

    private ArrayList<Bariq07171_DaftarPasienEntity> daftarPasienArrayList;

    public Bariq07171_DaftarPasienModel() {
        daftarPasienArrayList = new ArrayList<Bariq07171_DaftarPasienEntity>();
    }

    public void insertDataDaftarpasien(Bariq07171_DaftarPasienEntity daftarPasien) {
        daftarPasienArrayList.add(daftarPasien);
    }

    public ArrayList<Bariq07171_DaftarPasienEntity> getDaftarpasienArrayList() {
        return daftarPasienArrayList;
    }

    @Override
    public void view() {
        for (Bariq07171_DaftarPasienEntity daftarPasien : daftarPasienArrayList) {
            System.out.println("===============================================================");
            System.out.println(" NIK : " + daftarPasien.getPasien().getNik()
                    + "\n Nama : " + daftarPasien.getPasien().getNama()
                    + "\n Password : " + daftarPasien.getPasien().getPassword()
                    + "\n No Telp : " + daftarPasien.getPasien().getNo_telp()
                    + "\n Jenis Kelamin : " + daftarPasien.getPasien().getJeniskelamin()
                    + "\n Alamat : " + daftarPasien.getPasien().getAlamat()
                    + "\n Tanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(daftarPasien.getPasien().getTgllahir()));
//            if (daftarprak07171.isVerified() == false) {
//                System.out.println("Belum Di Verifikasi Admin");
//            } else {
//                System.out.println("Telah Di Verifikasi");
//            }
            System.out.println("===============================================================");
        }
    }

    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        if (daftarPasienArrayList.size() == 0) {
            loop = -1;//data kosong
        } else {
            for (int i = 0; i < daftarPasienArrayList.size(); i++) {
                if (daftarPasienArrayList.get(i).getPasien().getNik() == nik) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
}
