CREATE SCHEMA `EventTracker` DEFAULT CHARACTER SET utf8 ;

create database EventTracker;

use EventTracker;

CREATE TABLE IF NOT EXISTS attendee (
attendee_id int(11) NOT NULL AUTO_INCREMENT,
name varchar(31) NOT NULL,
gender varchar(1) DEFAULT NULL,
dateOfBirth DATE DEFAULT NULL,
email varchar(51) NOT NULL,
phone varchar(11) DEFAULT NULL,
PRIMARY KEY (attendee_id),
INDEX idx_attendee_id (attendee_id),
INDEX idx_aname (name)
);

CREATE TABLE IF NOT EXISTS event (
event_id int(11) NOT NULL AUTO_INCREMENT,
name varchar(31) NOT NULL,
date DATE NOT NULL,
location varchar(31) NOT NULL,
duration int(11) DEFAULT NULL,
url varchar(51) DEFAULT NULL,
PRIMARY KEY (event_id),
INDEX idx_event_id (event_id),
INDEX idx_ename (name)
);
