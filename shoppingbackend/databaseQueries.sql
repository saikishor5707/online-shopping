CREATE TABLE category (
  
       id  INT AUTO_INCREMENT,
       name VARCHAR(50),
       description VARCHAR(255),
       image_url VARCHAR(50),
       is_active BOOLEAN,
       
       CONSTRAINT pk_category_id PRIMARY KEY(id)
);

CREATE TABLE user_detail(
  
       id  INT AUTO_INCREMENT,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       role VARCHAR(50),
       enabled BOOLEAN,
       password VARCHAR(60),
       email VARCHAR(100),
       contact_number VARCHAR(15),
       
       CONSTRAINT pk_user_id PRIMARY KEY(id)
);


CREATE TABLE product(
  
       id  INT AUTO_INCREMENT,
       code VARCHAR(20),
       name VARCHAR(50),
       brand VARCHAR(50),
       description VARCHAR(255),
       unit_price DECIMAL(10,2),
       quantity INT,
       is_active BOOLEAN,
       category_id INT,
       supplier_id INT,
       purchases INT DEFAULT 0,
       views INT DEFAULT 0,

       CONSTRAINT pk_product_id PRIMARY KEY(id),
       CONSTRAINT fk_product_category_id FOREIGN KEY(category_id) REFERENCES category(id),
       CONSTRAINT fk_supplier_category_id FOREIGN KEY(supplier_id) REFERENCES user_detail(id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id INT AUTO_INCREMENT
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);
-- the cart line table to store the cart details

CREATE TABLE cart_line (
	id INT AUTO_INCREMENT
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);



============================================================================================
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );

=============================================================================================

INSERT INTO user_detail
 (first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Ravindra','Jadeja','SUPPLIER',true,'$2$10$Id.ZrWxWbjmMSTOp41eDOuEKN9lqka7adlatj20PXQ3uxbkABYSoy','rj@gmail.com','99999999');
INSERT INTO user_detail
 (first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Ravichandra','Ashwin','SUPPLIER',true,'$2$10$af37PJTc1.M8t.9wWS76zuGf99yy3H07/jjOqmu4XvuRLsebLEjK6','ra@gmail.com','7777777777');
INSERT INTO user_detail
 (first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Virat','Kohli','ADMIN',true,'$2b$10$fj.NOp4zH4zf02UfetRyAuEb2ExYX.pYcMtUyJmWekCEBM3242R6i','vk@gmail.com','8888888888');
