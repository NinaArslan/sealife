DROP TABLE IF EXISTS OBSERVATION_SHEET;

CREATE TABLE SPECIE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    specie_name VARCHAR(250)
);

CREATE TABLE ANIMAL(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    specie_id BIGINT,
    FOREIGN KEY (specie_id) REFERENCES SPECIE(id)
);

CREATE INDEX IDX_ANIMAL_NAME on ANIMAL (name);

CREATE TABLE OBSERVATION_SHEET (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    island_id VARCHAR(150) NOT NULL,
    island_name VARCHAR(150) NOT NULL,
    distance_from_island INT NOT NULL,
    observation_date DATETIME NOT NULL,
    quality_observation VARCHAR(100)
);

CREATE TABLE OBSERVATION_ANIMAL (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    observation_sheet_id BIGINT NOT NULL,
    animal_id BIGINT NOT NULL,
    size INT,
    is_bank boolean NOT NULL,
    apnea_time INT,
    FOREIGN KEY (animal_id) REFERENCES ANIMAL(id),
    FOREIGN KEY (observation_sheet_id) REFERENCES OBSERVATION_SHEET (id)
)