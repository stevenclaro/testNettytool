package IOT;

public class TagInfo {

    /**
     * AccessRight : 2
     * CollectType : 0
     * DataType : 1
     * MaxValue : 0
     * MinValue : 0
     * TagDesc :
     * TagID : 0100010001
     * TagLocation :
     * TagName : 运行状态
     * Unit :
     */

    private int AccessRight;
    private int CollectType;
    private int DataType;
    private int MaxValue;
    private int MinValue;
    private String TagDesc;
    private String TagID;
    private String TagLocation;
    private String TagName;
    private String Unit;


    public int getAccessRight() {
        return AccessRight;
    }

    public void setAccessRight(int AccessRight) {
        this.AccessRight = AccessRight;
    }

    public int getCollectType() {
        return CollectType;
    }

    public void setCollectType(int CollectType) {
        this.CollectType = CollectType;
    }

    public int getDataType() {
        return DataType;
    }

    public void setDataType(int DataType) {
        this.DataType = DataType;
    }

    public int getMaxValue() {
        return MaxValue;
    }

    public void setMaxValue(int MaxValue) {
        this.MaxValue = MaxValue;
    }

    public int getMinValue() {
        return MinValue;
    }

    public void setMinValue(int MinValue) {
        this.MinValue = MinValue;
    }

    public String getTagDesc() {
        return TagDesc;
    }

    public void setTagDesc(String TagDesc) {
        this.TagDesc = TagDesc;
    }

    public String getTagID() {
        return TagID;
    }

    public void setTagID(String TagID) {
        this.TagID = TagID;
    }

    public String getTagLocation() {
        return TagLocation;
    }

    public void setTagLocation(String TagLocation) {
        this.TagLocation = TagLocation;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String TagName) {
        this.TagName = TagName;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }
}