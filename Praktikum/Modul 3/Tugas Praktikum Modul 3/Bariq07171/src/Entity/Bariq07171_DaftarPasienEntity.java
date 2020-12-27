/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Bariq Qushoyyi
 */
public class Bariq07171_DaftarPasienEntity {

    private Bariq07171_PasienEntity pasien;
    private int Poli;

    public Bariq07171_DaftarPasienEntity(Bariq07171_PasienEntity pasien, int Poli) {
        this.pasien = pasien;
        this.Poli = Poli;
    }

    public void setPasien(Bariq07171_PasienEntity pasien) {
        this.pasien = pasien;
    }

    public Bariq07171_PasienEntity getPasien() {
        return pasien;
    }

    public int getIndexPoli() {
        return Poli;
    }

    public void setIndexPoli(int Poli) {
        this.Poli = Poli;
    }
   
}
