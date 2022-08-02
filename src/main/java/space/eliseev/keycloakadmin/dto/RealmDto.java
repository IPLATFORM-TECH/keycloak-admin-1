package space.eliseev.keycloakadmin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealmDto {
    private Integer accessCodeLifespan;
    private Integer userActionLifespan;
    private Integer accessTokenLifespan;
    private String accountTheme;
    private String adminTheme;
    private String emailTheme;
    private Boolean enabled;
    private Boolean eventsEnabled;
    private Long eventsExpiration;
    private String loginTheme;
    private String name;
    private Integer notBefore;
    private String passwordPolicy;
    private Boolean registrationAllowed;
    private Boolean rememberMe;
    private Boolean resetPasswordAllowed;
    private Boolean social;
    private String sslRequired;
    private Integer ssoIdleTimeout;
    private Integer ssoMaxLifespan;
    private Boolean updateProfileOnSocLogin;
    private Boolean verifyEmail;
    private String masterAdminClient;
    private Integer loginLifespan;
    private Boolean internationalizationEnabled;
    private String defaultLocale;
    private Boolean regEmailAsUsername;
    private Boolean adminEventsEnabled;
    private Boolean adminEventsDetailsEnabled;
    private Boolean editUsernameAllowed;
    private Integer otpPolicyCounter;
    private Integer otpPolicyWindow;
    private Integer otpPolicyPeriod;
    private Integer otpPolicyDigits;
    private String otpPolicyAlg;
    private String otpPolicyType;
    private String browserFlow;
    private String registrationFlow;
    private String directGrantFlow;
    private String resetCredentialsFlow;
    private String clientAuthFlow;
    private Integer offlineSessionIdleTimeout;
    private Boolean revokeRefreshToken;
    private Integer accessTokenLifeImplicit;
    private Boolean loginWithEmailAllowed;
    private Boolean duplicateEmailsAllowed;
    private String dockerAuthFlow;
    private Integer refreshTokenMaxReuse;
    private Boolean allowUserManagedAccess;
    private Integer ssoMaxLifespanRememberMe;
    private Integer ssoIdleTimeoutRememberMe;
    private String defaultRole;
}
