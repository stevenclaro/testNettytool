package digui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class digui {
    //配置的数据集合 是管控关系的集合
    //已经成功运行
    static List<record> recordList=new ArrayList<>();
    static Set<String> resultSet=new HashSet<>();
    public static void main(String[] args) {
        //构建模拟数据
        createData();
        String managerid="sjk";
        getLeaf(managerid,recordList,resultSet);

       /* resultSet.forEach(x->{
            System.out.println(x);
        });*/

        for(String each :resultSet)
        {
            System.out.println(each+"\r\n");
        }

    }

    public static void getLeaf(String managerid,List<record> recordList,Set<String> resultSet)
    {
        List<record> templist=new ArrayList<>();
        for(record r:recordList)
        {
            if(r.managerid==managerid)
            {
                templist.add(r);
                resultSet.add(managerid);//中间的节点也记录
            }
        }
        if(templist.size()==0)
        {
            resultSet.add(managerid);//叶节点记录
            return;
        }
        for(record rx:templist)
        {
            managerid=rx.normalid;
            getLeaf(managerid,recordList,resultSet);
        }
    }
    public static void createData()
    {
        record r1=new record();
        r1.id="1";
        r1.managerid="sjk";
        r1.normalid="lb";
        recordList.add(r1);

        record r2=new record();
        r2.id="2";
        r2.managerid="sjk";
        r2.normalid="ws";
        recordList.add(r2);

        record r3=new record();
        r3.id="3";
        r3.managerid="lb";
        r3.normalid="xy";
        recordList.add(r3);

        record r4=new record();
        r4.id="4";
        r4.managerid="lb";
        r4.normalid="wy";
        recordList.add(r4);

        record r5=new record();
        r5.id="5";
        r5.managerid="ws";
        r5.normalid="wy";
        recordList.add(r5);

        record r6=new record();
        r6.id="6";
        r6.managerid="tc";
        r6.normalid="lmm";
        recordList.add(r6);


    }

}
