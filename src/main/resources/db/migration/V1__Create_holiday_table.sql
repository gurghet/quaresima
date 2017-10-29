CREATE TABLE holiday (
  uuid UUID DEFAULT RANDOM_UUID(),
  localDay DATE,
  locale VARCHAR(255),
  description VARCHAR(255)
);