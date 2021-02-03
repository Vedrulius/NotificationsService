CREATE TABLE notifications (
id SERIAL,
message VARCHAR,
message_id VARCHAR(36),
created_by VARCHAR(40),
modified_by VARCHAR(40),
status VARCHAR(10),
type VARCHAR(5),
created TIMESTAMP DEFAULT now(),
modified TIMESTAMP DEFAULT now(),
PRIMARY KEY (id)
);

