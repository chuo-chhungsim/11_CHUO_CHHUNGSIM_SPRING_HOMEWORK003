-- Insert Khmer venue data
INSERT INTO venues (venue_name, location) VALUES
                                              ('ព្រះរាជដំណាក់', 'ភ្នំពេញ'),
                                              ('សាលមន្ទីរតនារាជ', 'សៀមរាប'),
                                              ('អាគារសម្តេចឪ', 'កណ្តាល'),
                                              ('សាលពិព័រណ៍អន្តរជាតិ', 'ភ្នំពេញ'),
                                              ('សាលស្រុកខ្មែរ', 'បាត់ដំបង');

-- Insert Khmer event data
INSERT INTO events (event_name, event_date, venue_id) VALUES
                                                          ('ពិព័រណ៍សិល្បៈខ្មែរ', '2023-11-15', 1),
                                                          ('ការប្រគំតន្ត្រីបុរាណ', '2023-12-05', 2),
                                                          ('សិល្បៈរបាំអប្សរា', '2024-01-20', 3),
                                                          ('ពិព័រណ៍អាហារខ្មែរ', '2024-02-10', 4),
                                                          ('ព្រេងរឿងព្រេងខ្មែរ', '2024-03-08', 5);

-- Insert Khmer attendee data
INSERT INTO attendees (attendee_name, email) VALUES
                                                 ('សុខ សំអាង', 'soksamang@example.com'),
                                                 ('ម៉ៅ សុធារី', 'maosotheary@example.com'),
                                                 ('ហេង សំណាង', 'hengsamnang@example.com'),
                                                 ('ធី បញ្ញា', 'thipanha@example.com'),
                                                 ('វង្ស សុផល', 'vongsophal@example.com'),
                                                 ('នារី សុភាព', 'nearisopheap@example.com'),
                                                 ('រិទ្ធិ វិចិត្រ', 'rithyvicheth@example.com'),
                                                 ('សុខុម ម៉ាលី', 'sokhormaly@example.com');

-- Insert event registrations
INSERT INTO event_attendee (event_id, attendee_id) VALUES
                                                       (1, 1), (1, 3), (1, 5), (1, 7),
                                                       (2, 2), (2, 4), (2, 6), (2, 8),
                                                       (3, 1), (3, 2), (3, 5), (3, 7),
                                                       (4, 3), (4, 4), (4, 6), (4, 8),
                                                       (5, 1), (5, 2), (5, 3), (5, 4);