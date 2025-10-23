-- Insert initial patients into patient_tbl
INSERT INTO patient_tbl (name, birth_date, email, gender, created_at)
VALUES
('John', '2000-05-15', 'john@example.com', 'Male', CURRENT_TIMESTAMP),
('Smith', '2001-10-20', 'smith@example.com', 'Female', CURRENT_TIMESTAMP),
('Kitty', '2002-09-25', 'kitty@example.com', 'Male', CURRENT_TIMESTAMP);
