
CREATE TABLE Document (
    study_environment_uuid varchar(255),
    context_uri varchar(255),
    oid varchar(255),
    study varchar(255),
	study_name varchar(255),
	document_type varchar(255),
	document_version varchar(255),
	version_date DATE,
	external_id varchar(255),
	superseded BOOLEAN,
	business_id varchar(255),
	name varchar(255),
	created_at DATE,
	modified_at DATE,
	created_by_uri varchar(255),
	inactive BOOLEAN
);

CREATE TABLE IF NOT EXISTS `dt_document`
(
    `uuid`                           CHAR(36)     NOT NULL,
    `study_uuid`                     CHAR(36)     NOT NULL,
    `study_environment_uuid`         CHAR(36)     NOT NULL,
    `study_environment_country_uuid` CHAR(36),
    `study_environment_site_uuid`    CHAR(36),
    `name`                           VARCHAR(200) NOT NULL,
    `cd_document_type_uuid`          CHAR(36)     NOT NULL,
    `business_id`                    VARCHAR(50)  NOT NULL,
    `version`                        VARCHAR(50),
    `version_date`                   DATE,
    `internal_status_oid`            VARCHAR(50),
    `internal_status_change_date`    DATE,
    `signature_date`                 DATE,
    `expiration_date`                DATE,
    `url`                            LONGTEXT,
    `external_id`                    VARCHAR(100),
    `superseded`                     TINYINT(1) DEFAULT 0,
    `inactive`                       TINYINT(1) DEFAULT 0,
    `deleted`                        TINYINT(1) DEFAULT 0,
    `created_by`                     VARCHAR(100) NOT NULL,
    `created_at`                     DATETIME   DEFAULT NULL,
    `modified_by`                    VARCHAR(100),
    `modified_at`                    DATETIME   DEFAULT NULL,
    PRIMARY KEY (`uuid`),
    CONSTRAINT cd_document_type_fk FOREIGN KEY (`cd_document_type_uuid`) REFERENCES `cd_document_type` (`uuid`)
);

CREATE TABLE IF NOT EXISTS `dt_document_submission`
(
    `uuid`                  CHAR(36)     NOT NULL,
    `document_uuid`         CHAR(36)     NOT NULL,
    `submission_uuid`       CHAR(36)     NOT NULL,
    `planned_date`          DATE,
    `date`                  DATE,
    `approval_planned_date` DATE,
    `approval_date`         DATE,
    `approval_status_oid`   VARCHAR(50),
    `deleted`               TINYINT(1) DEFAULT 0,
    `created_by`            VARCHAR(100) NOT NULL,
    `created_at`            DATETIME   DEFAULT NULL,
    `modified_by`           VARCHAR(100),
    `modified_at`           DATETIME   DEFAULT NULL,
    PRIMARY KEY (`uuid`),
    CONSTRAINT document_fk FOREIGN KEY (`document_uuid`) REFERENCES `document` (`uuid`),
    CONSTRAINT submission_fk FOREIGN KEY (`submission_uuid`) REFERENCES `submission` (`uuid`)
);