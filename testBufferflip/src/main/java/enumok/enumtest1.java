package enumok;

/*
https://www.cnblogs.com/0201zcr/p/5104497.html
 */
public class   enumtest1 {

                public static void main(String[] args)
                {
                        ActionTypeEnum[] actionTypeEnums = ActionTypeEnum.values();
                        for(ActionTypeEnum actionTypeEnum : actionTypeEnums){
                                System.out.println("name=" + actionTypeEnum.getName());
                                System.out.println("index= " + actionTypeEnum.getIndex());
                                System.out.println("test= " + actionTypeEnum.getTest());
                                System.out.println("oridary=" + actionTypeEnum.ordinal());
                                System.out.println("this = " + actionTypeEnum);
                                System.out.println("下载值："  + actionTypeEnum.valueOf("下载"));
                                System.out.println("name()方法= " + actionTypeEnum.name());
                                System.out.println("--------------叫我分割线------------------");
                        }
                }
        }
