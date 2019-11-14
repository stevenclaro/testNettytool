package json;

import com.alibaba.fastjson.JSON;

/**
 * @author wujiang
 * @version 1.0.0.
 * @date 2017/4/30
 */
public class jsonTest {
    public static void main(String[] args) {
        /**
         * json字符串转化为对象
         */
        String jsonString = "{name:'Antony',age:'12',sex:'male',telephone:'88888'}";
        Staff staff = JSON.parseObject(jsonString, Staff.class);
        System.out.println(staff.toString());

        //https://blog.csdn.net/antony9118/article/details/71023009

        /**
         * 对象转化为json字符串
         */
        String jsonStr = JSON.toJSONString(staff);
        System.out.println(jsonStr);
    }
}
