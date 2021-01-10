package Entity;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bariq Qushoyyi
 */
public class Bariq07171_PasienEntity extends Bariq07171_WargaAbstractEntity{

    public Bariq07171_PasienEntity(String password, String nama, String no_telp, 
            String alamat, String jeniskelamin, int nik, Date tgllahir) {
        super(password, nama, no_telp, alamat, jeniskelamin, nik, tgllahir);
    }
}
