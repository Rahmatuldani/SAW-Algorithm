import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hasil extends JFrame implements ActionListener {
    Controller controller = new Controller();

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
        kembali.addActionListener(this);

        String[] column = {"Nama", "Prioritas"};
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
            controller.Delete_all1();
            setVisible(false);
            new View();
        }
    }
}
