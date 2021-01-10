/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Bariq07171_AllView {

    JFrame LogReg = new JFrame();
    JLabel login, register, title;
    JRadioButton radiopasien, radiodokter;
    JTextField textnik, textnama, textnotelp, texttgllahir,
            textalamat, textjeniskelamin, textniklogin;
    JLabel labelniklogin, labelnama, labelnikregister, labelnotelp, labeltgllahir,
            labelalamat, labeljeniskelamin, labelpasswordlogin, labelpasswordregister;
    JButton loginUser, registerPasien;
    JPasswordField passwordlogin, passwordregister;
    private boolean ceklogin = false;

    public Bariq07171_AllView() {
        LogReg.setSize(700, 630);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.MAGENTA);
        title = new JLabel("Selamat Datang Di Puskesmas ABCD");
        title.setBounds(100, 10, 600, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(title);

        login = new JLabel("Login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(login);

        radiopasien = new JRadioButton("Pasien");
        radiopasien.setBounds(30, 150, 100, 30);
        radiopasien.setBackground(Color.CYAN);
        LogReg.add(radiopasien);

        radiodokter = new JRadioButton("Dokter");
        radiodokter.setBounds(140, 150, 100, 30);
        radiodokter.setBackground(Color.CYAN);
        LogReg.add(radiodokter);

        labelniklogin = new JLabel("NIK");
        labelniklogin.setBounds(30, 180, 30, 30);
        LogReg.add(labelniklogin);

        textniklogin = new JTextField();
        textniklogin.setBounds(30, 210, 200, 30);
        LogReg.add(textniklogin);

        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(30, 240, 100, 30);
        LogReg.add(labelpasswordlogin);

        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 270, 200, 30);
        LogReg.add(passwordlogin);

        loginUser = new JButton("Login");
        loginUser.setBounds(90, 320, 100, 40);
        loginUser.setBackground(Color.GREEN);
        LogReg.add(loginUser);

        register = new JLabel("Registrasi Pasien");
        register.setFont(new Font("Times New Roman", Font.BOLD, 20));
        register.setBounds(440, 40, 150, 100);
        LogReg.add(register);

        labelnikregister = new JLabel("NIK");
        labelnikregister.setBounds(400, 100, 30, 30);
        LogReg.add(labelnikregister);

        textnik = new JTextField();
        textnik.setBounds(400, 130, 200, 30);
        LogReg.add(textnik);

        labelnama = new JLabel("Nama");
        labelnama.setBounds(400, 160, 100, 30);
        LogReg.add(labelnama);

        textnama = new JTextField();
        textnama.setBounds(400, 190, 200, 30);
        LogReg.add(textnama);

        labelpasswordregister = new JLabel("Password");
        labelpasswordregister.setBounds(400, 220, 100, 30);
        LogReg.add(labelpasswordregister);

        passwordregister = new JPasswordField();
        passwordregister.setBounds(400, 250, 200, 30);
        LogReg.add(passwordregister);

        labelnotelp = new JLabel("No Telepon");
        labelnotelp.setBounds(400, 280, 100, 30);
        LogReg.add(labelnotelp);

        textnotelp = new JTextField();
        textnotelp.setBounds(400, 310, 200, 30);
        LogReg.add(textnotelp);

        labeltgllahir = new JLabel("Tanggal Lahir (dd/mm/yyyy)");
        labeltgllahir.setBounds(400, 340, 200, 30);
        LogReg.add(labeltgllahir);

        texttgllahir = new JTextField();
        texttgllahir.setBounds(400, 370, 200, 30);
        LogReg.add(texttgllahir);

        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(400, 400, 200, 30);
        LogReg.add(labelalamat);

        textalamat = new JTextField();
        textalamat.setBounds(400, 430, 200, 30);
        LogReg.add(textalamat);

        labeljeniskelamin = new JLabel("Jenis Kelamin");
        labeljeniskelamin.setBounds(400, 460, 200, 30);
        LogReg.add(labeljeniskelamin);

        textjeniskelamin = new JTextField();
        textjeniskelamin.setBounds(400, 490, 200, 30);
        LogReg.add(textjeniskelamin);

        registerPasien = new JButton("Daftar");
        registerPasien.setBounds(460, 530, 100, 40);
        registerPasien.setBackground(Color.GREEN);
        LogReg.add(registerPasien);

        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);
        radiodokter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiodokter.isSelected()) {
                    radiopasien.setSelected(false);
                    ceklogin = true;
                }
            }
        });

        radiopasien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiopasien.isSelected()) {
                    radiodokter.setSelected(false);
                    ceklogin = false;
                }
            }
        });

        loginUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int parseNIk = Integer.parseInt(textniklogin.getText());
                if (ceklogin == true) {
                    try {
                        Bariq07171_AllObjController.dokter.dataDokter();
                        Bariq07171_AllObjController.dokter.login(parseNIk, passwordlogin.getText());
                        String nama = Bariq07171_AllObjController.dokter.dokterEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        Bariq07171_DokterView viewDokter = new Bariq07171_DokterView();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "NIK atau Password Salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                } else {
                    try {
                        Bariq07171_AllObjController.pasien.dataPasien();
                        Bariq07171_AllObjController.pasien.login(parseNIk, passwordlogin.getText());
                        String nama = Bariq07171_AllObjController.pasien.pasienEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        Bariq07171_PasienView viewPasien = new Bariq07171_PasienView();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "NIK atau Password Salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }
        });

        registerPasien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int nik = Integer.parseInt(textnik.getText());
                    String nama = textnama.getText();
                    String pass = passwordregister.getText();
                    String notelp = textnotelp.getText();
                    Date tgllahir = new Date(texttgllahir.getText());
                    String alamat = textalamat.getText();
                    String jeniskelamin = textjeniskelamin.getText();
                    Bariq07171_AllObjController.pasien.postData(pass, nama, notelp, alamat, jeniskelamin, nik, tgllahir, "newPasien");
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });
    }

    void kosong() {
        textniklogin.setText(null);
        passwordlogin.setText(null);
        textnik.setText(null);
        textnama.setText(null);
        passwordregister.setText(null);
        textnotelp.setText(null);
        texttgllahir.setText(null);
        textalamat.setText(null);
        textjeniskelamin.setText(null);
    }

}
