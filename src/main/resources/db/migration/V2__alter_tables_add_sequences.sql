-- Enable UUID extension if not already enabled
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Alter tables to use UUID instead of BIGINT
-- Drop existing constraints and alter column types
ALTER TABLE users DROP CONSTRAINT IF EXISTS users_pkey;
ALTER TABLE users ALTER COLUMN id DROP DEFAULT;
ALTER TABLE users ALTER COLUMN id TYPE UUID USING uuid_generate_v4();
ALTER TABLE users ALTER COLUMN id SET DEFAULT uuid_generate_v4();
ALTER TABLE users ADD PRIMARY KEY (id);

ALTER TABLE foods DROP CONSTRAINT IF EXISTS foods_pkey;
ALTER TABLE foods ALTER COLUMN id DROP DEFAULT;
ALTER TABLE foods ALTER COLUMN id TYPE UUID USING uuid_generate_v4();
ALTER TABLE foods ALTER COLUMN id SET DEFAULT uuid_generate_v4();
ALTER TABLE foods ADD PRIMARY KEY (id);

