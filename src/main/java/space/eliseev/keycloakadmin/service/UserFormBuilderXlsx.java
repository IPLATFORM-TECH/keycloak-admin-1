package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.UserDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFormBuilderXlsx implements UserFormBuilder {

    @Override
    public byte[] download(@NonNull List<UserDto> users) {

        byte[] arr = new byte[0];

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            Sheet sheet = createSheet(workbook);

            CellStyle allBorderedStyle = getAllBorderedStyle(workbook);
            CellStyle thickBorderStyle = getBottomThickBorderStyle(workbook);

            createHeader(sheet, thickBorderStyle);
            createCells(users, sheet, allBorderedStyle, workbook);

            workbook.write(baos);
            arr = baos.toByteArray();

        } catch (IOException e) {
            log.error("Failure to download xlsx file");
        }

        return arr;
    }


    private Sheet createSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet("Users");
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


    private CellStyle getBottomThickBorderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBorderLeft(BorderStyle.THIN);
        return style;
    }


    private CellStyle getAllBorderedStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        return style;
    }


    private void createHeader(Sheet sheet, CellStyle style) {

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("Email");
        cell.setCellStyle(style);

        Cell cell1 = row.createCell(1);
        cell1.setCellValue("Email constraint");
        cell1.setCellStyle(style);

        Cell cell2 = row.createCell(2);
        cell2.setCellValue("Email verified");
        cell2.setCellStyle(style);

        Cell cell3 = row.createCell(3);
        cell3.setCellValue("Enabled");
        cell3.setCellStyle(style);

        Cell cell4 = row.createCell(4);
        cell4.setCellValue("Firstname");
        cell4.setCellStyle(style);

        Cell cell5 = row.createCell(5);
        cell5.setCellValue("Lastname");
        cell5.setCellStyle(style);

        Cell cell6 = row.createCell(6);
        cell6.setCellValue("Username");
        cell6.setCellStyle(style);

        Cell cell7 = row.createCell(7);
        cell7.setCellValue("Created timestamp");
        cell7.setCellStyle(style);

        Cell cell8 = row.createCell(8);
        cell8.setCellValue("Not before");
        cell8.setCellStyle(style);
    }


    private void createCells(List<UserDto> users, Sheet sheet, CellStyle style, Workbook workbook) {

        Row row;
        int rownum = 0;

        for (UserDto user : users) {
            rownum++;
            row = sheet.createRow(rownum);

            Cell cell = row.createCell(0);
            cell.setCellValue(user.getEmail());
            cell.setCellStyle(style);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(user.getEmailConstraint());
            cell1.setCellStyle(style);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(String.valueOf(user.getEmailVerified()));
            cell2.setCellStyle(style);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(String.valueOf(user.getEnabled()));
            cell3.setCellStyle(style);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(user.getFirstName());
            cell4.setCellStyle(style);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(user.getLastName());
            cell5.setCellStyle(style);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(user.getUsername());
            cell6.setCellStyle(style);

            Cell cell7 = row.createCell(7);
            cell7.setCellValue(user.getCreatedTimestamp());
            CellStyle dateStyle = getDateStyle(workbook);
            cell7.setCellStyle(dateStyle);

            Cell cell8 = row.createCell(8);
            cell8.setCellValue(user.getNotBefore());
            cell8.setCellStyle(style);
        }
    }

    private CellStyle getDateStyle(Workbook workbook) {
        CellStyle dateStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd.mm.yyyy h:mm"));
        dateStyle.setBorderTop(BorderStyle.THIN);
        dateStyle.setBorderRight(BorderStyle.THIN);
        dateStyle.setBorderBottom(BorderStyle.THIN);
        dateStyle.setBorderLeft(BorderStyle.THIN);
        return dateStyle;
    }
}
