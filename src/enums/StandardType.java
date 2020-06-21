package enums;

public enum StandardType {
    putong("普通",1),xiyou("稀有",2),zhuoyue("卓越",3),
    shishi("史诗",4),shenhua("神话",5),chuanshuo("传说",6);

    private final String type;
    private final int index;

    StandardType(String standard, int index){
        this.type = standard;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }

    public static String getType(int index) {
        for(StandardType p : StandardType.values()){
            if(p.getIndex() == index){
                return p.getType();
            }
        }
        return null;
    }

}
