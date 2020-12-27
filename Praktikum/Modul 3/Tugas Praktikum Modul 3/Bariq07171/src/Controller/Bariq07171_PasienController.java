package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entity.*;
import java.util.Date;

public class Bariq07171_PasienController {

    int indexLogin = 0;

    public Bariq07171_PasienController() {
    }

    public Bariq07171_PasienEntity pasienEntity() {
        return Bariq07171_AllObjectModel.pasienModel.getPasienArrayList(indexLogin);
    }

    public void dataPasien() {
        int nik[] = {01, 02, 03};
        String pass[] = {"01", "02", "03"};
        String nama[] = {"Bariq", "Qushoyyi", "Shobriy"};
        String no_telp[] = {"01", "02", "03"};
        String jeniskelamin[] = {"Perempuan", "Pria", "Perempuan"};
        String alamat[] = {"Kemayoran", "Dupak", "TP"};
        String tanggal[] = {"04/05/2000", "01/12/2000", "03/03/2000"};
        for (int i = 0; i < nik.length; i++) {
            Bariq07171_AllObjectModel.pasienModel.insertPasien(new Bariq07171_PasienEntity(pass[i], nama[i], no_telp[i], alamat[i], jeniskelamin[i], nik[i], new Date(tanggal[i])));
        };
    }

    public void login(int nik, String password) {
        indexLogin = Bariq07171_AllObjectModel.pasienModel.cekData(nik, password);
    }

    public void viewPasien() {
        Bariq07171_AllObjectModel.pasienModel.view();
    }

    public String showNamePoli(int indexPoli) {
        return Bariq07171_AllObjectModel.daftarPasienModel.showNamePoli(indexPoli);
    }

    public void postData(String password, String nama, String no_telp, String alamat, String jeniskelamin, int nik, Date tgllahir, String inAction) {
        if (inAction == "editPasien") {
            Bariq07171_AllObjectModel.pasienModel.updatePasien(indexLogin, new Bariq07171_PasienEntity(password, nama, no_telp, alamat, jeniskelamin, nik, tgllahir));
        } else if (inAction == "newPasien") {
            Bariq07171_AllObjectModel.pasienModel.insertPasien(new Bariq07171_PasienEntity(password, nama, no_telp, alamat, jeniskelamin, nik, tgllahir));
        }
    }

    public void registerAntrian(int indexPoli, Bariq07171_PasienEntity pasienEntity) {
        Bariq07171_AllObjectModel.daftarPasienModel.insertDataDaftarpasien(new Bariq07171_DaftarPasienEntity(pasienEntity, indexPoli));

    }
}
