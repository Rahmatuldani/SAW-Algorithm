import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    Controller controller;

    JScrollPane scrollPane, scrollPane1;
    JTable table, table1;
    JButton bAdd, bEdit, bDelete, bDeleteAll;

    Object[][] data, data1;

    public View(){
        setTitle("Pemilihan apartemen dengan metode SAW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1480,480);
        setLocationRelativeTo(null);
        setLayout(null);

        controller = new Controller();

        String[] column = {"Nama", "Lokasi", "Harga", "Jarak", "Luas", "Keamanan", "Kebersihan"};
        String[] column1 = {"Nama", "Prioritas"};
        data = new Object[50][8];
        data1 = new Object[50][2];
        data = controller.getData();
        data1 = controller.getData1();
        table = new JTable(data,column);
        table1 = new JTable(data1,column1);
        scrollPane = new JScrollPane(table);
        scrollPane1 = new JScrollPane(table1);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(180);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);

        bAdd = new JButton("Tambah");
        bEdit = new JButton("Edit");
        bDelete = new JButton("Hapus");
        bDeleteAll = new JButton("Hapus Semua");

        bAdd.addActionListener(this);
        bEdit.addActionListener(this);
        bDeleteAll.addActionListener(this);
        bDelete.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.add(bAdd);
        panel.add(bEdit);
        panel.add(bDelete);
        panel.add(bDeleteAll);

        add(scrollPane);
        add(panel);
        add(scrollPane1);

        scrollPane.setBounds(20,20,810,400);
        panel.setBounds(880,100,150,200);
        scrollPane1.setBounds(1100,20,350,400);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bAdd){
            new
        }
        if (actionEvent.getSource() == bEdit){
        }
        if (actionEvent.getSource() == bDelete){
        }
        if (actionEvent.getSource() == bDeleteAll){
        }
    }
}
