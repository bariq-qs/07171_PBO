/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Entity.Bariq07171_DokterEntity;
import Entity.Bariq07171_PoliEntity;

/**
 *
 * @author Bariq Qushoyyi
 */
public class Bariq07171_DokterModel implements Bariq07171_ModelInterfaces {

    private ArrayList<Bariq07171_DokterEntity> DokterArrayList;

    public Bariq07171_DokterModel() {
        DokterArrayList = new ArrayList<Bariq07171_DokterEntity>();
    }

    public void insertDokter(Bariq07171_DokterEntity dokter) {
        DokterArrayList.add(dokter);
    }

    @Override
    public void view() {
        for (Bariq07171_DokterEntity dokter : DokterArrayList) {
            System.out.println("========================================================");
            System.out.println("NIK : " + dokter.getNik());
            System.out.println("NAMA : " + dokter.getNama());
            System.out.println("No Telephone : " + dokter.getNo_telp());
            System.out.println("Jenis Kelamin : " + dokter.getJeniskelamin());
            System.out.println("Tanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(dokter.getTgllahir()));
            System.out.println("Alamat : " + dokter.getAlamat());
            System.out.println("========================================================");
            System.out.println();
        }
    }

    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        for (Bariq07171_DokterEntity dokterEntity : DokterArrayList) {
            if (dokterEntity.getNik() == nik && dokterEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }

    public Bariq07171_DokterEntity showDataDokter(int index) {
        return DokterArrayList.get(index);
    }

    public String showPoliDokter(int indexPoli) {
        return Bariq07171_PoliEntity.nama[indexPoli];
    }
}
