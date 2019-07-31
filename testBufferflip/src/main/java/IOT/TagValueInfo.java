package IOT;

public class TagValueInfo {
    //每次独立取值的时候
    private String TagID;
    private String Value;
    private String CollectTime;
    private int Quality;

    public String getTagID() {
        return TagID;
    }

    public void setTagID(String tagID) {
        TagID = tagID;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getCollectTime() {
        return CollectTime;
    }

    public void setCollectTime(String collectTime) {
        CollectTime = collectTime;
    }

    public int getQuality() {
        return Quality;
    }

    public void setQuality(int quality) {
        Quality = quality;
    }

}
