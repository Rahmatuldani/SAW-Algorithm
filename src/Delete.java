import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame implements ActionListener {
    Controller controller;

    JLabel lnama;
    JTextField fnama;
    JButton bDelete, bCancel;

    public Delete(){
        setTitle("Hapus data");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(420,160);
        setLayout(null);
        setLocationRelativeTo(null);
        controller = new Controller();

        lnama = new JLabel("Nama");
        fnama = new JTextField(120);
        bDelete = new JButton("Delete");
        bCancel = new JButton("Cancel");
        bDelete.addActionListener(this);
        bCancel.addActionListener(this);

        add(lnama);
        add(fnama);
        add(bDelete);
        add(bCancel);

        lnama.setBounds(20,20,120,30);
        fnama.setBounds(140,20,230,30);
        bDelete.setBounds(110,70,80,30);
        bCancel.setBounds(210,70,80,30);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bDelete){
            setVisible(false);
            new View();
        }
        if (actionEvent.getSource() == bCancel){
            setVisible(false);
            new View();
        }
    }
}
