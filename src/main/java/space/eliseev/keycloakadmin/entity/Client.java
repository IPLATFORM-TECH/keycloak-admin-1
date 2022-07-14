package space.eliseev.keycloakadmin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends BaseEntity {
    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "full_scope_allowed")
    private boolean fullScopeAllowed;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "not_before")
    private int notBefore;

    @Column(name = "public_client")
    private boolean publicClient;

    @Column(name = "secret")
    private String secret;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "bearer_only")
    private boolean bearerOnly;

    @Column(name = "management_url")
    private String managementUrl;

    @Column(name = "surrogate_auth_required")
    private boolean surrogateAuthRequired;

    @Column(name = "realm_id")
    private String realmId;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "node_rereg_timeout")
    private int nodeReregTimeout;

    @Column(name = "frontchannel_logout")
    private boolean frontchannelLogout;

    @Column(name = "consent_required")
    private boolean consentRequired;

    @Column(name = "name")
    private String name;

    @Column(name = "service_accounts_enabled")
    private boolean serviceAccountsEnabled;

    @Column(name = "client_authenticator_type")
    private String clientAuthenticatorType;

    @Column(name = "root_url")
    private String rootUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "registration_token")
    private String registration_token;

    @Column(name = "standard_flow_enabled")
    private boolean standardFlowEnabled;

    @Column(name = "implicit_flow_enabled")
    private boolean implicit_flow_enabled;

    @Column(name = "direct_access_grants_enabled")
    private boolean direct_access_grants_enabled;

    @Column(name = "always_display_in_console")
    private boolean always_display_in_console;
}
