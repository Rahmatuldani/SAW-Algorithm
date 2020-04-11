package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vUtama extends JFrame implements ActionListener {
    String[] column = {"No","Nama Apartemen", "Harga", "Luas", "Jarak", "Keamanan", "Kebersihan", "Transportasi"};
    Object[][] data = new Object[30][8];
    JTable table = new JTable(data,column);
    JScrollPane scrollPane = new JScrollPane(table);
    JPanel panel = new JPanel();

    JButton add = new JButton("Tambah");
    JButton delete = new JButton("Hapus");
    JButton accept = new JButton("Analisa");

    String[] column1 = {"Nama Apartemen", "Prioritas"};
    String[][] data1 = new String[30][2];
    JTable table1 = new JTable(data1,column1);
    JScrollPane scrollPane1 = new JScrollPane(table1);

    public void isi(String nama, int harga, int luas, int jarak, int keamanan, int kebersihan, int transportasi){
        for (int i = 0; i < 30; i++){
            if (data[i][1] == null){
                data[i][0] = i+1;
                data[i][1] = nama;
                data[i][2] = harga;
                data[i][3] = luas;
                data[i][4] = jarak;
                data[i][5] = keamanan;
                data[i][6] = kebersihan;
                data[i][7] = transportasi;
            }
        }
        JOptionPane.showMessageDialog(null,data[0][0],"isi",JOptionPane.INFORMATION_MESSAGE);
    }

    public vUtama() {
        setTitle("SPK memilih apartement dekat tempat kerja");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1420,450);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        add.addActionListener(this);
        delete.addActionListener(this);
        accept.addActionListener(this);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(220);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);

        panel.add(add);
        panel.add(delete);
        panel.add(accept);

        add(scrollPane,"West");
        add(panel,"Center");
        add(scrollPane1,"East");

        scrollPane.setBounds(5,5,865,400);
        panel.setBounds(930,100,100,200);
        scrollPane1.setBounds(1100,5,300,400);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == add){
            new vAdd();
        }
        if (actionEvent.getSource() == delete) {

        }
        if (actionEvent.getSource() == accept){

        }
    }
}
