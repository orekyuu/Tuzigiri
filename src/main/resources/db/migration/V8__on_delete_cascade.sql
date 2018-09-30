ALTER TABLE repository_frameworks DROP FOREIGN KEY repository_frameworks_repositories_id_fk;
ALTER TABLE repository_frameworks ADD CONSTRAINT repository_frameworks_repositories_id_fk FOREIGN KEY (repository_id) REFERENCES repositories (id) ON DELETE CASCADE;

ALTER TABLE repository_languages DROP FOREIGN KEY repository_languages_repositories_id_fk;
ALTER TABLE repository_languages ADD CONSTRAINT repository_languages_repositories_id_fk FOREIGN KEY (repository_id) REFERENCES repositories (id) ON DELETE CASCADE;