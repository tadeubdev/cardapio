-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   name VARCHAR(100),
   email VARCHAR(150)
);

CREATE TABLE foods (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   name VARCHAR(100),
   price DECIMAL(10, 2)
);