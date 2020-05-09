import javax.swing.*;
import java.sql.*;

public class Model {
    Connection connection;
    ResultSet resultSet;
    Statement statement;

    protected Object[][] data = new Object[50][8];
    protected Object[][] data1 = new Object[50][3];
    protected Object[][] cari = new Object[50][8];
    protected Object[][] proses = new Object[50][8];
    protected Double[][] minmax = new Double[1][5];
    protected Double[][] nilai = new Double[50][8];
    protected Double hasil;

    public Model(){
        getData();
        getData1();
        minmax[0][0] = 999999999.0;
        minmax[0][1] = 10000.0;
        minmax[0][2] = 0.0;
        minmax[0][3] = 0.0;
        minmax[0][4] = 0.0;
    }

    public Object[][] getData() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from datas");
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString("nama");
                data[p][1] = resultSet.getString("lokasi");
                data[p][2] = resultSet.getString("harga");
                data[p][3] = resultSet.getString("jarak");
                data[p][4] = resultSet.getString("luas");
                data[p][5] = resultSet.getString("keamanan");
                data[p][6] = resultSet.getString("kebersihan");
                p++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }

    public Object[][] getData1() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from datas1 ORDER BY prioritas DESC ");
            int p = 0;
            while (resultSet.next()){
                data1[p][0] = resultSet.getString("nama");
                data1[p][1] = resultSet.getString("prioritas");
                p++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return data1;
    }

    public void Simpan(Object[][] data){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO datas VALUES('"+ data[0][0] +"','"+ data[0][1] +"',"+ data[0][2] +","+ data[0][3] +","+ data[0][4] +","+ data[0][5] +","+ data[0][6] +")");
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Cari(String nama){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from datas WHERE nama = '"+ nama +"'");
            int p = 0;
            while (resultSet.next()){
                cari[p][0] = resultSet.getString("nama");
                cari[p][1] = resultSet.getString("lokasi");
                cari[p][2] = resultSet.getString("harga");
                cari[p][3] = resultSet.getString("jarak");
                cari[p][4] = resultSet.getString("luas");
                cari[p][5] = resultSet.getString("keamanan");
                cari[p][6] = resultSet.getString("kebersihan");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Update(Object[][] data){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE datas SET lokasi = '"+ data[0][1] +"',harga = "+ data[0][2] +",jarak = "+ data[0][3] +",luas = "+ data[0][4] +",keamanan = "+ data[0][5] +",kebersihan = "+ data[0][5] +" WHERE nama = '"+ data[0][0] +"'");
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diedit", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Delete(String nama){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM datas WHERE nama = '"+ nama +"'");
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Delete_all(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM datas");
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Delete_all1(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM datas1");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Hasil(){
        int p = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from datas");
            while (resultSet.next()){
                proses[p][0] = resultSet.getString("nama");
                proses[p][1] = resultSet.getString("harga");
                if (minmax[0][0] > Integer.parseInt((String) proses[p][1])){
                    minmax[0][0] = (double) Integer.parseInt((String) proses[p][1]);
                }
                proses[p][2] = resultSet.getString("jarak");
                if (minmax[0][1] > Integer.parseInt((String) proses[p][2])){
                    minmax[0][1] = (double) Integer.parseInt((String) proses[p][2]);
                }
                proses[p][3] = resultSet.getString("luas");
                if (minmax[0][2] < Integer.parseInt((String) proses[p][3])){
                    minmax[0][2] = (double) Integer.parseInt((String) proses[p][3]);
                }
                proses[p][4] = resultSet.getString("keamanan");
                if (minmax[0][3] < Integer.parseInt((String) proses[p][4])){
                    minmax[0][3] = (double) Integer.parseInt((String) proses[p][4]);
                }
                proses[p][5] = resultSet.getString("kebersihan");
                if (minmax[0][4] < Integer.parseInt((String) proses[p][5])){
                    minmax[0][4] = (double) Integer.parseInt((String) proses[p][5]);
                }
                p++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        for (int i = 0; i < p; i++) {
//            JOptionPane.showMessageDialog(null,Integer.parseInt((String)proses[i][1]), "proses", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(null,minmax[0][0]/Integer.parseInt((String) proses[i][1]), "Error", JOptionPane.ERROR_MESSAGE);
            nilai[i][0] = minmax[0][0] / Integer.parseInt((String) proses[i][1]);
            nilai[i][1] = minmax[0][1] / Integer.parseInt((String) proses[i][2]);
            nilai[i][2] = minmax[0][2] / Integer.parseInt((String) proses[i][3]);
            nilai[i][3] = minmax[0][3] / Integer.parseInt((String) proses[i][4]);
            nilai[i][4] = minmax[0][4] / Integer.parseInt((String) proses[i][5]);

            hasil = (nilai[i][0] * 0.3) + (nilai[i][1] * 0.3) + (nilai[i][2] * 0.2) + (nilai[i][3] * 0.1) + (nilai[i][4] * 0.1);

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/scpk","root","");
                statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO datas1 VALUES('"+ proses[i][0] +"',"+ hasil +")");
                statement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
