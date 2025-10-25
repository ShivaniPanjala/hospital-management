-- Insert initial patients into patient_tbl
INSERT INTO patient (name, birth_date, email, gender, created_at, blood_group)
VALUES
('John', '2000-05-15', 'john@example.com', 'Male', CURRENT_TIMESTAMP, 'B_NEGATIVE'),
('Smith', '2001-10-20', 'smith@example.com', 'Female', CURRENT_TIMESTAMP, 'O_POSITIVE'),
('Hit', '2006-09-25', 'Hey@example.com', 'Male', CURRENT_TIMESTAMP, 'A_POSITIVE'),
('Kitty', '2002-09-25', 'kitty@example.com', 'Male', CURRENT_TIMESTAMP, 'AB_POSITIVE');

INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
    ('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com'),
    ('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com');