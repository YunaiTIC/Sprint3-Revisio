-- Create the EMPRESA table
CREATE TABLE EMPRESA (
    ID BIGINT PRIMARY KEY,
    DESCRIPTION VARCHAR(255),
    JOB VARCHAR(255),
    LOCATION VARCHAR(255),
    NAME VARCHAR(255)
);

-- Create the OFERTES table with a foreign key referencing EMPRESA and a cascading delete constraint
CREATE TABLE OFERTES (
    EMPRESA_ID BIGINT,
    ID BIGINT,
    DESCRIPTION VARCHAR(255),
    OFFER VARCHAR(255),
    PRIMARY KEY (EMPRESA_ID, ID),
    FOREIGN KEY (EMPRESA_ID) REFERENCES EMPRESA(ID) ON DELETE CASCADE
);

-- Insert data into EMPRESA and OFERTES tables
-- (Your existing insert statements for EMPRESA and OFERTES go here)
