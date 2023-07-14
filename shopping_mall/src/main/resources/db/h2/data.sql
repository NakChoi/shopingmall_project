-- product 초기

INSERT INTO product (name, description, price) VALUES('인형 1', '멋지다', '2000');
INSERT INTO product (name, description, price) VALUES('인형 2', '귀엽다', '2000');
INSERT INTO product (name, description, price) VALUES('인형 3', '쩐다', '2000');
INSERT INTO product (name, description, price) VALUES('키링 1', '멋지다', '2000');
INSERT INTO product (name, description, price) VALUES('키링 2', '귀엽다', '2000');
INSERT INTO product (name, description, price) VALUES('키링 3', '쩐다', '2000');
INSERT INTO product (name, description, price) VALUES('시계 1', '멋지다', '2000');
INSERT INTO product (name, description, price) VALUES('시계 2', '귀엽다', '2000');
INSERT INTO product (name, description, price) VALUES('시계 3', '쩐다', '2000');
INSERT INTO product (name, description, price) VALUES('브릭 1', '멋지다', '2000');
INSERT INTO product (name, description, price) VALUES('브릭 2', '귀엽다', '2000');
INSERT INTO product (name, description, price) VALUES('브릭 3', '쩐다', '2000');
INSERT INTO product (name, description, price) VALUES('컵 1', '멋지다', '2000');
INSERT INTO product (name, description, price) VALUES('컵 2', '귀엽다', '2000');
INSERT INTO product (name, description, price) VALUES('컵 3', '쩐다', '2000');

-- Category 초기


INSERT INTO category (name, seq) VALUES('인형', 1);
INSERT INTO category (name, seq) VALUES('키링', 2);
INSERT INTO category (name, seq) VALUES('시계', 3);
INSERT INTO category (name, seq) VALUES('브릭', 4);
INSERT INTO category (name, seq) VALUES('컵', 4);

-- Product Category

INSERT INTO product_category (category_id, product_id) VALUES( 1, 1 );
INSERT INTO product_category (category_id, product_id) VALUES( 1, 2 );
INSERT INTO product_category (category_id, product_id) VALUES( 1, 3 );

INSERT INTO product_category (category_id, product_id) VALUES(2, 4);
INSERT INTO product_category (category_id, product_id) VALUES(2, 5);
INSERT INTO product_category (category_id, product_id) VALUES(2, 6);

INSERT INTO product_category (category_id, product_id) VALUES(3, 7);
INSERT INTO product_category (category_id, product_id) VALUES(3, 8);
INSERT INTO product_category (category_id, product_id) VALUES(3, 9);

INSERT INTO product_category (category_id, product_id) VALUES(4, 10);
INSERT INTO product_category (category_id, product_id) VALUES(4, 11);
INSERT INTO product_category (category_id, product_id) VALUES(4, 12);

INSERT INTO product_category (category_id, product_id) VALUES(5, 13);
INSERT INTO product_category (category_id, product_id) VALUES(5, 14);
INSERT INTO product_category (category_id, product_id) VALUES(5, 15);

-- Product Size

INSERT INTO product_size (prod_size, product_id) VALUES('S', 1);
INSERT INTO product_size (prod_size, product_id) VALUES('M', 1);
INSERT INTO product_size (prod_size, product_id) VALUES('L', 1);

INSERT INTO product_size (prod_size, product_id) VALUES('S', 2);
INSERT INTO product_size (prod_size, product_id) VALUES('M', 2);
INSERT INTO product_size (prod_size, product_id) VALUES('L', 2);

INSERT INTO product_size (prod_size, product_id) VALUES('S', 3);
INSERT INTO product_size (prod_size, product_id) VALUES('M', 3);
INSERT INTO product_size (prod_size, product_id) VALUES('L', 3);

INSERT INTO product_size (prod_size, product_id) VALUES('F', 4);


-- Product  Image

INSERT INTO product_image (product_id, url, seq) VALUES(1, 'https://aws.s3.test.com/1', '1');
INSERT INTO product_image (product_id, url, seq) VALUES(1, 'https://aws.s3.test.com/2', '2');
INSERT INTO product_image (product_id, url, seq) VALUES(1, 'https://aws.s3.test.com/3', '3');
INSERT INTO product_image (product_id, url, seq) VALUES(1, 'https://aws.s3.test.com/4', '4');
INSERT INTO product_image (product_id, url, seq) VALUES(1, 'https://aws.s3.test.com/5', '5');

INSERT INTO product_image (product_id, url, seq) VALUES(2, 'https://aws.s3.test.com/1', '1');
INSERT INTO product_image (product_id, url, seq) VALUES(2, 'https://aws.s3.test.com/2', '2');
INSERT INTO product_image (product_id, url, seq) VALUES(2, 'https://aws.s3.test.com/3', '3');
INSERT INTO product_image (product_id, url, seq) VALUES(2, 'https://aws.s3.test.com/4', '4');
INSERT INTO product_image (product_id, url, seq) VALUES(2, 'https://aws.s3.test.com/5', '5');

INSERT INTO product_image (product_id, url, seq) VALUES(3, 'https://aws.s3.test.com/1', '1');
INSERT INTO product_image (product_id, url, seq) VALUES(3, 'https://aws.s3.test.com/2', '2');
INSERT INTO product_image (product_id, url, seq) VALUES(3, 'https://aws.s3.test.com/3', '3');
INSERT INTO product_image (product_id, url, seq) VALUES(3, 'https://aws.s3.test.com/4', '4');
INSERT INTO product_image (product_id, url, seq) VALUES(3, 'https://aws.s3.test.com/5', '5');

INSERT INTO product_image (product_id, url, seq) VALUES(4, 'https://aws.s3.test.com/1', '1');
INSERT INTO product_image (product_id, url, seq) VALUES(4, 'https://aws.s3.test.com/2', '2');
INSERT INTO product_image (product_id, url, seq) VALUES(4, 'https://aws.s3.test.com/3', '3');
INSERT INTO product_image (product_id, url, seq) VALUES(4, 'https://aws.s3.test.com/4', '4');
INSERT INTO product_image (product_id, url, seq) VALUES(4, 'https://aws.s3.test.com/5', '5');

INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/1', '1');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/2', '2');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/3', '3');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/4', '4');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/5', '5');

INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/6', '6');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/7', '7');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/8', '8');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/9', '9');
INSERT INTO product_image (product_id, url, seq) VALUES(5, 'https://aws.s3.test.com/10', '10');