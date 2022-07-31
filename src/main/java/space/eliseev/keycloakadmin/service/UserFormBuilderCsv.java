package space.eliseev.keycloakadmin.service;

import com.opencsv.CSVWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFormBuilderCsv implements UserFormBuilder {

    @Override
    public byte[] download(@NonNull List<User> users) {

        byte[] arr = new byte[0];

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(baos))) {

            String[] header = {
                    "email",
                    "email_constraint",
                    "enabled",
                    "federation_link",
                    "first_name",
                    "last_name",
                    "realm_id",
                    "username",
                    "created_timestamp",
                    "service_account_client_link",
                    "not_before",};

            csvWriter.writeNext(header);

            String[] data;
            for (User user : users) {
                data = new String[]{
                        user.getEmail(),
                        user.getEmailConstraint(),
                        String.valueOf(user.getEnabled()),
                        user.getFederationLink(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getRealmId(),
                        user.getUsername(),
                        String.valueOf(user.getCreatedTimestamp()),
                        user.getServiceAccountClientLink(),
                        String.valueOf(user.getNotBefore())};
                csvWriter.writeNext(data);
            }

            csvWriter.flush();
            arr = baos.toByteArray();

        } catch (IOException e) {
            log.error("Failure to upload csv file");
        }

        return arr;
    }
}
