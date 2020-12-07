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
    private boolean isRegistered;
    private int indexPoli;

    public Bariq07171_DaftarPasienEntity(Bariq07171_PasienEntity pasien, boolean isRegistered, int indexPoli) {
        this.pasien = pasien;
        this.isRegistered = isRegistered;
        this.indexPoli = indexPoli;
    }

    public void setPasien(Bariq07171_PasienEntity pasien) {
        this.pasien = pasien;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public void setIndexPoli(int indexPoli) {
        this.indexPoli = indexPoli;
    }

    public Bariq07171_PasienEntity getPasien() {
        return pasien;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public int getIndexPoli() {
        return indexPoli;
    }

}
