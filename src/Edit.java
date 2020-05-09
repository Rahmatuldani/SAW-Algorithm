import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends JFrame implements ActionListener {
    Controller controller = new Controller();

    JLabel lnama, llokasi, lharga, ljarak, lluas, lkeamanan, lkebersihan;
    JTextField fnama, flokasi, fharga, fjarak, fluas, fkeamanan, fkebersihan;
    JButton bAdd, bCancel, bCari;

    Object[][] data = new Object[50][8];

    public Edit(){
        setTitle("Edit data");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(420,480);
        setLayout(null);
        setLocationRelativeTo(null);

        lnama = new JLabel("Nama ");
        llokasi = new JLabel("Lokasi");
        lharga = new JLabel("Harga");
        ljarak = new JLabel("Jarak (m)");
        lluas = new JLabel("Luas (m2)");
        lkeamanan = new JLabel("Keamanan (1-10)");
        lkebersihan = new JLabel("Kebersihan (1-10)");

        bAdd = new JButton("Edit");
        bCancel = new JButton("Cancel");
        bCari = new JButton("Cari");
        bAdd.addActionListener(this);
        bCancel.addActionListener(this);
        bCari.addActionListener(this);

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
        add(bCari);

        lnama.setBounds(20,20,120,30);
        fnama.setBounds(140,20,230,30);
        llokasi.setBounds(20,130,120,30);
        flokasi.setBounds(140,130,230,30);
        lharga.setBounds(20,170,120,30);
        fharga.setBounds(140,170,230,30);
        ljarak.setBounds(20,210,120,30);
        fjarak.setBounds(140,210,80,30);
        lluas.setBounds(20,250,120,30);
        fluas.setBounds(140,250,80,30);
        lkeamanan.setBounds(20,290,120,30);
        fkeamanan.setBounds(140,290,80,30);
        lkebersihan.setBounds(20,330,120,30);
        fkebersihan.setBounds(140,330,80,30);
        bAdd.setBounds(110,390,80,30);
        bCancel.setBounds(210,390,80,30);
        bCari.setBounds(200,70,80,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bCari){
            controller.Cari(fnama.getText());
            data = controller.cari;

            flokasi.setText(String.valueOf(data[0][1]));
            fharga.setText(String.valueOf(data[0][2]));
            fjarak.setText(String.valueOf(data[0][3]));
            fluas.setText(String.valueOf(data[0][4]));
            fkeamanan.setText(String.valueOf(data[0][5]));
            fkebersihan.setText(String.valueOf(data[0][6]));
        }
        if (actionEvent.getSource() == bAdd){
            data[0][0] = fnama.getText();
            data[0][1] = flokasi.getText();
            data[0][2] = Integer.parseInt(fharga.getText());
            data[0][3] = Integer.parseInt(fjarak.getText());
            data[0][4] = Integer.parseInt(fluas.getText());
            data[0][5] = Integer.parseInt(fkeamanan.getText());
            data[0][6] = Integer.parseInt(fkebersihan.getText());
            controller.Update(data);
            setVisible(false);
            new View();
        }
        if (actionEvent.getSource() == bCancel){
            setVisible(false);
            new View();
        }
    }
}
