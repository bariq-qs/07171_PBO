/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Bariq07171_PoliEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Bariq07171_PasienView {

    JFrame Pasien = new JFrame();
    JLabel titleforedit, labelnik, labelnama, labelpassword, labelnotelp,
            labeltgllahir, labelalamat, labeljeniskelamin, labelregpoli;
    JTextField textnik, textnama, textnotelp, texttgllahir,
            textalamat, textjeniskelamin;
    JPasswordField textpassword;
    JButton EditPasien, Antri, Back;
    JComboBox pilihpoli = new JComboBox(Bariq07171_PoliEntity.nama);

    public Bariq07171_PasienView() {
        Pasien.setSize(720, 600);
        Pasien.setLayout(null);
        Pasien.getContentPane().setBackground(Color.cyan);

        titleforedit = new JLabel("Data Pasien");
        titleforedit.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleforedit.setBounds(60, 30, 200, 30);
        Pasien.add(titleforedit);

        labelnik = new JLabel("NIK");
        labelnik.setBounds(30, 70, 100, 30);
        Pasien.add(labelnik);

        textnik = new JTextField(Integer.toString(Bariq07171_AllObjController.pasien.pasienEntity().getNik()));
        textnik.setBounds(30, 100, 250, 30);
        textnik.setEditable(false);
        Pasien.add(textnik);

        labelnama = new JLabel("Nama");
        labelnama.setBounds(30, 130, 100, 30);
        Pasien.add(labelnama);

        textnama = new JTextField(Bariq07171_AllObjController.pasien.pasienEntity().getNama());
        textnama.setBounds(30, 160, 250, 30);
        Pasien.add(textnama);

        labelpassword = new JLabel("Password");
        labelpassword.setBounds(30, 190, 100, 30);
        Pasien.add(labelpassword);

        textpassword = new JPasswordField(Bariq07171_AllObjController.pasien.pasienEntity().getPassword());
        textpassword.setBounds(30, 220, 250, 30);
        Pasien.add(textpassword);

        labelnotelp = new JLabel("No Telp");
        labelnotelp.setBounds(30, 250, 100, 30);
        Pasien.add(labelnotelp);

        textnotelp = new JTextField(Bariq07171_AllObjController.pasien.pasienEntity().getNo_telp());
        textnotelp.setBounds(30, 280, 250, 30);
        Pasien.add(textnotelp);

        labeltgllahir = new JLabel("Tanggal Lahir (dd/mm/yyyy)");
        labeltgllahir.setBounds(30, 310, 200, 30);
        Pasien.add(labeltgllahir);

        texttgllahir = new JTextField(new SimpleDateFormat("dd/MM/YYYY")
                .format(Bariq07171_AllObjController.pasien.pasienEntity().getTgllahir()));
        texttgllahir.setBounds(30, 340, 250, 30);
        Pasien.add(texttgllahir);

        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(30, 370, 100, 30);
        Pasien.add(labelalamat);

        textalamat = new JTextField(Bariq07171_AllObjController.pasien.pasienEntity().getAlamat());
        textalamat.setBounds(30, 400, 250, 30);
        Pasien.add(textalamat);

        labeljeniskelamin = new JLabel("Jenis Kelamin");
        labeljeniskelamin.setBounds(30, 430, 100, 30);
        Pasien.add(labeljeniskelamin);

        textjeniskelamin = new JTextField(Bariq07171_AllObjController.pasien.pasienEntity().getJeniskelamin());
        textjeniskelamin.setBounds(30, 460, 250, 30);
        Pasien.add(textjeniskelamin);

        labelregpoli = new JLabel("Pendaftaran Antrian");
        labelregpoli.setBounds(425, 30, 500, 30);
        labelregpoli.setFont(new Font("Times New Roman", Font.BOLD, 30));

        Pasien.add(labelregpoli);
        pilihpoli.setBounds(435, 90, 250, 30);
        Pasien.add(pilihpoli);

        Antri = new JButton("Daftar Antrian");
        Antri.setBounds(500, 200, 100, 30);
        Antri.setBackground(Color.GREEN);
        Pasien.add(Antri);

        EditPasien = new JButton("Edit Data");
        EditPasien.setBounds(100, 500, 100, 30);
        EditPasien.setBackground(Color.GREEN);
        Pasien.add(EditPasien);

        Back = new JButton("Back");
        Back.setBounds(320, 500, 100, 30);
        Back.setBackground(Color.RED);
        Pasien.add(Back);

        Pasien.setVisible(true);
        Pasien.setLocationRelativeTo(null);
        Pasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EditPasien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int nik = Integer.parseInt(textnik.getText());
                    String nama = textnama.getText();
                    String pass = textpassword.getText();
                    String notelp = textnotelp.getText();
                    Date tgllahir = new Date(texttgllahir.getText());
                    String alamat = textalamat.getText();
                    String jeniskelamin = textjeniskelamin.getText();
                    Bariq07171_AllObjController.pasien.postData(pass, nama, notelp, alamat, jeniskelamin, nik, tgllahir, "editPasien");
                    JOptionPane.showMessageDialog(null, "Update Data Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Update Data Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pasien.dispose();
                Bariq07171_AllView AllView = new Bariq07171_AllView();
            }
        });

        Antri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexpoli = pilihpoli.getSelectedIndex();
                try {
                    Bariq07171_AllObjController.pasien.registerAntrian(indexpoli,
                            Bariq07171_AllObjController.pasien.pasienEntity());
                    System.out.println("Anda Sudah Terdaftar Di Poli = "
                            + Bariq07171_AllObjController.pasien.showNamePoli(indexpoli));
                    JOptionPane.showMessageDialog(null, "Anda Sudah Terdaftar Di Poli = "
                            + Bariq07171_AllObjController.pasien.showNamePoli(indexpoli),
                            "Pendaftaran Berhasil", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Poli Yang Anda Daftarkan Tidak Ada", 
                            "Pendaftaran Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

}
