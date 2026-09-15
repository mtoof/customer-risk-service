CREATE TABLE customers(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar(150) unique NOT NULL,
    created_at timestamptz NOT NULL DEFAULT now()
);