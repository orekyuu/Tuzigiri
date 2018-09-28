package net.tuzigiri.domain.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubUser {
    private final String userId;
    private final long id;
    private final String avatarUrl;
    private final String profileUrl;

    @JsonCreator
    public GithubUser(
            @JsonProperty("login") String userId,
            @JsonProperty("id") long id,
            @JsonProperty("avatar_url") String avatarUrl,
            @JsonProperty("html_url") String profileUrl) {
        this.userId = userId;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.profileUrl = profileUrl;
    }

    public String getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }
}
