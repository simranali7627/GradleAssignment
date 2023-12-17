package com.example.demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
*
*   1. Implement a class to read the Excel file using XSSFWorkbook or HSSFWorkbook
        depending on your Excel file format.
    2. Iterate through rows and columns of the sheet(s) and extract data into Java
        objects representing your data model.
* */
public class ExcelParser {
    // store the list of employees in a final static list which can be used


//    public static void main(String[] args) {
//        try {
//            List<com.example.demo.Student> studentList = parseExcel("C:\\New folder\\demo\\src\\main\\resources\\grad.xlsx");
//
//            // Do something with the extracted data
//            for (Student employee : studentList) {
//                System.out.println(employee);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Student> parseExcel(String filePath) throws IOException {
        List<Student> employees = new ArrayList<>();


        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {


            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();

            // Skip header row if needed

            int cnt = 0;
            while (rowIterator.hasNext()) {
                cnt++;
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.iterator();

                Student employee = new Student();


                /*
                *
                *
                *
                *
                *   Column no 0 of type NUMERIC
                    Column no 1 of type FORMULA
                    Column no 2 of type STRING
                    Column no 3 of type STRING
                    Column no 4 of type STRING
                    Column no 5 of type STRING
                    Column no 6 of type NUMERIC
                    Column no 7 of type STRING
                    Column no 8 of type STRING
                    Column no 9 of type STRING
                *
                * */

                if(cnt == 78) continue;
                if(cnt == 194) break;
                FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();

                    switch (columnIndex) {

                        case 0:
                            employee.setDate((int) cell.getNumericCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 1:
                            CellValue cellValue = formulaEvaluator.evaluate(cell);
                            employee.setMonth(cellValue.getStringValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 2:
                            employee.setTeam(cell.getStringCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 3:
                            employee.setPanelName(cell.getStringCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 4:
                            employee.setRound(cell.getStringCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 5:
                            employee.setSkill(cell.getStringCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 6:
                            employee.setTime((int) cell.getNumericCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 7:
                            employee.setCandidateCurrentLocation(cell.getStringCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        case 8:
                            employee.setCandidatePreferredLocation(cell.getStringCellValue());
//                            System.out.println(cell.getCellType());
                            break;
                        // Add more cases for additional columns
                        // ...

                        default:
                            // Handle unknown column index
                            employee.setCandidateName(cell.getStringCellValue());
                            break;
                    }
                }

                employees.add(employee);
                System.out.println(employee);
                if(cnt == 1000) break;

            }



        }
        return employees;
    }
}


