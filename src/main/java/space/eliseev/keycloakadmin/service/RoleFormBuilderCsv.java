package space.eliseev.keycloakadmin.service;

import liquibase.repackaged.com.opencsv.ICSVWriter;
import liquibase.repackaged.com.opencsv.bean.ColumnPositionMappingStrategy;
import liquibase.repackaged.com.opencsv.bean.StatefulBeanToCsv;
import liquibase.repackaged.com.opencsv.bean.StatefulBeanToCsvBuilder;
import liquibase.repackaged.com.opencsv.exceptions.CsvDataTypeMismatchException;
import liquibase.repackaged.com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import liquibase.util.csv.CSVWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.RoleDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleFormBuilderCsv implements RoleFormBuilder {

    @Override
    public byte[] download(@NonNull List<RoleDto> roleDtoList) {

        byte[] arr = new byte[0];

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(baos))) {

            ColumnPositionMappingStrategy<RoleDto> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(RoleDto.class);

            String [] columns = new String[] {"clientRealmConstraint", "clientRole", "description", "name", "client", "realm"};
            strategy.setColumnMapping(columns);

            StatefulBeanToCsvBuilder<RoleDto> beanToCsvBuilder = new StatefulBeanToCsvBuilder<>((ICSVWriter) csvWriter);
            StatefulBeanToCsv<RoleDto> beanWriter = beanToCsvBuilder.withMappingStrategy(strategy)
                    .build();
            beanWriter.write(roleDtoList);
            csvWriter.flush();
            arr = baos.toByteArray();

        } catch (Exception e) {
            log.error("Failure to download .csv file");
        }

        return arr;
    }
}
