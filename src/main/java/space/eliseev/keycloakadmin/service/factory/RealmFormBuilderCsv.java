package space.eliseev.keycloakadmin.service.factory;


import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.RealmDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RealmFormBuilderCsv implements RealmFormBuilder {
    @Override
    public byte[] download(@NonNull List<RealmDto> realmDto) {
        byte[] arr = new byte[0];
        String[] columns = new String[]{"accessCodeLifespan", "userActionLifespan", "accessTokenLifespan", "accountTheme", "adminTheme", "emailTheme",
                "enabled", "eventsEnabled", "eventsExpiration", "loginTheme", "name", "notBefore", "passwordPolicy", "registrationAllowed", "rememberMe",
                "resetPasswordAllowed", "social", "sslRequired", "ssoIdleTimeout", "ssoMaxLifespan", "updateProfileOnSocLogin", "verifyEmail", "masterAdminClient",
                "loginLifespan", "internationalizationEnabled", "defaultLocale", "regEmailAsUsername", "adminEventsEnabled", "adminEventsDetailsEnabled", "editUsernameAllowed",
                "otpPolicyCounter", "otpPolicyWindow", "otpPolicyPeriod", "otpPolicyDigits", "otpPolicyAlg", "otpPolicyType",
                "browserFlow", "registrationFlow", "directGrantFlow", "resetCredentialsFlow", "clientAuthFlow", "offlineSessionIdleTimeout", "revokeRefreshToken",
                "accessTokenLifeImplicit", "loginWithEmailAllowed", "duplicateEmailsAllowed", "dockerAuthFlow", "refreshTokenMaxReuse", "allowUserManagedAccess",
                "ssoMaxLifespanRememberMe", "ssoIdleTimeoutRememberMe", "defaultRole"};

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(baos),
                     ';',
                     ICSVWriter.NO_QUOTE_CHARACTER,
                     ICSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     ICSVWriter.DEFAULT_LINE_END)) {

            ColumnPositionMappingStrategy<RealmDto> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(RealmDto.class);
            strategy.setColumnMapping(columns);
            StatefulBeanToCsvBuilder<RealmDto> beanToCsv = new StatefulBeanToCsvBuilder<>(csvWriter);
            StatefulBeanToCsv<RealmDto> beanWriter = beanToCsv
                    .withMappingStrategy(strategy)
                    .build();
            beanWriter.write(realmDto);
            csvWriter.flush();
            arr = baos.toByteArray();

        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            log.error("Failure to download .csv file");
        }
        return arr;
    }
}