package enums;

public enum Properties {
    huo("火",1),lei("雷",2),an("暗",3),bing("冰",4),
    hundun("混沌",5),houzhong("厚重",6),fengli("锋利",7),xingyun("幸运",8);

    private final String type;
    private final int index;

    Properties(String type, int index){
        this.type = type;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }

    public static String getType(int index) {
        for(Properties p : Properties.values()){
            if(p.getIndex() == index){
                return p.getType();
            }
        }
        return null;
    }
}
