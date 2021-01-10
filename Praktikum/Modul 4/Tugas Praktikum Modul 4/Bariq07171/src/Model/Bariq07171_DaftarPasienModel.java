/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Bariq07171_DaftarPasienEntity;
import Entity.Bariq07171_PoliEntity;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Bariq07171_DaftarPasienModel {

    private ArrayList<Bariq07171_DaftarPasienEntity> daftarPasienArrayList;

    public Bariq07171_DaftarPasienModel() {
        daftarPasienArrayList = new ArrayList<Bariq07171_DaftarPasienEntity>();
    }

    public void insertDataDaftarpasien(Bariq07171_DaftarPasienEntity daftarPasien) {
        daftarPasienArrayList.add(daftarPasien);
    }

    public ArrayList<Bariq07171_DaftarPasienEntity> allDataAntrian() {
        return daftarPasienArrayList;
    }

    public void deleteListPasien(int indexPasien) {
        daftarPasienArrayList.remove(indexPasien);
    }

    public String showNamePoli(int indexPoli) {
        return Bariq07171_PoliEntity.nama[indexPoli];
    }

    public void view(int IndexPoli) {
        int index = 0;
        for (Bariq07171_DaftarPasienEntity daftarPasien : daftarPasienArrayList) {
            if (daftarPasienArrayList.size() == 0) {
                System.out.println("Data Kosong !!!");
            } else {
                if (IndexPoli == daftarPasien.getIndexPoli()) {
                    System.out.println("===============================================================");
                    System.out.println("No : " + (index++)
                            + "\nNIK : " + daftarPasien.getPasien().getNik()
                            + "\nNama : " + daftarPasien.getPasien().getNama()
                            + "\nNo Telp : " + daftarPasien.getPasien().getNo_telp()
                            + "\nJenis Kelamin : " + daftarPasien.getPasien().getJeniskelamin()
                            + "\nAlamat : " + daftarPasien.getPasien().getAlamat()
                            + "\nPoli : " + Bariq07171_PoliEntity.nama[daftarPasien.getIndexPoli()]
                            + "\nTanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(daftarPasien.getPasien().getTgllahir()));
                    System.out.println("===============================================================");
                }
            }
        }
    }
}
