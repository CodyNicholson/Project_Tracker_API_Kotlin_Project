SELECT * FROM pg_extension;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS project_task;
DROP TABLE IF EXISTS project;

CREATE TABLE IF NOT EXISTS project (
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(50) NOT NULL,
    description TEXT,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP,
    deployedLink VARCHAR(100),
    documentationLink VARCHAR(100),
    codeLink VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS project_task (
    id UUID DEFAULT uuid_generate_v4(),
    project_id UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    acceptanceCriteria TEXT,
    points NUMERIC(3,1),
    status VARCHAR(50),
    PRIMARY KEY (id),
    CONSTRAINT fk_project
        FOREIGN KEY(project_id)
            REFERENCES project(id)
);
