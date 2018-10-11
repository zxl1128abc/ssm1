package com.ziroom.util;


import com.ziroom.entity.UserEntity;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POIExportAndImportUtil {
    //输出到Excel
    public static void exportExcel(List data, Class clasz, String path) throws IllegalAccessException, IOException {//path:输出文件的路径
        HSSFWorkbook wb = new HSSFWorkbook();//创建Excel表格对象
        HSSFSheet sheet = wb.createSheet();//创建单元页对象
        Field[] fields = clasz.getDeclaredFields();
        HSSFRow row = sheet.createRow(0);//表格第一行放入属性的名称
        for (int i = 0; i < fields.length-1; i++) {
            row.createCell(i).setCellValue(fields[i].getName());
        }
        for (int i = 1; i <= data.size()-1; i++) {
            HSSFRow row1 = sheet.createRow(i);//创建行对象
            Object o = data.get(i - 1);
            for (int j = 0; j < fields.length-1; j++) {
                HSSFCell cell = row1.createCell(j);//创建单元格对象
                Field field = fields[j];
                field.setAccessible(true);
                cell.setCellValue(field.get(o).toString());
            }
        }
        wb.write(new File(path));
    }

    //输入到Excel
    public static List importExcel(FileInputStream fis, Class clasz) throws IOException, IllegalAccessException, InstantiationException, ParseException {
        //创建Excel对象
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheetAt = wb.getSheetAt(0);
        ArrayList list = new ArrayList();
        for (int i = 1; i <= sheetAt.getLastRowNum(); i++) {
            HSSFRow row = sheetAt.getRow(i);
            Object o = clasz.newInstance();
            Field[] fields = o.getClass().getDeclaredFields();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                HSSFCell cell = row.getCell(j);
                Field field = fields[j];
                field.setAccessible(true);//打破封装
                if (field.getType() == Integer.class) {
                    field.set(o, new Integer(cell.toString()));
                }else if(field.getType()== Date.class){
                    field.set(o,new SimpleDateFormat("yyyy-MM-dd").parse(cell.toString()));
                }
                else {
                    field.set(o, cell.toString());
                }
            }
            list.add(o);
        }
        return list;
    }


    //测试Util类
    public static void main(String[] args) throws IOException, IllegalAccessException, ParseException, InstantiationException {
       // ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
       /* AdminDAO adminDAO = (AdminDAO) context.getBean("adminDAO");
        List<Admin> admins = adminDAO.queryAllAdmins();
        exportExcel(admins,Admin.class,"e://adminUtil.xls");*/
       /* UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        List<User> users = userDAO.queryAll();
        exportExcel(users,User.class,"e://users.xls");*/
       importExcel(new FileInputStream("e://exportUsers.xls"),UserEntity.class);
    }
}
