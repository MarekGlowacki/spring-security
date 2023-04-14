INSERT INTO
    application_user(first_name, last_name, email, password)
VALUES
--     hard
    ('Jan', 'Kowalski', 'superadmin@example.com', '{bcrypt}$2a$10$0j80IOZfEaf/ChsV.XgrhOApkRiNJV6wKQTlAXasW41XYbDRPwswW'),
--     dog.8
    ('John', 'abacki', 'john@example.com', '{MD5}{ZfBRrrS8NtYJincrxHEEH1dOwNFHS/AgwxCPyq6pWjo=}3911b74f88a032ccda4039e5787aff0c'),
--     javaiscool
    ('Marek', 'Zalewski', 'java@example.com', '{argon2}$argon2id$v=19$m=16384,t=2,p=1$f981zvqOoO+j212/LZoXrw$m2LwfxAoTngu7rT7kVopFJgRW2AtmWpk3HXdS4ui6k8');

INSERT INTO
    roles(name, description)
VALUES
    ('ADMIN', 'Ma dostęp do wszystkiego'),
    ('USER', 'Dostęp do odczytu');

INSERT INTO
    user_roles(user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);