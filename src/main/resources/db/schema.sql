
CREATE TABLE desktop_computers
(
    id              INTEGER PRIMARY KEY,
    series_number   INTEGER,
    manufacturer    TEXT,
    price           INTEGER,
    quantity        INTEGER,
    form_factor     TEXT
);

CREATE TABLE notebooks
(
    id              INTEGER PRIMARY KEY,
    series_number   INTEGER,
    manufacturer    TEXT,
    price           INTEGER,
    quantity        INTEGER,
    size            INTEGER
);

CREATE TABLE monitors
(
    id              INTEGER PRIMARY KEY,
    series_number   INTEGER,
    manufacturer    TEXT,
    price           INTEGER,
    quantity        INTEGER,
    diagonal        INTEGER
);

CREATE TABLE hard_disks
(
    id              INTEGER PRIMARY KEY,
    series_number   INTEGER,
    manufacturer    TEXT,
    price           INTEGER,
    quantity        INTEGER,
    capacity        INTEGER
);