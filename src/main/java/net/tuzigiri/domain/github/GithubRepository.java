package net.tuzigiri.domain.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * @see <a href="https://developer.github.com/v3/repos/#response">github document</a>
 */
public class GithubRepository {
    private final long id;
    private final String name;
    private final String fullName;
    private final boolean isPrivate;
    private final GithubUser owner;
    private final String repositoryUrl;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime pushedAt;
    private final String gitUrl;
    private final String sshUrl;
    private final String cloneUrl;
    private final long size;
    private final long starsCount;
    private final long watchersCount;
    private final long forksCount;
    private final String language;

    @JsonCreator
    public GithubRepository(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("full_name") String fullName,
            @JsonProperty("private") boolean isPrivate,
            @JsonProperty("owner") GithubUser owner,
            @JsonProperty("html_url") String repositoryUrl,
            @JsonProperty("created_at") LocalDateTime createdAt,
            @JsonProperty("updated_at") LocalDateTime updatedAt,
            @JsonProperty("pushed_at") LocalDateTime pushedAt,
            @JsonProperty("git_url") String gitUrl,
            @JsonProperty("ssh_url") String sshUrl,
            @JsonProperty("clone_url") String cloneUrl,
            @JsonProperty("size") long size,
            @JsonProperty("stargazers_count") long starsCount,
            @JsonProperty("watchers_count") long watchersCount,
            @JsonProperty("forks_count") long forksCount,
            @JsonProperty("language") String language) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.isPrivate = isPrivate;
        this.owner = owner;
        this.repositoryUrl = repositoryUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
        this.gitUrl = gitUrl;
        this.sshUrl = sshUrl;
        this.cloneUrl = cloneUrl;
        this.size = size;
        this.starsCount = starsCount;
        this.watchersCount = watchersCount;
        this.forksCount = forksCount;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public GithubUser getOwner() {
        return owner;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getPushedAt() {
        return pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public long getSize() {
        return size;
    }

    public long getStarsCount() {
        return starsCount;
    }

    public long getWatchersCount() {
        return watchersCount;
    }

    public long getForksCount() {
        return forksCount;
    }

    public String getLanguage() {
        return language;
    }
}
