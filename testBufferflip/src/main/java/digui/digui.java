package digui;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class digui {
    //配置的数据集合 是管控关系的集合
    //已经成功运行
    static List<record> recordList=new ArrayList<>();
    static Set<String> resultSet=new HashSet<>();
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jeecg-boot";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "abc=123";
    public static void main(String[] args) {
        //构建模拟数据
       // createData();
        createDataFromDB();
        String managerid="sjk";
        //getLeaf(managerid,recordList,resultSet);
        getLeafEh(managerid,recordList,resultSet);


        for(String each :resultSet)
        {
            System.out.println(each+"\r\n");
        }

    }
    /*
           字符串相等采用==来进行判断，这样的处理方式会存在错误
        */
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
    /*
        字符串相等采用equal来进行判断，这样的处理方式最准确，getLeaf上面是采用==来判断字符串相等，就会存在错误
     */
    public static void getLeafEh(String managerid,List<record> recordList,Set<String> resultSet)
    {
        List<record> templist=new ArrayList<>();
        for(record r:recordList)
        {
            if(r.managerid.equals(managerid))
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
            getLeafEh(managerid,recordList,resultSet);
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

        record r7=new record();
        r7.id="7";
        r7.managerid="tc";
        r7.normalid="ws";
        recordList.add(r7);
    }

    public static  void  createDataFromDB()
    {

        List<Relation> relationLists=selectList();//已经取得这个数据库的集合

        for(Relation r: relationLists)
        {
            record r1=new record();
            r1.id=r.id;
            r1.managerid=r.managerid;
            r1.normalid=r.normalid;
            recordList.add(r1);
        }

    }
    private static List<Relation> selectList()
    {
        Connection conn = null;
        Statement stmt = null;
        List<Relation> relationList=new ArrayList<>();
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            //sql = "SELECT id, name, url FROM websites";
            sql="SELECT create_by,create_time,update_by,update_time,sys_org_code,managerid,normalid,id FROM relation";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                               /* int id  = rs.getInt("id");
                                String name = rs.getString("name");
                                String url = rs.getString("url");*/

                Relation r=new Relation();
                r.id=(rs.getString("id").trim());
                r.createBy=(rs.getString("create_by").trim());
                r.managerid=(rs.getString("managerid").trim());
                r.normalid=(rs.getString("normalid").trim());

                relationList.add(r);

                               /* // 输出数据
                                System.out.print("ID: " + id);
                                System.out.print(", 站点名称: " + name);
                                System.out.print(", 站点 URL: " + url);
                                System.out.print("\n");*/
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return  relationList;
    }
}
