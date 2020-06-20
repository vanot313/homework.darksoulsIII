package dao;

public class CardPropertiesDao {
    private int Property1;
    private int Property2;
    private int Property3;
    private int Property4;
    private int Property5;
    private int Property6;
    private int Property7;
    private int Property8;
    private int sum;
    private final String[] standard = {"普通","普通","稀有","卓越","史诗","史诗","神话","神话","传说"};

    public int getProperty1() {
        return Property1;
    }

    public int getProperty2() {
        return Property2;
    }

    public int getProperty3() {
        return Property3;
    }

    public int getProperty4() {
        return Property4;
    }

    public int getProperty5() {
        return Property5;
    }

    public int getProperty6() {
        return Property6;
    }

    public int getProperty7() {
        return Property7;
    }

    public int getProperty8() {
        return Property8;
    }

    public void setProperty1(int property1) {
        Property1 = property1;
    }

    public void setProperty2(int property2) {
        Property2 = property2;
    }

    public void setProperty3(int property3) {
        Property3 = property3;
    }

    public void setProperty4(int property4) {
        Property4 = property4;
    }

    public void setProperty5(int property5) {
        Property5 = property5;
    }

    public void setProperty6(int property6) {
        Property6 = property6;
    }

    public void setProperty7(int property7) {
        Property7 = property7;
    }

    public void setProperty8(int property8) {
        Property8 = property8;
    }

    public String[] getStandard() {
        return standard;
    }

    public int getSum() {
            return this.getProperty1()+this.getProperty2()+this.getProperty3()+this.getProperty4()
                +this.getProperty5()+this.getProperty6()+this.getProperty7()+this.getProperty8();
    }
}
