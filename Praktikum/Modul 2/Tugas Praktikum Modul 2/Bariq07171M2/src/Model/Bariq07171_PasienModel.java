/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import Entity.Bariq07171_PasienEntity;
import java.text.SimpleDateFormat;

public class Bariq07171_PasienModel implements Bariq07171_ModelInterfaces {

    private ArrayList<Bariq07171_PasienEntity> pasienArrayList;

    public Bariq07171_PasienModel() {
        pasienArrayList = new ArrayList<Bariq07171_PasienEntity>();
    }

    public void insertPasien(Bariq07171_PasienEntity pasien) {
        pasienArrayList.add(pasien);
    }

    public void updatePasien(int isData, Bariq07171_PasienEntity pasien) {
        pasienArrayList.set(isData, (Bariq07171_PasienEntity) pasien);
    }

    @Override
    public void view() {
        for (Bariq07171_PasienEntity pasien : pasienArrayList) {
            System.out.println("========================================================");
            System.out.println(" NIK : " + pasien.getNik()
                    + "\n Nama : " + pasien.getNama()
                    + "\n Alamat : " + pasien.getAlamat()
                    + "\n Jenis Kelamin : " + pasien.getJeniskelamin()
                    + "\n Tanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(pasien.getTgllahir()));
            System.out.println("========================================================");
            System.out.println();
        }
    }

    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        for (Bariq07171_PasienEntity pasienEntity : pasienArrayList) {
            if (pasienEntity.getNik() == nik && pasienEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }

    public Bariq07171_PasienEntity getPasienArrayList(int index) {
        return pasienArrayList.get(index);
    }

}
