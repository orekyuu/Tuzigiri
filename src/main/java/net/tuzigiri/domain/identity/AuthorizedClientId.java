package net.tuzigiri.domain.identity;

import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;

import java.util.Objects;

@Embeddable
public class AuthorizedClientId {
    @Column(name = "principal_name")
    private String principalName;
    @Column(name = "registration_id")
    private String registrationId;

    public AuthorizedClientId(String principalName, String registrationId) {
        this.principalName = principalName;
        this.registrationId = registrationId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizedClientId that = (AuthorizedClientId) o;
        return Objects.equals(principalName, that.principalName) &&
                Objects.equals(registrationId, that.registrationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(principalName, registrationId);
    }
}
