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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Bariq Qushoyyi
 */
public class Bariq07171_DokterView {

    JFrame Dokter = new JFrame();
    JTable tabelAntrianPasien = new JTable();
    JScrollPane scrooldokter = new JScrollPane(tabelAntrianPasien);
    JButton back;
    JLabel titleHeader;
    private int IndexPoli = Bariq07171_AllObjController.dokter.dokterEntity().getPoli();

    public Bariq07171_DokterView() {
        Dokter.setSize(650, 500);
        Dokter.setLayout(null);
        Dokter.getContentPane().setBackground(Color.PINK);
        titleHeader = new JLabel("List Antrian  Poli "
                + Bariq07171_AllObjController.dokter.showPoliDokter(IndexPoli));
        titleHeader.setBounds(100, 30, 500, 50);
        titleHeader.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Dokter.add(titleHeader);

        scrooldokter.setBounds(30, 100, 570, 200);
        tabelAntrianPasien.setModel(Bariq07171_AllObjController.pasien.antrianPasien(IndexPoli));
        Dokter.add(scrooldokter);

        back = new JButton("Back");
        back.setBounds(290, 400, 100, 30);
        back.setBackground(Color.red);
        Dokter.add(back);

        Dokter.setLocationRelativeTo(null);
        Dokter.setVisible(true);
        Dokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dokter.dispose();
                Bariq07171_AllView allView = new Bariq07171_AllView();
            }
        });

        tabelAntrianPasien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelAntrianPasien.getSelectedRow();
                int ok = JOptionPane.showConfirmDialog(null, "Yakin Mau Hapus Antrian Ke - " + i + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (ok == 0) {
                    Bariq07171_AllObjController.dokter.deleteListAntrianPasien(i);
                }
                tabelAntrianPasien.setModel(Bariq07171_AllObjController.pasien.antrianPasien(IndexPoli));
            }
        }
        );
    }

}
