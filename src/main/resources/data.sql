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

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
  ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
  ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
  ('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
  ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
  ('2025-07-05 16:15:00', 'Consultation', 1, 4);