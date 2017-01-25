/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.capgemini.phonebook.dao;

import cz.capgemini.phonebook.domain.Person;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author dmachace
 */
public class PhoneBookDaoXLS {

    private String[][] myArray;
    private int firstRow;
    private int lastRow;
    private static XSSFSheet mySheet;

    private final static String SOURCE_PATH = "C:/workspace/phonebook.xlsx";

    public PhoneBookDaoXLS() {
        try {
            myArray = this.getArray();
        } catch (IOException | InvalidFormatException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Person> getPersonsList() {
        List<Person> retVal = new ArrayList<>();

        int row = 0;
        for (row = 0; row < myArray[1].length; row++) {
            retVal.add(new Person(myArray[2][row], myArray[0][row], myArray[1][row], myArray[3][row], myArray[4][row]));
        }

        return retVal;
    }

    public XSSFSheet getSheet() throws IOException, InvalidFormatException {

        File myFile = new File(SOURCE_PATH);
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        mySheet = myWorkBook.getSheetAt(0);

        return mySheet;
    }

    public String[][] getArray() throws IOException, InvalidFormatException {

        mySheet = getSheet();
        firstRow = findRow(mySheet, "jmen") + 1;
        lastRow = findRow(mySheet, "aseda") - 1;

        int size;
        size = lastRow - firstRow;

        myArray = new String[5][size];
        myArray = fillArray(mySheet, myArray);
        return myArray;
    }

    public int findRow(XSSFSheet sheet, String cellContent) {
        String value;
        int rowNum;
        int count = 0;

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            count++;
            System.out.print(count + " ");
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    value = cell.getRichStringCellValue().getString();
                    if (StringUtils.containsIgnoreCase(value, cellContent)) {
                        rowNum = row.getRowNum();
                        return rowNum;
                    }
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    value = cell.getRichStringCellValue().getString();
                    if (StringUtils.containsIgnoreCase(value, cellContent)) {
                        rowNum = row.getRowNum();
                        return rowNum;
                    }
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public String[][] fillArray(XSSFSheet mySheet, String[][] myArray) throws IOException, InvalidFormatException {
        this.myArray = myArray;
        String cellString;

        for (int k = 0; k < myArray[1].length; k++) {
            for (int j = 0; j < 5; j++) {
                Cell cell = mySheet.getRow(k + firstRow).getCell(j);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        cellString = String.valueOf((int) cell.getNumericCellValue());
                        if ((cellString == null) || (cellString.equals("")) || (cellString.equals("NA"))) {
                            cellString = "-";
                        }
                        myArray[j][k] = cellString;
                        break;

                    case Cell.CELL_TYPE_STRING:
                        cellString = cell.getRichStringCellValue().getString();
                        if ((cellString == null) || (cellString.equals(""))) {
                            cellString = "Not available";
                        }
                        myArray[j][k] = cellString;
                        break;

                    default:
                        myArray[j][k] = "-";
                        break;
                };
            };
        }

        return myArray;
    }

    public List<Integer> search(String[][] myArray, String targetValue) {

        List<Integer> searchList = new ArrayList<>();
        int duplicity = -1;
        for (int j = 0; j < myArray[0].length; j++) {
            for (String[] myArray1 : myArray) {
                if (myArray1[j].contains(targetValue)) {
                    if (duplicity != j) {
                        duplicity = j;
                        searchList.add(j);
                    }
                }
            }
        }
        return searchList;
    }
}
