package convertTest;

import java.io.Console;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/*
    测试反射获取类，反射设置类的值，类似与数据库中的设置行列转换
 */
public class convert {
    public static void main(String[] args) {

        businesspo bpo=new businesspo();
        List<storeVO> stli= init();
        conv(bpo,stli);
        System.out.println(bpo);
    }
    public static void  conv(businesspo bpo,List<storeVO> slist)
    {

        try {
            //Class clazz=Class.forName(path);
            //Field[] fields=clazz.getFields();
            Field[] fields= bpo.getClass().getDeclaredFields();
            for(Field field : fields)
            {
                field.setAccessible(true);
                for(storeVO so :slist)
                {
                    if(field.getName()==so.name)
                    {
                        field.set(bpo,so.attri);
                        break;
                    }

                }
            }

        }
        catch (Exception ex)
        {

        }
    }
    public static List<storeVO> init()
    {
        List<storeVO> volist=new ArrayList<storeVO>();
        storeVO vo1=new storeVO();
        vo1.name="equiName";
        vo1.attri="空调";
        volist.add(vo1);
        storeVO vo2=new storeVO();
        vo2.name="location";
        vo2.attri="3楼";
        volist.add(vo2);
        return  volist;
    }
}
