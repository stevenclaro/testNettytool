package IOT;

import java.util.ArrayList;
import java.util.List;

public class TagNodeInfo {

    /**
     * ChildNodes : null
     * ID : 0100010001
     * IsTagNode : true
     * Name : 运行状态
     * TagInfo : {"AccessRight":2,"CollectType":0,"DataType":1,"MaxValue":0,"MinValue":0,"TagDesc":"","TagID":"0100010001","TagLocation":"","TagName":"运行状态","Unit":""}
     */

    //private Object ChildNodes;
    private List<TagNodeInfo> ChildNodes = new ArrayList<TagNodeInfo>();//孩子结点列表
    private TagNodeInfo parent;
    private String ID;
    private boolean IsTagNode;
    private String Name;
    private TagInfo TagInfo;


    public List<TagNodeInfo> getChildren() {
        return ChildNodes;
    }

    public void setChildren(List<TagNodeInfo> children) {
        this.ChildNodes = children;
    }
    public TagNodeInfo getParent() {
        return parent;
    }

    public void setParent(TagNodeInfo parent) {
        this.parent = parent;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean isIsTagNode() {
        return IsTagNode;
    }

    public void setIsTagNode(boolean IsTagNode) {
        this.IsTagNode = IsTagNode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}