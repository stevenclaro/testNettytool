package enumok;

/*
     * <p>Title: getByValue</p>
     * <p>Description: 通过CODE获取标识</p>
     * @param
     * @return
     * https://www.cnblogs.com/0201zcr/p/5104497.html
 */
    public class enumtest {
        public static void main(String[] args) {
            enumte[] actionTypeEnums = enumte.values();
            for(enumte actionTypeEnum : actionTypeEnums){
                System.out.println("name=" + actionTypeEnum.getCode());
                System.out.println("index= " + actionTypeEnum.getMode());
                System.out.println("oridary=" + actionTypeEnum.ordinal());
                System.out.println("this = " + actionTypeEnum);
                //System.out.println("下载值："  + actionTypeEnum.valueOf("下载"));
                System.out.println("name()方法= " + actionTypeEnum.name());
                System.out.println("--------------叫我分割线------------------");
            }
        }
    }
