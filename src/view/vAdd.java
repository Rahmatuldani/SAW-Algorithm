package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vAdd extends JFrame implements ActionListener {
    JLabel lnama = new JLabel("Nama Apartemen");
    JLabel lharga = new JLabel("Harga");
    JLabel lluas = new JLabel("Luas (meter kubik)");
    JLabel ljarak = new JLabel("Jarak (meter)");
    JLabel lkeamanan = new JLabel("Keamanan (point)");
    JLabel lkebersihan = new JLabel("Kebersihan (point)");
    JLabel ltransportasi = new JLabel("Transportasi (point)");

    JTextField fnama = new JTextField(100);
    JTextField fharga = new JTextField(100);
    JTextField fluas = new JTextField(100);
    JTextField fjarak = new JTextField(100);
    JTextField fkeamanan = new JTextField(100);
    JTextField fkebersihan = new JTextField(100);
    JTextField ftransportasi = new JTextField(100);

    JButton add = new JButton("Tambah");
    JButton cancel = new JButton("Batal");

    public vAdd(){
        setTitle("Tambah data apartemen");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(385,350);
        setLayout(null);

        add.addActionListener(this);
        cancel.addActionListener(this);

        add(lnama);add(fnama);
        add(lharga);add(fharga);
        add(lluas);add(fluas);
        add(ljarak);add(fjarak);
        add(lkeamanan);add(fkeamanan);
        add(lkebersihan);add(fkebersihan);
        add(ltransportasi);add(ftransportasi);
        add(add);add(cancel);

        lnama.setBounds(10,20,160,20);
        fnama.setBounds(160,20,200,20);
        lharga.setBounds(10,50,160,20);
        fharga.setBounds(160,50,200,20);
        lluas.setBounds(10,80,160,20);
        fluas.setBounds(160,80,80,20);
        ljarak.setBounds(10,110,160,20);
        fjarak.setBounds(160,110,80,20);
        lkeamanan.setBounds(10,140,160,20);
        fkeamanan.setBounds(160,140,80,20);
        lkebersihan.setBounds(10,170,160,20);
        fkebersihan.setBounds(160,170,80,20);
        ltransportasi.setBounds(10,200,160,20);
        ftransportasi.setBounds(160,200,80,20);
        add.setBounds(30,250,140,30);
        cancel.setBounds(200,250,140,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == add){
            vUtama isi = new vUtama();
            isi.isi(fnama.getText(),Integer.parseInt(fharga.getText()),Integer.parseInt(fluas.getText()),Integer.parseInt(fjarak.getText()),
                    Integer.parseInt(fkeamanan.getText()),Integer.parseInt(fkebersihan.getText()),Integer.parseInt(ftransportasi.getText()));
            setVisible(false);
        }
        if (actionEvent.getSource() == cancel){
            setVisible(false);
        }
    }
}
