package Controller;

import Entity.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class Bariq07171_PasienController {

    int indexLogin = 0;

    public Bariq07171_PasienController() {
    }

    public Bariq07171_PasienEntity pasienEntity() {
        return Bariq07171_AllObjectModel.pasienModel.getPasienArrayList(indexLogin);
    }

    public void dataPasien() {
        int nik[] = {123, 456, 789};
        String pass[] = {"123", "456", "789"};
        String nama[] = {"Bariq", "Qushoyyi", "Shobriy"};
        String no_telp[] = {"01", "02", "03"};
        String jeniskelamin[] = {"Perempuan", "Pria", "Perempuan"};
        String alamat[] = {"Kemayoran", "Dupak", "TP"};
        String tanggal[] = {"04/05/2000", "01/12/2000", "03/03/2000"};
        for (int i = 0; i < nik.length; i++) {
            Bariq07171_AllObjectModel.pasienModel.insertPasien(new Bariq07171_PasienEntity(pass[i],
                    nama[i], no_telp[i], alamat[i], jeniskelamin[i], nik[i], new Date(tanggal[i])));
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

    public void postData(String password, String nama, String no_telp,
            String alamat, String jeniskelamin, int nik, Date tgllahir, String inAction) {
        if (inAction == "editPasien") {
            Bariq07171_AllObjectModel.pasienModel.updatePasien(indexLogin,
                    new Bariq07171_PasienEntity(password, nama, no_telp, alamat,
                            jeniskelamin, nik, tgllahir));
        } else if (inAction == "newPasien") {
            Bariq07171_AllObjectModel.pasienModel.insertPasien(new Bariq07171_PasienEntity(password, nama, no_telp, alamat, jeniskelamin, nik, tgllahir));
        }
    }

    public void registerAntrian(int indexPoli, Bariq07171_PasienEntity pasienEntity) {
        Bariq07171_AllObjectModel.daftarPasienModel.insertDataDaftarpasien(new Bariq07171_DaftarPasienEntity(pasienEntity, indexPoli));
    }

    public DefaultTableModel antrianPasien(int IndexPoli) {
        DefaultTableModel tblAntrianPasien = new DefaultTableModel();
        Object[] kolom = {"NIK", "Nama", "No Telp", "Tgl Lahir", "Alamat", "Jenis Kelamin", "Poli"};
        tblAntrianPasien.setColumnIdentifiers(kolom);
        int size = Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().size();//.daftarprakModel.alldataprak().size();
        String verif = null;
        for (int i = 0; i < size; i++) {
//            if(indexRowTabel())
            if (IndexPoli == Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().get(i).getIndexPoli()) {
                Object[] data = new Object[7];
                data[0] = Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().get(i).getPasien().getNik();
                data[1] = Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().get(i).getPasien().getNama();
                data[2] = Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().get(i).getPasien().getNo_telp();
                data[3] = new SimpleDateFormat("dd-mm-yyy").format(Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().get(i).getPasien().getTgllahir());
                data[4] = Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().get(i).getPasien().getAlamat();
                data[5] = Bariq07171_AllObjectModel.daftarPasienModel.allDataAntrian().get(i).getPasien().getJeniskelamin();
                data[6] = Bariq07171_AllObjectModel.daftarPasienModel.showNamePoli(IndexPoli);
                tblAntrianPasien.addRow(data);
            }
        }
        return tblAntrianPasien;
    }
}
