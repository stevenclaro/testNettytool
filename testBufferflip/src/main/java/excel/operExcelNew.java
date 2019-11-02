package excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class operExcelNew {
    public static void main(String[] args)  {
        String fileName="C:\\Users\\SunJingKe\\Desktop\\Fsjk.xls";
        String desFileName="C:\\Users\\SunJingKe\\Desktop\\result.xls";
        String sheetName="1";

        InputStream is=null;
        HSSFWorkbook wb=null;
        try
        {
            is=new FileInputStream(fileName);
            //wb = WorkbookFactory.create(is);
            wb=new HSSFWorkbook(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet =wb.getSheet("1");
        List<rowdata> rowdataList = readExcelSheet(sheet);

        System.out.println("Total set:"+rowdataList.size());
        try {
            writeExcel(desFileName,rowdataList);


        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }

    }
    private static List<rowdata> readExcelSheet(Sheet sheet) {
        //StringBuilder sb = new StringBuilder();

            List<rowdata> rowdataList = new ArrayList<>();

            if (sheet != null) {
                int rowNos = sheet.getLastRowNum();// 得到excel的总记录条数

                for (int i = 1; i <= rowNos; i++) {// 遍历行
                try {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        Cell cell = row.getCell(0);
                        if (cell != null) {
                            cell.setCellType(CellType.STRING);
                            rowdata rda = new rowdata();
                            rda.CodeAll = cell.getStringCellValue();
                            rda.no1 = rda.CodeAll.substring(0, 2);
                            if(rda.CodeAll.contains("15-34.20.20.30.10"))
                            {
                                System.out.println("正在调试");
                            }
                            String[] allarr = StringUtils.split(rda.CodeAll, "-");
                            String dotpart = allarr[1];

                            String[] arr = StringUtils.split(dotpart, ".");

                            rda.no2 = arr[0];
                            rda.no3 = arr[1];
                            rda.no4 = arr[2];
                            if (arr.length > 3)
                                rda.no5 = arr[3];
                            if(arr.length>4)
                                rda.no6=arr[4];

                            // System.out.print(cell.getStringCellValue() + " ");

                            rowdataList.add(rda);
                           System.out.println("当前正在处理的记录是" + i + "/" + rowNos + rda.CodeAll + "分解后的结果" + rda.no1 + rda.no2 + rda.no3 + rda.no4 + rda.no5);
                        }


                    }
                }
                catch (Exception ex)
                {
                    System.out.println("当前正在处理的记录是" + i  );
                }
                }
            }


        return rowdataList;
    }

    private static void writeExcel(String des,List<rowdata> rowdataList) throws IOException {

        HSSFWorkbook wb=new HSSFWorkbook();
        Sheet sheet =wb.createSheet("result");
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成样式
       // Map<String, CellStyle> styles = createStyles(wb);
        // 创建标题行
        Row row = sheet.createRow(0);
        // 存储标题在Excel文件中的序号
        //HSSFCell  c0=row.createCell(0);
        Cell  c0=row.createCell(0);
        c0.setCellValue("整体编号");
        Cell  c1=row.createCell(1);
        c1.setCellValue("一级");
        Cell  c2=row.createCell(2);
        c2.setCellValue("二级");
        Cell  c3=row.createCell(3);

        c3.setCellValue("三级");
        Cell  c4=row.createCell(4);

        c4.setCellValue("四级");
        Cell c5=row.createCell(5);

        c5.setCellValue("五级");
        Cell c6=row.createCell(6);

        c6.setCellValue("六级");

        //写入正文
        int rows=rowdataList.size();
        System.out.println("一共有记录数量为:"+rows);
        for(int i=1;i<=rows;i++)
        {
            row=sheet.createRow(i);
            rowdata rd=rowdataList.get(i-1);


            Cell cell=row.createCell(0);
            cell.setCellValue(rd.CodeAll==null ?"":rd.CodeAll);
            Cell cel2=row.createCell(1);
            cel2.setCellValue(rd.no1==null ?"":rd.no1);
            Cell cel3=row.createCell(2);
            cel3.setCellValue(rd.no2==null ?"":rd.no2);
            Cell cel4=row.createCell(3);
            cel4.setCellValue(rd.no3==null ?"":rd.no3);
            Cell cel5=row.createCell(4);
            cel5.setCellValue(rd.no4==null ?"":rd.no4);
            Cell cel6=row.createCell(5);
            cel6.setCellValue(rd.no5==null?"":rd.no5);
            Cell cel7=row.createCell(6);
            cel7.setCellValue(rd.no6==null?"":rd.no6);
        }
        try {
            FileOutputStream  outputStream=new FileOutputStream(des);
            wb.write(outputStream);

        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        finally {

            if (wb != null) {
                wb.close();
            }
        }
    }
}
