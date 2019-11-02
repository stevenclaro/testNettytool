public class charhandle {
    public static void main(String[] args) {
        //psvm是main的快捷键
        String[] stringlist={"sjk","tianchuang"};
        String invalue="";
        for(String x:stringlist)
        {
            invalue=x+","+invalue;
        }
        invalue=invalue.substring(0,invalue.length()-1);
        System.out.println(invalue);
    }

}
