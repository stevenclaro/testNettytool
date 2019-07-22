
import java.io.File;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.LinkedList;
        import java.util.List;

/*文件修改名称
    需求：[评书]单田芳-[水浒传](360回-下)文件名与 上的文件名（数字）重复，需要将下的文件名
    修改为180+文件名。
    目录及文件都是File对象。统一性操作。
    运行结果：下的文件名全部修改后，然后与上的文件名手动Copy进行合并
 */
public class fileiooperate {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String dirup="D:\\[评书]单田芳-[水浒传](360回-上)";
        String dirdown="D:\\[评书]单田芳-[水浒传](360回-下)";
        //String dirCombine="D:\\combine";
        try
        {
            File FdirupFile=new File(dirup);
            File FdirdownFile=new File(dirdown);
            //File FdirCombineFile=new File(dirCombine);

          /*  for(int i=0;i<=FdirdownFile.length();i++)
            {
                File[] file= FdirdownFile.listFiles();

            }*/
            File[] filelist=FdirdownFile.listFiles();
            for (int i =0;i<=filelist.length;i++)
            {
                String fileName=filelist[i].getName();
                String head=fileName.substring(0,fileName.lastIndexOf("."));
                int j=Integer.parseInt(head);
                j=j+180;
                String rename=Integer.toString(j)+".mp3";
                File des修改后的文件=new File(dirdown,rename);
                filelist[i].renameTo(des修改后的文件);

            }

            //combine


        }
        catch (Exception ex)
        {

        }


    }
}
