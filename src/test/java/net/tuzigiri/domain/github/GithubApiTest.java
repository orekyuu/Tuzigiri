package net.tuzigiri.domain.github;

import net.tuzigiri.domain.identity.AccessToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GithubApiTest {

    @Autowired
    private GithubApi service;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testFetchRepository() {
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        //<editor-fold desc="test rest server">
        server.expect(requestTo("https://api.github.com/user/repos")).andRespond(withSuccess("[\n" +
                "  {\n" +
                "    \"id\": 123787484,\n" +
                "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkxMjM3ODc0ODQ=\",\n" +
                "    \"name\": \"Moco-Framework\",\n" +
                "    \"full_name\": \"orekyuu/Moco-Framework\",\n" +
                "    \"private\": false,\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"orekyuu\",\n" +
                "      \"id\": 2792624,\n" +
                "      \"node_id\": \"MDQ6VXNlcjI3OTI2MjQ=\",\n" +
                "      \"avatar_url\": \"https://avatars0.githubusercontent.com/u/2792624?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/orekyuu\",\n" +
                "      \"html_url\": \"https://github.com/orekyuu\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/orekyuu/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/orekyuu/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/orekyuu/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/orekyuu/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/orekyuu/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/orekyuu/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/orekyuu/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/orekyuu/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/orekyuu/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"html_url\": \"https://github.com/orekyuu/Moco-Framework\",\n" +
                "    \"description\": null,\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/orekyuu/Moco-Framework\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/orekyuu/Moco-Framework/deployments\",\n" +
                "    \"created_at\": \"2018-03-04T12:43:10Z\",\n" +
                "    \"updated_at\": \"2018-08-23T13:03:57Z\",\n" +
                "    \"pushed_at\": \"2018-05-27T14:10:19Z\",\n" +
                "    \"git_url\": \"git://github.com/orekyuu/Moco-Framework.git\",\n" +
                "    \"ssh_url\": \"git@github.com:orekyuu/Moco-Framework.git\",\n" +
                "    \"clone_url\": \"https://github.com/orekyuu/Moco-Framework.git\",\n" +
                "    \"svn_url\": \"https://github.com/orekyuu/Moco-Framework\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 353,\n" +
                "    \"stargazers_count\": 8,\n" +
                "    \"watchers_count\": 8,\n" +
                "    \"language\": \"Java\",\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_projects\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"forks_count\": 1,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"archived\": false,\n" +
                "    \"open_issues_count\": 1,\n" +
                "    \"license\": null,\n" +
                "    \"forks\": 1,\n" +
                "    \"open_issues\": 1,\n" +
                "    \"watchers\": 8,\n" +
                "    \"default_branch\": \"master\",\n" +
                "    \"permissions\": {\n" +
                "      \"admin\": true,\n" +
                "      \"push\": true,\n" +
                "      \"pull\": true\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 135037896,\n" +
                "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkxMzUwMzc4OTY=\",\n" +
                "    \"name\": \"Moco-SpringBoot-Sample\",\n" +
                "    \"full_name\": \"orekyuu/Moco-SpringBoot-Sample\",\n" +
                "    \"private\": false,\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"orekyuu\",\n" +
                "      \"id\": 2792624,\n" +
                "      \"node_id\": \"MDQ6VXNlcjI3OTI2MjQ=\",\n" +
                "      \"avatar_url\": \"https://avatars0.githubusercontent.com/u/2792624?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/orekyuu\",\n" +
                "      \"html_url\": \"https://github.com/orekyuu\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/orekyuu/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/orekyuu/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/orekyuu/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/orekyuu/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/orekyuu/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/orekyuu/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/orekyuu/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/orekyuu/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/orekyuu/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"html_url\": \"https://github.com/orekyuu/Moco-SpringBoot-Sample\",\n" +
                "    \"description\": null,\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/orekyuu/Moco-SpringBoot-Sample/deployments\",\n" +
                "    \"created_at\": \"2018-05-27T10:52:19Z\",\n" +
                "    \"updated_at\": \"2018-05-27T10:54:48Z\",\n" +
                "    \"pushed_at\": \"2018-05-27T10:54:47Z\",\n" +
                "    \"git_url\": \"git://github.com/orekyuu/Moco-SpringBoot-Sample.git\",\n" +
                "    \"ssh_url\": \"git@github.com:orekyuu/Moco-SpringBoot-Sample.git\",\n" +
                "    \"clone_url\": \"https://github.com/orekyuu/Moco-SpringBoot-Sample.git\",\n" +
                "    \"svn_url\": \"https://github.com/orekyuu/Moco-SpringBoot-Sample\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 55,\n" +
                "    \"stargazers_count\": 0,\n" +
                "    \"watchers_count\": 0,\n" +
                "    \"language\": \"Java\",\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_projects\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"forks_count\": 0,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"archived\": false,\n" +
                "    \"open_issues_count\": 0,\n" +
                "    \"license\": null,\n" +
                "    \"forks\": 0,\n" +
                "    \"open_issues\": 0,\n" +
                "    \"watchers\": 0,\n" +
                "    \"default_branch\": \"master\",\n" +
                "    \"permissions\": {\n" +
                "      \"admin\": true,\n" +
                "      \"push\": true,\n" +
                "      \"pull\": true\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 134043223,\n" +
                "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkxMzQwNDMyMjM=\",\n" +
                "    \"name\": \"MocoSample\",\n" +
                "    \"full_name\": \"orekyuu/MocoSample\",\n" +
                "    \"private\": false,\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"orekyuu\",\n" +
                "      \"id\": 2792624,\n" +
                "      \"node_id\": \"MDQ6VXNlcjI3OTI2MjQ=\",\n" +
                "      \"avatar_url\": \"https://avatars0.githubusercontent.com/u/2792624?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/orekyuu\",\n" +
                "      \"html_url\": \"https://github.com/orekyuu\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/orekyuu/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/orekyuu/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/orekyuu/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/orekyuu/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/orekyuu/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/orekyuu/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/orekyuu/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/orekyuu/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/orekyuu/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"html_url\": \"https://github.com/orekyuu/MocoSample\",\n" +
                "    \"description\": \"Mocoのサンプルリポジトリです\",\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/orekyuu/MocoSample\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/orekyuu/MocoSample/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/orekyuu/MocoSample/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/orekyuu/MocoSample/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/orekyuu/MocoSample/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/orekyuu/MocoSample/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/orekyuu/MocoSample/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/orekyuu/MocoSample/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/orekyuu/MocoSample/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/orekyuu/MocoSample/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/orekyuu/MocoSample/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/orekyuu/MocoSample/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/orekyuu/MocoSample/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/orekyuu/MocoSample/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/orekyuu/MocoSample/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/orekyuu/MocoSample/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/orekyuu/MocoSample/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/orekyuu/MocoSample/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/orekyuu/MocoSample/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/orekyuu/MocoSample/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/orekyuu/MocoSample/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/orekyuu/MocoSample/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/orekyuu/MocoSample/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/orekyuu/MocoSample/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/orekyuu/MocoSample/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/orekyuu/MocoSample/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/orekyuu/MocoSample/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/orekyuu/MocoSample/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/orekyuu/MocoSample/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/orekyuu/MocoSample/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/orekyuu/MocoSample/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/orekyuu/MocoSample/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/orekyuu/MocoSample/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/orekyuu/MocoSample/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/orekyuu/MocoSample/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/orekyuu/MocoSample/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/orekyuu/MocoSample/deployments\",\n" +
                "    \"created_at\": \"2018-05-19T08:12:12Z\",\n" +
                "    \"updated_at\": \"2018-05-21T14:27:35Z\",\n" +
                "    \"pushed_at\": \"2018-05-21T14:27:34Z\",\n" +
                "    \"git_url\": \"git://github.com/orekyuu/MocoSample.git\",\n" +
                "    \"ssh_url\": \"git@github.com:orekyuu/MocoSample.git\",\n" +
                "    \"clone_url\": \"https://github.com/orekyuu/MocoSample.git\",\n" +
                "    \"svn_url\": \"https://github.com/orekyuu/MocoSample\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 62,\n" +
                "    \"stargazers_count\": 0,\n" +
                "    \"watchers_count\": 0,\n" +
                "    \"language\": \"Java\",\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_projects\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"forks_count\": 0,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"archived\": false,\n" +
                "    \"open_issues_count\": 0,\n" +
                "    \"license\": null,\n" +
                "    \"forks\": 0,\n" +
                "    \"open_issues\": 0,\n" +
                "    \"watchers\": 0,\n" +
                "    \"default_branch\": \"master\",\n" +
                "    \"permissions\": {\n" +
                "      \"admin\": true,\n" +
                "      \"push\": true,\n" +
                "      \"pull\": true\n" +
                "    }\n" +
                "  }\n" +
                "]", MediaType.APPLICATION_JSON));
        //</editor-fold>
        List<GithubRepository> result = service.fetchRepositories(new AccessToken("test", LocalDateTime.now(), LocalDateTime.now()));
        assertThat(result).hasSize(3);
    }
}
