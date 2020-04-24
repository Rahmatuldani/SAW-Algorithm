public class Controller {
    Model model = new Model();
    private Object[][] data, data1;

    public Controller(){
        model = new Model();
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
