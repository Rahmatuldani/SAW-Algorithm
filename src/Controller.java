import javax.swing.*;

public class Controller {
    Model model = new Model();
    protected Object[][] data = new Object[50][8];
    protected Object[][] data1 = new Object[50][8];
    protected Object[][] cari = new Object[50][8];

    public Controller(){
        getData();
        getData1();
    }

    public Object[][] getData() {
        this.data = model.data;
        return data;
    }

    public Object[][] getData1() {
        this.data1 = model.data1;
        return data1;
    }

    public void Simpan(Object[][] data){
        model.Simpan(data);
    }

    public void Cari(String nama){
        model.Cari(nama);
        cari = model.cari;
    }

    public void Update(Object[][] data){
        model.Update(data);
    }

    public void Delete(String nama){
        model.Delete(nama);
    }

    public void Delete_all(){
        model.Delete_all();
    }

    public void Delete_all1(){
        model.Delete_all1();
    }

    public void Hasil(){
        model.Hasil();
    }
}
