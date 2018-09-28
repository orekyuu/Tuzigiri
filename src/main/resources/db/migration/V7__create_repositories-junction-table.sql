-- repositoriesとlanguagesの中間テーブル
CREATE TABLE repository_languages
(
    repository_id int NOT NULL,
    language_id int NOT NULL,
    CONSTRAINT repository_languages_repository_id_language_id_pk PRIMARY KEY (repository_id, language_id),
    CONSTRAINT repository_languages_repositories_id_fk FOREIGN KEY (repository_id) REFERENCES repositories (id),
    CONSTRAINT repository_languages_languages_id_fk FOREIGN KEY (language_id) REFERENCES languages (id)
);

-- repositoriesとframeworkの中間テーブル
CREATE TABLE repository_frameworks
(
    repository_id int NOT NULL,
    framework_id int NOT NULL,
    CONSTRAINT repository_frameworks_repository_id_framework_id_pk PRIMARY KEY (repository_id, framework_id),
    CONSTRAINT repository_frameworks_repositories_id_fk FOREIGN KEY (repository_id) REFERENCES repositories (id),
    CONSTRAINT repository_frameworks_frameworks_id_fk FOREIGN KEY (framework_id) REFERENCES frameworks (id)
);

-- repositoriesにrepository_typeのリレーションを追加
ALTER TABLE repositories ADD repository_type_id int NOT NULL;
ALTER TABLE repositories ADD CONSTRAINT repositories_repository_types_id_fk FOREIGN KEY (repository_type_id) REFERENCES repository_types (id);
