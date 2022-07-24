package space.eliseev.keycloakadmin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
    private boolean enabled;
    private boolean fullScopeAllowed;
    private String clientId;
    private int notBefore;
    private boolean publicClient;
    private String secret;
    private String baseUrl;
    private boolean bearerOnly;
    private String managementUrl;
    private boolean surrogateAuthRequired;
    private String protocol;
    private int nodeReregTimeout;
    private boolean frontchannelLogout;
    private boolean consentRequired;
    private String name;
    private boolean serviceAccountsEnabled;
    private String clientAuthenticatorType;
    private String rootUrl;
    private String description;
    private String registrationToken;
    private boolean standardFlowEnabled;
    private boolean implicitFlowEnabled;
    private boolean directAccessGrantsEnabled;
    private boolean alwaysDisplayInConsole;
}


