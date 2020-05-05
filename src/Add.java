import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame implements ActionListener {
    Controller controller;

    JLabel lnama, llokasi, lharga, ljarak, lluas, lkeamanan, lkebersihan;
    JTextField fnama, flokasi, fharga, fjarak, fluas, fkeamanan, fkebersihan;
    JButton bAdd, bCancel;

    Object[][] data = new Object[50][8];

    public Add(){
        setTitle("Simpan data");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(420,420);
        setLayout(null);
        setLocationRelativeTo(null);
        controller = new Controller();

        lnama = new JLabel("Nama ");
        llokasi = new JLabel("Lokasi");
        lharga = new JLabel("Harga");
        ljarak = new JLabel("Jarak");
        lluas = new JLabel("Luas");
        lkeamanan = new JLabel("Keamanan");
        lkebersihan = new JLabel("Kebersihan");

        bAdd = new JButton("Simpan");
        bCancel = new JButton("Cancel");
        bAdd.addActionListener(this);
        bCancel.addActionListener(this);

        fnama = new JTextField(120);
        flokasi = new JTextField(120);
        fharga = new JTextField(120);
        fjarak = new JTextField(120);
        fluas = new JTextField(120);
        fkeamanan = new JTextField(120);
        fkebersihan = new JTextField(120);

        add(lnama);
        add(fnama);
        add(llokasi);
        add(flokasi);
        add(lharga);
        add(fharga);
        add(ljarak);
        add(fjarak);
        add(lluas);
        add(fluas);
        add(lkeamanan);
        add(fkeamanan);
        add(lkebersihan);
        add(fkebersihan);
        add(bAdd);
        add(bCancel);

        lnama.setBounds(20,20,120,30);
        fnama.setBounds(140,20,230,30);
        llokasi.setBounds(20,60,120,30);
        flokasi.setBounds(140,60,230,30);
        lharga.setBounds(20,100,120,30);
        fharga.setBounds(140,100,230,30);
        ljarak.setBounds(20,140,120,30);
        fjarak.setBounds(140,140,80,30);
        lluas.setBounds(20,180,120,30);
        fluas.setBounds(140,180,80,30);
        lkeamanan.setBounds(20,220,120,30);
        fkeamanan.setBounds(140,220,80,30);
        lkebersihan.setBounds(20,260,120,30);
        fkebersihan.setBounds(140,260,80,30);
        bAdd.setBounds(110,320,80,30);
        bCancel.setBounds(210,320,80,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bAdd){
            setVisible(false);
            new View();
        }
        if (actionEvent.getSource() == bCancel){
            setVisible(false);
            new View();
        }
    }
}
