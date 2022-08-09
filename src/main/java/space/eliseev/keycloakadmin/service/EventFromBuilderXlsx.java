package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.EventDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventFromBuilderXlsx implements EventFromBuilder {
    private final EventDataService eventDataService;

    @Override
    public byte[] downloadEvent(@NonNull List<EventDto> eventDtoList) {
        byte[] byteArr = null;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Event");
            int num = 0;
            Row header = sheet.createRow(0);

            header.createCell(0).setCellValue("Client name");
            header.createCell(1).setCellValue("Details Json");
            header.createCell(2).setCellValue("Ip address");
            header.createCell(3).setCellValue("Realm name");
            header.createCell(4).setCellValue("Event time");
            header.createCell(5).setCellValue("Type");
            header.createCell(6).setCellValue("Username");
            header.createCell(7).setCellValue("Error");

            for (EventDto eventDto : eventDtoList) {
                num++;
                header = sheet.createRow(num);
                header.createCell(0).setCellValue(String.valueOf(eventDataService.getClientName()));
                header.createCell(1).setCellValue(eventDto.getDetailsJson());
                header.createCell(2).setCellValue(eventDto.getIpAddress());
                header.createCell(3).setCellValue(String.valueOf(eventDataService.getRealmName()));
                header.createCell(4).setCellValue(String.valueOf(eventDto.getEventTime()));
                header.createCell(5).setCellValue(eventDto.getType());
                header.createCell(6).setCellValue(String.valueOf(eventDataService.getUsername()));
                header.createCell(7).setCellValue(eventDto.getError());

            }
            workbook.write(byteArrayOutputStream);
            byteArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArr;
    }
}
