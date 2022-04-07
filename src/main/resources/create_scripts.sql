
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