package enums;

public enum GenerationType {
    zero("第零代",0),one("第一代",1),two("第二代",2);

    private String type;
    private int index;

    public static String getType(int index){
        for(GenerationType p : GenerationType.values()){
            if(p.getIndex() == index){
                return p.getType();
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    GenerationType(String type, int index){
        this.type = type;
        this.index = index;
    }

    public String getType() {
        return type;
    }
}
