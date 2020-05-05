public class Controller {
    Model model;
    protected Object[][] data, data1;

    public Controller(){
        model = new Model();
        this.data = model.data;
        this.data1 = model.data1;
    }

    public Object[][] getData() {
        this.data = model.getData();
        return data;
    }

    public Object[][] getData1() {
        this.data1 = model.getData1();
        return data1;
    }

    public void addData(){

    }
}
