package com.example.demo;

import java.io.IOException;
import java.util.*;
import java.sql.*;



public class Main {


    public static void main(String[] args) throws IOException {

        ExcelParser excelParser = new ExcelParser();
        String filePath = "C:\\New folder\\demo\\src\\main\\resources\\grad.xlsx";
        // Parse the excel sheet to get student objects list
        List<Student> studentList = excelParser.parseExcel(filePath);
        ThreadedInsertion threadedInsertion = new ThreadedInsertion();
        threadedInsertion.startInsertion(studentList);



    }
}
