
CREATE TABLE product (
  id int NOT NULL AUTO_INCREMENT,
  price int,
  name varchar(100) NOT NULL,
  fk_categories_id int,
  created_at TIMESTAMP,
  PRIMARY KEY (id)
) ;

CREATE TABLE category (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  created_at TIMESTAMP,
  PRIMARY KEY (id)
) ;
ALTER TABLE product ADD FOREIGN KEY ( fk_categories_id ) REFERENCES category( id ) ;

INSERT INTO category (id, name)
VALUES (1, 'Electronic');

INSERT INTO product (id, name, price, fk_categories_id)
VALUES (1, 'Notebook', 44, 1);



