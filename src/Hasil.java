import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hasil extends JFrame implements ActionListener {
    Controller controller;

    JScrollPane scrollPane;
    JTable table;
    JButton kembali = new JButton("Kembali");

    Object[][] data;

    public Hasil(){
        setTitle("Hasil pemilihan apartemen dengan metode SAW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(480,530);
        setLocationRelativeTo(null);
        setLayout(null);
        controller = new Controller();

        String[] column = {"Nama", "Prioritas"};
        data = new Object[50][2];
        data = controller.data1;
        table = new JTable(data,column);
        scrollPane = new JScrollPane(table);

        add(scrollPane);
        add(kembali);

        scrollPane.setBounds(20,20,420,400);
        kembali.setBounds(160,440,120,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == kembali){
            setVisible(false);
            new View();
        }
    }
}
