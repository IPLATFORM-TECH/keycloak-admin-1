package space.eliseev.keycloakadmin.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.RoleDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleFormBuilderXlsx implements RoleFormBuilder {
    @Override
    public byte[] download (List<RoleDto> roleDtoList) {

        byte[] arr;

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Новый лист");

            int rownum = 0;

            Row row = sheet.createRow(rownum);
            row.createCell(0).setCellValue("clientRealmConstraint");
            row.createCell(1).setCellValue("clientRole");
            row.createCell(2).setCellValue("description");
            row.createCell(3).setCellValue("name");
            row.createCell(4).setCellValue("client");
            row.createCell(5).setCellValue("realm");

            for (RoleDto roleDto : roleDtoList) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0).setCellValue(roleDto.getClientRealmConstraint());
                row.createCell(1).setCellValue(roleDto.getClientRole());
                row.createCell(2).setCellValue(roleDto.getDescription());
                row.createCell(3).setCellValue(roleDto.getName());
                row.createCell(4).setCellValue(roleDto.getClient());
                row.createCell(5).setCellValue(roleDto.getRealm());
            }

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try (bos) {
                workbook.write(bos);
            }
            arr = bos.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return arr;
    }
}
