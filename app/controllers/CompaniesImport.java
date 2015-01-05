package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import models.Company;

import org.apache.commons.lang.WordUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import play.data.validation.MaxSize;
import play.mvc.Controller;

public class CompaniesImport extends Controller {
	
	public static void importFromFile(File companiesFile){
		
		String result;
		List<Company> companies = new ArrayList<Company>();
		
		try {
			companies = readFile(companiesFile);
			result = "Plik odczytany. ";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			result = "Import niemożliwy. \n" + e;
		}
		
		if (companies.size() > 0){
			result = result + "\n Zaimportowano firm: " + companies.size();
		}
		
		System.out.println(result);
		
		saveToDb(companies);
		
		render(result);
		
	}

	private static void saveToDb(List<Company> companies) {
		
		Company.deleteAll();
		for (Company company : companies){
			company.save();
		}
		
	}

	private static List<Company> readFile(File companies) throws IOException {
		List<Company> companiesList = new ArrayList<Company>();
		
		InputStream is = new FileInputStream(companies);
		Workbook wb = new HSSFWorkbook(is);
		
		List<Company> companiesFromSheet = getCompaniesForSheet(wb.getSheetAt(0));
		companiesList.addAll(companiesFromSheet);
		companiesFromSheet = getCompaniesForSheet(wb.getSheetAt(1));
		companiesList.addAll(companiesFromSheet);
		companiesFromSheet = getCompaniesForSheet(wb.getSheetAt(2));
		companiesList.addAll(companiesFromSheet);
		companiesFromSheet = getCompaniesForSheet(wb.getSheetAt(3));
		companiesList.addAll(companiesFromSheet);
		companiesFromSheet = getCompaniesForSheet(wb.getSheetAt(4));
		companiesList.addAll(companiesFromSheet);
		companiesFromSheet = getCompaniesForSheet(wb.getSheetAt(5));
		companiesList.addAll(companiesFromSheet);
		
		return companiesList;
		
	}

	private static List<Company> getCompaniesForSheet(Sheet sheet) {
		List<Company> companiesList = new ArrayList<Company>(); 
		for (Row row : sheet) {
			if (row.getRowNum() > 2){
				Cell cell = row.getCell(3);
				
				if (cell != null && cell.getStringCellValue().length() > 0){ // not every row contains city details, there are empty rows
					Company company = prepareCompany(row);
					companiesList.add(company);
				}
			}
			
		}
		return companiesList;
	}

	private static Company prepareCompany(Row row) {
		
		Company company = new Company();
		
		company.companyName = getCellStringValue(row, 1);
		company.city = WordUtils.capitalize(getCellStringValue(row, 2));
		company.address = getCellStringValue(row, 3);
		company.province = getCellStringValue(row, 4);
		if (row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC ) {
			Double phone = row.getCell(6).getNumericCellValue();
			company.phone = String.valueOf(phone.intValue());
		} else if ( row.getCell(6).getCellType() == Cell.CELL_TYPE_STRING ){
			company.phone = row.getCell(6).getStringCellValue();			
		}
		
		String www = getCellStringValue(row, 7);
		if (www.startsWith("www")){
			www = "http://" + www;
		}
		
		company.www = www;
		company.email = getCellStringValue(row, 8);
		company.line = getCellStringValue(row, 9);
		company.remarks = getCellStringValue(row, 10);
		
		company.position = getCellStringValue(row, 11);
		company.mapLink = getCellStringValue(row, 12);
		company.latitude = getCellStringValue(row, 13);
		company.longitude = getCellStringValue(row, 14);
		
		return company;
	}
	
	private static String getCellStringValue(Row row, int column){
		String value = "";
		
		if (row != null && row.getCell(column) != null){
			if (row.getCell(column).getCellType() == Cell.CELL_TYPE_NUMERIC ) {
				Double number = row.getCell(column).getNumericCellValue();
				value = String.valueOf(number);
			} else if ( row.getCell(column).getCellType() == Cell.CELL_TYPE_STRING ){
				if (row.getCell(column)!= null && row.getCell(column).getStringCellValue() != null){
					value = row.getCell(column).getStringCellValue();
				}			
			}
		}
		if (value.equals("-")){
			value = "";
		}
		
		if (value.equals("")){
			value = "-";
		}
		
		return value;
	}

}
