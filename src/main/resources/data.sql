CREATE TABLE IF NOT EXISTS position
(
    id serial NOT NULL PRIMARY KEY,
    name character varying(30) NOT NULL UNIQUE
    );

alter table position
    owner to postgres;

CREATE TABLE IF NOT EXISTS employee
(
    id serial NOT NULL PRIMARY KEY,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    position_id integer,
    CONSTRAINT fk_emp_pos FOREIGN KEY (position_id)
    REFERENCES position (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE SET NULL
    );

alter table employee
    owner to postgres;

CREATE TABLE IF NOT EXISTS project
(
    id serial NOT NULL PRIMARY KEY,
    name character varying(30) NOT NULL UNIQUE
    );

alter table project
    owner to postgres;

CREATE TABLE IF NOT EXISTS employee_project
(
    employee_id integer NOT NULL,
    project_id integer NOT NULL,
    CONSTRAINT pk_emp_proj PRIMARY KEY (employee_id, project_id),
    CONSTRAINT fk_emp_emp_proj FOREIGN KEY (employee_id)
    REFERENCES employee (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_proj_emp_proj FOREIGN KEY (project_id)
    REFERENCES project (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );

alter table employee_project
    owner to postgres;