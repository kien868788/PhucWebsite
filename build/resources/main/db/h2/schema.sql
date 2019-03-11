CREATE TABLE IF NOT EXISTS users (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL,
  password BINARY(60) NOT NULL,
  firstName VARCHAR(100),
  lastName VARCHAR(100),
  email VARCHAR(100),
  gender CHAR(1),
  avatar TEXT,
  PRIMARY KEY (id),
  unique (username)
);


CREATE TABLE IF NOT EXISTS roles (
  id INT NOT NULL AUTO_INCREMENT,
  role VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  unique (role)
);

CREATE TABLE IF NOT EXISTS user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  unique (user_id,role_id)
);