import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    Controller controller = new Controller();

    JScrollPane scrollPane;
    JTable table;
    JButton bAdd, bEdit, bDelete, bDeleteAll, bHasil;

    protected Object[][] data;

    public View(){
        setTitle("Pemilihan apartemen dengan metode SAW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1080,480);
        setLocationRelativeTo(null);
        setLayout(null);

        String[] column = {"Nama", "Lokasi", "Harga", "Jarak", "Luas", "Keamanan", "Kebersihan"};
        data = controller.data;
        table = new JTable(data,column);
        scrollPane = new JScrollPane(table);

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
        bHasil = new JButton("Hasil");

        bAdd.addActionListener(this);
        bEdit.addActionListener(this);
        bDeleteAll.addActionListener(this);
        bDelete.addActionListener(this);
        bHasil.addActionListener(this);

        add(scrollPane);
        add(bAdd);
        add(bEdit);
        add(bDelete);
        add(bDeleteAll);
        add(bHasil);

        scrollPane.setBounds(20,20,810,400);
        bAdd.setBounds(880,40,120,30);
        bEdit.setBounds(880,100,120,30);
        bDelete.setBounds(880,160,120,30);
        bDeleteAll.setBounds(880,220,120,30);
        bHasil.setBounds(880,280,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bAdd){
            setVisible(false);
            new Add();
        }
        if (actionEvent.getSource() == bEdit){
            setVisible(false);
            new Edit();
        }
        if (actionEvent.getSource() == bDelete){
            setVisible(false);
            new Delete();
        }
        if (actionEvent.getSource() == bDeleteAll){
            int p = JOptionPane.showConfirmDialog(null,"Yakin ingin menghapus semua data?","Delete All",JOptionPane.YES_NO_OPTION);
            switch (p) {
                case JOptionPane.YES_OPTION :
                    controller.Delete_all();
                    new View();
                    break;

                case JOptionPane.NO_OPTION :
                    break;
            }
        }
        if (actionEvent.getSource() == bHasil){
            controller.Hasil();
            new Hasil();
        }
    }
}
