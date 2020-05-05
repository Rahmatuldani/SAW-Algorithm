public class Model {
    protected Object[][] data, data1;

    public Model(){
        data = new Object[50][8];
        data1 = new Object[50][2];
        for (int i = 0; i < 8; i++) {
            data[0][i] = null;
        }

        for (int i = 0; i < 2; i++) {
            data1[0][i] = null;
        }
    }

    public Object[][] getData() {
        return data;
    }

    public Object[][] getData1() {
        return data1;
    }
}
