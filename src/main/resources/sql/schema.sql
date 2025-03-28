-- Create venues table with cascade protection
CREATE TABLE IF NOT EXISTS venues (
                                      venue_id SERIAL PRIMARY KEY,
                                      venue_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
    );

-- Create events table with cascade rules
CREATE TABLE IF NOT EXISTS events (
                                      event_id SERIAL PRIMARY KEY,
                                      event_name VARCHAR(255) NOT NULL,
    event_date DATE NOT NULL,
    venue_id INTEGER NOT NULL,
    FOREIGN KEY (venue_id)
    REFERENCES venues(venue_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

-- Create attendees table
CREATE TABLE IF NOT EXISTS attendees (
                                         attendee_id SERIAL PRIMARY KEY,
                                         attendee_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    );


-- Create junction table with cascade rules
CREATE TABLE IF NOT EXISTS event_attendee (
                                              id SERIAL PRIMARY KEY,
                                              event_id INTEGER NOT NULL,
                                              attendee_id INTEGER NOT NULL,
                                              FOREIGN KEY (event_id)
    REFERENCES events(event_id)
    ON UPDATE CASCADE,
    FOREIGN KEY (attendee_id)
    REFERENCES attendees(attendee_id)
    ON UPDATE CASCADE,
    UNIQUE (event_id, attendee_id)
    );
