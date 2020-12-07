/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Bariq Qushoyyi
 */
public class Bariq07171_DokterEntity extends Bariq07171_WargaAbstractEntity {

    private String Poli;

    public Bariq07171_DokterEntity(String Poli, String password, String nama, String no_telp, String alamat, String jeniskelamin, int nik, Date tgllahir) {
        super(password, nama, no_telp, alamat, jeniskelamin, nik, tgllahir);
        this.Poli = Poli;
    }

    public String getPoli() {
        return Poli;
    }
    
    public void DokterEntity(String Poli){
        this.Poli = Poli;
    }
}
