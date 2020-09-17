package org.imooc.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.imooc.dto.ExcelParamDto;
import org.imooc.dto.ExcelResultDto;
import org.imooc.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {
    public ExcelResultDto imp(ExcelParamDto dto )  {
        ExcelResultDto result = new ExcelResultDto();
        result.setTitle(dto.getTitle() );
        List<Student> listStudent = new ArrayList<>();
        result.setStudentList( listStudent );
        Workbook workbook=null;
        try {
            workbook = WorkbookFactory.create( dto.getExcel().getInputStream() );
            Sheet sheet = workbook.getSheetAt( 0 );
            int rowNums = sheet.getLastRowNum();
            for(int i = 1; i <=rowNums; i++){
                Row row = sheet.getRow( i );
                Student student = new Student();
                listStudent.add(student  );
                student.setName( row.getCell( 0 ).getStringCellValue() );
                student.setAge( (int) row.getCell( 1 ).getNumericCellValue() );
                student.setDate( row.getCell( 2).getDateCellValue() );
            }
        }catch(Exception e){
            e.printStackTrace();
            result.setMsg( "ÎÄ¼þ½âÎöÊ§°Ü" );
        }
        if(workbook!=null){
            try{
            workbook.close();}
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
