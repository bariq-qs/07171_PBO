package Entity;

import java.util.Date;
import java.util.Date;
public abstract class Bariq07171_WargaAbstractEntity {

    protected String password, nama, no_telp, alamat, jeniskelamin;
    protected int nik;
    protected Date tgllahir;

    public Bariq07171_WargaAbstractEntity(String password, String nama, String no_telp, String alamat, String jeniskelamin, int nik, Date tgllahir) {
        this.password = password;
        this.nama = nama;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.jeniskelamin = jeniskelamin;
        this.nik = nik;
        this.tgllahir = tgllahir;
    }

    public Bariq07171_WargaAbstractEntity() {
    }

    public int getNik(){
        return nik;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public Date getTgllahir() {
        return tgllahir;
    }
}
