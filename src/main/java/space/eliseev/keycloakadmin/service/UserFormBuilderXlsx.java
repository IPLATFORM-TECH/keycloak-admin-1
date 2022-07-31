package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFormBuilderXlsx implements UserFormBuilder {

    @Override
    public byte[] download(@NonNull List<User> users) {

        byte[] arr = new byte[0];

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            XSSFSheet sheet = createSheet(workbook);

            XSSFCellStyle allBorderedStyle = createAllBorderedStyle(workbook);
            XSSFCellStyle thikBorderStyle = createBottomThikBorderStyle(workbook);

            createHeader(sheet, thikBorderStyle);
            createCells(users, sheet, allBorderedStyle);

            workbook.write(baos);
            arr = baos.toByteArray();

        } catch (IOException e) {
            log.error("Failure to upload xlsx file");
        }

        return arr;
    }


    private XSSFSheet createSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("Users");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);
        sheet.setColumnWidth(4, 6000);
        sheet.setColumnWidth(5, 6000);
        sheet.setColumnWidth(6, 6000);
        sheet.setColumnWidth(7, 6000);
        sheet.setColumnWidth(8, 6000);
        sheet.setColumnWidth(9, 6000);
        sheet.setColumnWidth(10, 6000);
        return sheet;
    }


    private XSSFCellStyle createBottomThikBorderStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBorderLeft(BorderStyle.THIN);
        return style;
    }


    private XSSFCellStyle createAllBorderedStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        return style;
    }


    private void createHeader(XSSFSheet sheet, XSSFCellStyle style) {

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("email");
        cell.setCellStyle(style);

        Cell cell1 = row.createCell(1);
        cell1.setCellValue("email_constraint");
        cell1.setCellStyle(style);

        Cell cell2 = row.createCell(2);
        cell2.setCellValue("enabled");
        cell2.setCellStyle(style);

        Cell cell3 = row.createCell(3);
        cell3.setCellValue("federation_link");
        cell3.setCellStyle(style);

        Cell cell4 = row.createCell(4);
        cell4.setCellValue("first_name");
        cell4.setCellStyle(style);

        Cell cell5 = row.createCell(5);
        cell5.setCellValue("last_name");
        cell5.setCellStyle(style);

        Cell cell6 = row.createCell(6);
        cell6.setCellValue("realm_id");
        cell6.setCellStyle(style);

        Cell cell7 = row.createCell(7);
        cell7.setCellValue("username");
        cell7.setCellStyle(style);

        Cell cell8 = row.createCell(8);
        cell8.setCellValue("created_timestamp");
        cell8.setCellStyle(style);

        Cell cell9 = row.createCell(9);
        cell9.setCellValue("service_account_client_link");
        cell9.setCellStyle(style);

        Cell cell10 = row.createCell(10);
        cell10.setCellValue("not_before");
        cell10.setCellStyle(style);
    }


    private void createCells(List<User> users, XSSFSheet sheet, XSSFCellStyle style) {

        Row row;
        int rownum = 0;

        for (User user : users) {
            rownum++;
            row = sheet.createRow(rownum);

            Cell cell = row.createCell(0);
            cell.setCellValue(user.getEmail());
            cell.setCellStyle(style);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(user.getEmailConstraint());
            cell1.setCellStyle(style);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(user.getEnabled());
            cell2.setCellStyle(style);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(user.getFederationLink());
            cell3.setCellStyle(style);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(user.getFirstName());
            cell4.setCellStyle(style);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(user.getLastName());
            cell5.setCellStyle(style);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(user.getRealmId());
            cell6.setCellStyle(style);

            Cell cell7 = row.createCell(7);
            cell7.setCellValue(user.getUsername());
            cell7.setCellStyle(style);

            Cell cell8 = row.createCell(8);
            cell8.setCellValue(user.getCreatedTimestamp());
            cell8.setCellStyle(style);

            Cell cell9 = row.createCell(9);
            cell9.setCellValue(user.getServiceAccountClientLink());
            cell9.setCellStyle(style);

            Cell cell10 = row.createCell(10);
            cell10.setCellValue(user.getNotBefore());
            cell10.setCellStyle(style);
        }
    }
}
