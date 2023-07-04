CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    des TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(20) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    PRIMARY KEY (id)
);

--INSERT INTO Content (title, des, status, content_type, date_created)
--VALUES ('My Spring Data Blog Post','A post about sparing data', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);