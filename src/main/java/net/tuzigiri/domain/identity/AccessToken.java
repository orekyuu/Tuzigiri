package net.tuzigiri.domain.identity;

import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Embeddable
public class AccessToken {
    @Column(name = "token_value")
    private final String tokenValue;
    @Column(name = "issued_at")
    private final LocalDateTime issuedAt;
    @Column(name = "expires_at")
    private final LocalDateTime expiresAt;

    public AccessToken(String tokenValue, LocalDateTime issuedAt, LocalDateTime expiresAt) {
        this.tokenValue = tokenValue;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
    }

    public OAuth2AccessToken toAccessToken() {
        ZoneOffset jstOffset = ZoneOffset.ofHours(9);
        return new OAuth2AccessToken(
                OAuth2AccessToken.TokenType.BEARER,
                tokenValue, issuedAt.toInstant(jstOffset),
                expiresAt.toInstant(jstOffset)
        );
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

}
