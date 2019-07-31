package enumok;

//多个属性值
     public enum ActionTypeEnum{
    //通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
    //赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
    下载(1,"xiazai","ok"),访问(2,"fangwen","false");
    int index;
    String name;
    String test;

    private ActionTypeEnum(int index,String name,String test){
        this.index = index;
        this.name = name;
        this.test=test;

    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

         public String getTest()
         {
             return test;
         }
}