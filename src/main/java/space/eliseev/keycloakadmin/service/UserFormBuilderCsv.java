package space.eliseev.keycloakadmin.service;

import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.UserDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFormBuilderCsv implements UserFormBuilder {

    @Override
    public byte[] download(@NonNull List<UserDto> users) {

        byte[] arr = new byte[0];

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(
                     new OutputStreamWriter(baos),
                     ';',
                     ICSVWriter.NO_QUOTE_CHARACTER,
                     ICSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     ICSVWriter.DEFAULT_LINE_END)) {

            String[] header = {
                    "Email",
                    "Email constraint",
                    "Email verified",
                    "Enabled",
                    "Firstname",
                    "Lastname",
                    "Username",
                    "Created timestamp",
                    "Not before"};

            csvWriter.writeNext(header);

            String[] data;
            for (UserDto user : users) {
                data = new String[]{
                        user.getEmail(),
                        user.getEmailConstraint(),
                        String.valueOf(user.getEmailVerified()),
                        String.valueOf(user.getEnabled()),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUsername(),
                        String.valueOf(user.getCreatedTimestamp()),
                        String.valueOf(user.getNotBefore())};
                csvWriter.writeNext(data);
            }

            csvWriter.flush();
            arr = baos.toByteArray();

        } catch (IOException e) {
            log.error("Failure to download csv file");
        }

        return arr;
    }
}
