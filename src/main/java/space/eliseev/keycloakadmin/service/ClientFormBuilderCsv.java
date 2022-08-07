package space.eliseev.keycloakadmin.service;

import com.opencsv.CSVWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.ClientDto;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientFormBuilderCsv implements ClientFormBuilder {
    @Override
    public byte[] download(@NonNull List<ClientDto> clients) {
        byte[] clientList = null;
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream();
             OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
             CSVWriter writer = new CSVWriter(streamWriter)) {

            List<String> client = Arrays.asList(
                    "enabled",
                    "full_scope_allowed",
                    "client_id",
                    "not_before",
                    "public_client",
                    "secret",
                    "base_url",
                    "bearer_only",
                    "management_url",
                    "surrogate_auth_required",
                    "protocol",
                    "node_rereg_timeout",
                    "frontchannel_logout",
                    "consent_required",
                    "name",
                    "service_accounts_enabled",
                    "client_authenticator_type",
                    "root_url",
                    "description",
                    "registration_token",
                    "standard_flow_enabled",
                    "implicit_flow_enabled",
                    "direct_access_grants_enabled",
                    "always_display_in_console");

            writer.writeNext(client.toArray(new String[0]));

            for (ClientDto clientDto : clients) {
                client = Arrays.asList(
                        String.valueOf(clientDto.getEnabled()),
                        String.valueOf(clientDto.getFullScopeAllowed()),
                        clientDto.getClientId(),
                        String.valueOf(clientDto.getNotBefore()),
                        String.valueOf(clientDto.getPublicClient()),
                        clientDto.getSecret(),
                        clientDto.getBaseUrl(),
                        String.valueOf(clientDto.getBearerOnly()),
                        clientDto.getManagementUrl(),
                        String.valueOf(clientDto.getSurrogateAuthRequired()),
                        clientDto.getProtocol(),
                        String.valueOf(clientDto.getNodeReregTimeout()),
                        String.valueOf(clientDto.getFrontchannelLogout()),
                        String.valueOf(clientDto.getConsentRequired()),
                        String.valueOf(clientDto.getName()),
                        String.valueOf(clientDto.getServiceAccountsEnabled()),
                        clientDto.getClientAuthenticatorType(),
                        clientDto.getRootUrl(),
                        clientDto.getDescription(),
                        clientDto.getRegistrationToken(),
                        String.valueOf(clientDto.getStandardFlowEnabled()),
                        String.valueOf(clientDto.getImplicitFlowEnabled()),
                        String.valueOf(clientDto.getDirectAccessGrantsEnabled()),
                        String.valueOf(clientDto.getAlwaysDisplayInConsole()));
                writer.writeNext(client.toArray(new String[0]));
            }
            writer.flush();
            clientList = stream.toByteArray();
        } catch (IOException e) {
            log.error("I/O operation error");
        }
        return clientList;
    }
}
