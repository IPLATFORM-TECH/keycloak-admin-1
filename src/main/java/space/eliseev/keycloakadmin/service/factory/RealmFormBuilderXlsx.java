package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.RealmDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RealmFormBuilderXlsx implements RealmFormBuilder {
    @Override
    public byte[] download(@NonNull List<RealmDto> realmDto) {

        byte[] arr = new byte[0];

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            Sheet sheet = createSheet(workbook);

            CellStyle allBorderedStyle = getAllBorderedStyle(workbook);
            CellStyle thickBorderStyle = getBottomThickBorderStyle(workbook);


            createHeader(sheet, thickBorderStyle);
            createCells(realmDto, sheet, allBorderedStyle);

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
        sheet.setColumnWidth(11, 6000);
        sheet.setColumnWidth(12, 6000);
        sheet.setColumnWidth(13, 6000);
        sheet.setColumnWidth(14, 6000);
        sheet.setColumnWidth(15, 6000);
        sheet.setColumnWidth(16, 6000);
        sheet.setColumnWidth(17, 6000);
        sheet.setColumnWidth(18, 6000);
        sheet.setColumnWidth(19, 6000);
        sheet.setColumnWidth(20, 6000);
        sheet.setColumnWidth(21, 6000);
        sheet.setColumnWidth(22, 6000);
        sheet.setColumnWidth(23, 6000);
        sheet.setColumnWidth(24, 6000);
        sheet.setColumnWidth(25, 6000);
        sheet.setColumnWidth(26, 6000);
        sheet.setColumnWidth(27, 6000);
        sheet.setColumnWidth(28, 6000);
        sheet.setColumnWidth(29, 6000);
        sheet.setColumnWidth(30, 6000);
        sheet.setColumnWidth(31, 6000);
        sheet.setColumnWidth(32, 6000);
        sheet.setColumnWidth(33, 6000);
        sheet.setColumnWidth(34, 6000);
        sheet.setColumnWidth(35, 6000);
        sheet.setColumnWidth(36, 6000);
        sheet.setColumnWidth(37, 6000);
        sheet.setColumnWidth(38, 6000);
        sheet.setColumnWidth(39, 6000);
        sheet.setColumnWidth(40, 6000);
        sheet.setColumnWidth(41, 6000);
        sheet.setColumnWidth(42, 6000);
        sheet.setColumnWidth(43, 6000);
        sheet.setColumnWidth(44, 6000);
        sheet.setColumnWidth(45, 6000);
        sheet.setColumnWidth(46, 6000);
        sheet.setColumnWidth(47, 6000);
        sheet.setColumnWidth(48, 6000);
        sheet.setColumnWidth(49, 6000);
        sheet.setColumnWidth(50, 6000);
        sheet.setColumnWidth(51, 6000);

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
        cell.setCellStyle(style);
        cell.setCellValue("accessCodeLifespan");

        Cell cell1 = row.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("userActionLifespan");

        Cell cell2 = row.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("accessTokenLifespan");

        Cell cell3 = row.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("accountTheme");

        Cell cell4 = row.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("adminTheme");

        Cell cell5 = row.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("emailTheme");

        Cell cell6 = row.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("enabled");

        Cell cell7 = row.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("eventsEnabled");

        Cell cell8 = row.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("eventsExpiration");

        Cell cell9 = row.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("loginTheme");

        Cell cell10 = row.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue("name");

        Cell cell11 = row.createCell(11);
        cell11.setCellStyle(style);
        cell11.setCellValue("notBefore");

        Cell cell12 = row.createCell(12);
        cell12.setCellStyle(style);
        cell12.setCellValue("passwordPolicy");

        Cell cell13 = row.createCell(13);
        cell13.setCellStyle(style);
        cell13.setCellValue("registrationAllowed");

        Cell cell14 = row.createCell(14);
        cell14.setCellStyle(style);
        cell14.setCellValue("rememberMe");

        Cell cell15 = row.createCell(15);
        cell15.setCellStyle(style);
        cell15.setCellValue("resetPasswordAllowed");

        Cell cell16 = row.createCell(16);
        cell16.setCellStyle(style);
        cell16.setCellValue("social");

        Cell cell17 = row.createCell(17);
        cell17.setCellStyle(style);
        cell17.setCellValue("sslRequired");

        Cell cell18 = row.createCell(18);
        cell18.setCellStyle(style);
        cell18.setCellValue("ssoIdleTimeout");

        Cell cell19 = row.createCell(19);
        cell19.setCellStyle(style);
        cell19.setCellValue("ssoMaxLifespan");

        Cell cell20 = row.createCell(20);
        cell20.setCellStyle(style);
        cell20.setCellValue("updateProfileOnSocLogin");

        Cell cell21 = row.createCell(21);
        cell21.setCellStyle(style);
        cell21.setCellValue("verifyEmail");

        Cell cell22 = row.createCell(22);
        cell22.setCellStyle(style);
        cell22.setCellValue("masterAdminClient");

        Cell cell23 = row.createCell(23);
        cell23.setCellStyle(style);
        cell23.setCellValue("loginLifespan");

        Cell cell24 = row.createCell(24);
        cell24.setCellStyle(style);
        cell24.setCellValue("internationalizationEnabled");

        Cell cell25 = row.createCell(25);
        cell25.setCellStyle(style);
        cell25.setCellValue("defaultLocale");

        Cell cell26 = row.createCell(26);
        cell26.setCellStyle(style);
        cell26.setCellValue("regEmailAsUsername");

        Cell cell27 = row.createCell(27);
        cell27.setCellStyle(style);
        cell27.setCellValue("adminEventsEnabled");

        Cell cell28 = row.createCell(28);
        cell28.setCellStyle(style);
        cell28.setCellValue("adminEventsDetailsEnabled");

        Cell cell29 = row.createCell(29);
        cell29.setCellStyle(style);
        cell29.setCellValue("editUsernameAllowed");

        Cell cell30 = row.createCell(30);
        cell30.setCellStyle(style);
        cell30.setCellValue("otpPolicyCounter");

        Cell cell31 = row.createCell(31);
        cell31.setCellStyle(style);
        cell31.setCellValue("otpPolicyWindow");

        Cell cell32 = row.createCell(32);
        cell32.setCellStyle(style);
        cell32.setCellValue("otpPolicyPeriod");

        Cell cell33 = row.createCell(33);
        cell33.setCellStyle(style);
        cell33.setCellValue("otpPolicyDigits");

        Cell cell34 = row.createCell(34);
        cell34.setCellStyle(style);
        cell34.setCellValue("otpPolicyAlg");

        Cell cell35 = row.createCell(35);
        cell35.setCellStyle(style);
        cell35.setCellValue("otpPolicyType");

        Cell cell36 = row.createCell(36);
        cell36.setCellStyle(style);
        cell36.setCellValue("browserFlow");

        Cell cell37 = row.createCell(37);
        cell37.setCellStyle(style);
        cell37.setCellValue("registrationFlow");

        Cell cell38 = row.createCell(38);
        cell38.setCellStyle(style);
        cell38.setCellValue("directGrantFlow");

        Cell cell39 = row.createCell(39);
        cell39.setCellStyle(style);
        cell39.setCellValue("resetCredentialsFlow");

        Cell cell40 = row.createCell(40);
        cell40.setCellStyle(style);
        cell40.setCellValue("clientAuthFlow");

        Cell cell41 = row.createCell(41);
        cell41.setCellStyle(style);
        cell41.setCellValue("offlineSessionIdleTimeout");

        Cell cell42 = row.createCell(42);
        cell42.setCellStyle(style);
        cell42.setCellValue("revokeRefreshToken");

        Cell cell43 = row.createCell(43);
        cell43.setCellStyle(style);
        cell43.setCellValue("accessTokenLifeImplicit");

        Cell cell44 = row.createCell(44);
        cell44.setCellStyle(style);
        cell44.setCellValue("loginWithEmailAllowed");

        Cell cell45 = row.createCell(45);
        cell45.setCellStyle(style);
        cell45.setCellValue("duplicateEmailsAllowed");

        Cell cell46 = row.createCell(46);
        cell46.setCellStyle(style);
        cell46.setCellValue("dockerAuthFlow");

        Cell cell47 = row.createCell(47);
        cell47.setCellStyle(style);
        cell47.setCellValue("refreshTokenMaxReuse");

        Cell cell48 = row.createCell(48);
        cell48.setCellStyle(style);
        cell48.setCellValue("allowUserManagedAccess");

        Cell cell49 = row.createCell(49);
        cell49.setCellStyle(style);
        cell49.setCellValue("ssoMaxLifespanRememberMe");

        Cell cell50 = row.createCell(50);
        cell50.setCellStyle(style);
        cell50.setCellValue("ssoIdleTimeoutRememberMe");

        Cell cell51 = row.createCell(51);
        cell51.setCellStyle(style);
        cell51.setCellValue("defaultRole");


    }

    private void createCells(List<RealmDto> realmDto, Sheet sheet, CellStyle style) {
        Row row;
        int rownum = 0;

        for (RealmDto realm : realmDto) {
            rownum++;
            row = sheet.createRow(rownum);

            Cell cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(realm.getAccessCodeLifespan());

            Cell cell1 = row.createCell(1);
            cell1.setCellStyle(style);
            cell1.setCellValue(realm.getUserActionLifespan());

            Cell cell2 = row.createCell(2);
            cell2.setCellStyle(style);
            cell2.setCellValue(realm.getAccessTokenLifespan());

            Cell cell3 = row.createCell(3);
            cell3.setCellStyle(style);
            cell3.setCellValue(realm.getAccountTheme());

            Cell cell4 = row.createCell(4);
            cell4.setCellStyle(style);
            cell4.setCellValue(realm.getAdminTheme());

            Cell cell5 = row.createCell(5);
            cell5.setCellStyle(style);
            cell5.setCellValue(realm.getEmailTheme());

            Cell cell6 = row.createCell(6);
            cell6.setCellStyle(style);
            cell6.setCellValue(realm.getEnabled());

            Cell cell7 = row.createCell(7);
            cell7.setCellStyle(style);
            cell7.setCellValue(realm.getEventsEnabled());

            Cell cell8 = row.createCell(8);
            cell8.setCellStyle(style);
            cell8.setCellValue(realm.getEventsExpiration());

            Cell cell9 = row.createCell(9);
            cell9.setCellStyle(style);
            cell9.setCellValue(realm.getLoginTheme());

            Cell cell10 = row.createCell(10);
            cell10.setCellStyle(style);
            cell10.setCellValue(realm.getName());

            Cell cell11 = row.createCell(11);
            cell11.setCellStyle(style);
            cell11.setCellValue(realm.getNotBefore());

            Cell cell12 = row.createCell(12);
            cell12.setCellStyle(style);
            cell12.setCellValue(realm.getPasswordPolicy());

            Cell cell13 = row.createCell(13);
            cell13.setCellStyle(style);
            cell13.setCellValue(realm.getRegistrationAllowed());

            Cell cell14 = row.createCell(14);
            cell14.setCellStyle(style);
            cell14.setCellValue(realm.getRememberMe());

            Cell cell15 = row.createCell(15);
            cell15.setCellStyle(style);
            cell15.setCellValue(realm.getResetPasswordAllowed());

            Cell cell16 = row.createCell(16);
            cell16.setCellStyle(style);
            cell16.setCellValue(realm.getSocial());

            Cell cell17 = row.createCell(17);
            cell17.setCellStyle(style);
            cell17.setCellValue(realm.getSslRequired());

            Cell cell18 = row.createCell(18);
            cell18.setCellStyle(style);
            cell18.setCellValue(realm.getSsoIdleTimeout());

            Cell cell19 = row.createCell(19);
            cell19.setCellStyle(style);
            cell19.setCellValue(realm.getSsoMaxLifespan());

            Cell cell20 = row.createCell(20);
            cell20.setCellStyle(style);
            cell20.setCellValue(realm.getUpdateProfileOnSocLogin());

            Cell cell21 = row.createCell(21);
            cell21.setCellStyle(style);
            cell21.setCellValue(realm.getVerifyEmail());

            Cell cell22 = row.createCell(22);
            cell22.setCellStyle(style);
            cell22.setCellValue(realm.getMasterAdminClient());

            Cell cell23 = row.createCell(23);
            cell23.setCellStyle(style);
            cell23.setCellValue(realm.getLoginLifespan());

            Cell cell24 = row.createCell(24);
            cell24.setCellStyle(style);
            cell24.setCellValue(realm.getInternationalizationEnabled());

            Cell cell25 = row.createCell(25);
            cell25.setCellStyle(style);
            cell25.setCellValue(realm.getDefaultLocale());

            Cell cell26 = row.createCell(26);
            cell26.setCellStyle(style);
            cell26.setCellValue(realm.getRegEmailAsUsername());

            Cell cell27 = row.createCell(27);
            cell27.setCellStyle(style);
            cell27.setCellValue(realm.getAdminEventsEnabled());

            Cell cell28 = row.createCell(28);
            cell28.setCellStyle(style);
            cell28.setCellValue(realm.getAdminEventsDetailsEnabled());

            Cell cell29 = row.createCell(29);
            cell29.setCellStyle(style);
            cell29.setCellValue(realm.getEditUsernameAllowed());

            Cell cell30 = row.createCell(30);
            cell30.setCellStyle(style);
            cell30.setCellValue(realm.getOtpPolicyCounter());

            Cell cell31 = row.createCell(31);
            cell31.setCellStyle(style);
            cell31.setCellValue(realm.getOtpPolicyWindow());

            Cell cell32 = row.createCell(32);
            cell32.setCellStyle(style);
            cell32.setCellValue(realm.getOtpPolicyPeriod());

            Cell cell33 = row.createCell(33);
            cell33.setCellStyle(style);
            cell33.setCellValue(realm.getOtpPolicyDigits());

            Cell cell34 = row.createCell(34);
            cell34.setCellStyle(style);
            cell34.setCellValue(realm.getOtpPolicyAlg());

            Cell cell35 = row.createCell(35);
            cell35.setCellStyle(style);
            cell35.setCellValue(realm.getOtpPolicyType());

            Cell cell36 = row.createCell(36);
            cell36.setCellStyle(style);
            cell36.setCellValue(realm.getBrowserFlow());

            Cell cell37 = row.createCell(37);
            cell37.setCellStyle(style);
            cell37.setCellValue(realm.getRegistrationFlow());

            Cell cell38 = row.createCell(38);
            cell38.setCellStyle(style);
            cell38.setCellValue(realm.getDirectGrantFlow());

            Cell cell39 = row.createCell(39);
            cell39.setCellStyle(style);
            cell39.setCellValue(realm.getResetCredentialsFlow());

            Cell cell40 = row.createCell(40);
            cell40.setCellStyle(style);
            cell40.setCellValue(realm.getClientAuthFlow());

            Cell cell41 = row.createCell(41);
            cell41.setCellStyle(style);
            cell41.setCellValue(realm.getOfflineSessionIdleTimeout());

            Cell cell42 = row.createCell(42);
            cell42.setCellStyle(style);
            cell42.setCellValue(realm.getRevokeRefreshToken());

            Cell cell43 = row.createCell(43);
            cell43.setCellStyle(style);
            cell43.setCellValue(realm.getAccessTokenLifeImplicit());

            Cell cell44 = row.createCell(44);
            cell44.setCellStyle(style);
            cell44.setCellValue(realm.getLoginWithEmailAllowed());

            Cell cell45 = row.createCell(45);
            cell45.setCellStyle(style);
            cell45.setCellValue(realm.getDuplicateEmailsAllowed());

            Cell cell46 = row.createCell(46);
            cell46.setCellStyle(style);
            cell46.setCellValue(realm.getDockerAuthFlow());

            Cell cell47 = row.createCell(47);
            cell47.setCellStyle(style);
            cell47.setCellValue(realm.getRefreshTokenMaxReuse());

            Cell cell48 = row.createCell(48);
            cell48.setCellStyle(style);
            cell48.setCellValue(realm.getAllowUserManagedAccess());

            Cell cell49 = row.createCell(49);
            cell49.setCellStyle(style);
            cell49.setCellValue(realm.getSsoMaxLifespanRememberMe());

            Cell cell50 = row.createCell(50);
            cell50.setCellStyle(style);
            cell50.setCellValue(realm.getSsoIdleTimeoutRememberMe());

            Cell cell51 = row.createCell(51);
            cell51.setCellStyle(style);
            cell51.setCellValue(realm.getDefaultRole());
        }
    }
}
