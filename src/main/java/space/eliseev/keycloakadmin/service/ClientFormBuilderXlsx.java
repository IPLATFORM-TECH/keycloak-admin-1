package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.ClientDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientFormBuilderXlsx implements ClientFormBuilder {
    @Override
    public byte[] download(@NonNull List<ClientDto> clients) {
        byte[] clientList = null;
        try(ByteArrayOutputStream stream = new ByteArrayOutputStream();
            XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Client table");

            Row row = sheet.createRow(0);

            XSSFCellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 10);
            font.setBold(true);
            style.setFont(font);

            row.createCell(0).setCellValue("enabled");
            row.createCell(1).setCellValue("full_scope_allowed");
            row.createCell(2).setCellValue("client_id");
            row.createCell(3).setCellValue("not_before");
            row.createCell(4).setCellValue("public_client");
            row.createCell(5).setCellValue("secret");
            row.createCell(6).setCellValue("base_url");
            row.createCell(7).setCellValue("bearer_only");
            row.createCell(8).setCellValue("management_url");
            row.createCell(9).setCellValue("surrogate_auth_required");
            row.createCell(10).setCellValue("protocol");
            row.createCell(11).setCellValue("node_rereg_timeout");
            row.createCell(12).setCellValue("frontchannel_logout");
            row.createCell(13).setCellValue("consent_required");
            row.createCell(14).setCellValue("name");
            row.createCell(15).setCellValue("service_accounts_enabled");
            row.createCell(16).setCellValue("client_authenticator_type");
            row.createCell(17).setCellValue("root_url");
            row.createCell(18).setCellValue("description");
            row.createCell(19).setCellValue("registration_token");
            row.createCell(20).setCellValue("standard_flow_enabled");
            row.createCell(21).setCellValue("implicit_flow_enabled");
            row.createCell(22).setCellValue("direct_access_grants_enabled");
            row.createCell(23).setCellValue("always_display_in_console");

            for (int j = 0; j < 24; j++) {
                row.getCell(j).setCellStyle(style);
            }

            int i = 0;
            for (ClientDto clientDto : clients) {
                i++;
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(clientDto.getEnabled());
                row.createCell(1).setCellValue(clientDto.getFullScopeAllowed());
                row.createCell(2).setCellValue(clientDto.getClientId());
                row.createCell(3).setCellValue(clientDto.getNotBefore());
                row.createCell(4).setCellValue(clientDto.getPublicClient());
                row.createCell(5).setCellValue(clientDto.getSecret());
                row.createCell(6).setCellValue(clientDto.getBaseUrl());
                row.createCell(7).setCellValue(clientDto.getBearerOnly());
                row.createCell(8).setCellValue(clientDto.getManagementUrl());
                row.createCell(9).setCellValue(clientDto.getSurrogateAuthRequired());
                row.createCell(10).setCellValue(clientDto.getProtocol());
                row.createCell(11).setCellValue(clientDto.getNodeReregTimeout());
                row.createCell(12).setCellValue(clientDto.getFrontchannelLogout());
                row.createCell(13).setCellValue(clientDto.getConsentRequired());
                row.createCell(14).setCellValue(clientDto.getName());
                row.createCell(15).setCellValue(clientDto.getServiceAccountsEnabled());
                row.createCell(16).setCellValue(clientDto.getClientAuthenticatorType());
                row.createCell(17).setCellValue(clientDto.getRootUrl());
                row.createCell(18).setCellValue(clientDto.getDescription());
                row.createCell(19).setCellValue(clientDto.getRegistrationToken());
                row.createCell(20).setCellValue(clientDto.getStandardFlowEnabled());
                row.createCell(21).setCellValue(clientDto.getImplicitFlowEnabled());
                row.createCell(22).setCellValue(clientDto.getDirectAccessGrantsEnabled());
                row.createCell(23).setCellValue(clientDto.getAlwaysDisplayInConsole());
            }
            workbook.write(stream);
            clientList = stream.toByteArray();
        } catch (IOException e) {
            log.error("I/O operation error");
        }
        return clientList;
    }
}
