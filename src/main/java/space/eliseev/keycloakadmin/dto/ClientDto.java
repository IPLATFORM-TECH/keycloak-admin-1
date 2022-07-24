package space.eliseev.keycloakadmin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
    private Boolean enabled;
    private Boolean fullScopeAllowed;
    private String clientId;
    private Integer notBefore;
    private Boolean publicClient;
    private String secret;
    private String baseUrl;
    private Boolean bearerOnly;
    private String managementUrl;
    private Boolean surrogateAuthRequired;
    private String protocol;
    private Integer nodeReregTimeout;
    private Boolean frontchannelLogout;
    private Boolean consentRequired;
    private String name;
    private Boolean serviceAccountsEnabled;
    private String clientAuthenticatorType;
    private String rootUrl;
    private String description;
    private String registrationToken;
    private Boolean standardFlowEnabled;
    private Boolean implicitFlowEnabled;
    private Boolean directAccessGrantsEnabled;
    private Boolean alwaysDisplayInConsole;
}


