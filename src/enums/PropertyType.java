package enums;

public enum PropertyType {
    good("优异",1),normal("普通",0);

    private String type;
    private int index;

    public static String getType(int index){
        for(PropertyType p : PropertyType.values()){
            if(p.getIndex() == index){
                return p.getType();
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    PropertyType(String type, int index){
        this.type = type;
        this.index = index;
    }

    public String getType() {
        return type;
    }
}
