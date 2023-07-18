-- member 초기
INSERT INTO member (email, password, name, phone_number) VALUES('test1@naver.com', '!As123456', '최낙준', '01012345678');
INSERT INTO member (email, password, name, phone_number) VALUES('test12@naver.com', '!As123456', '최낙준', '01012345679');
INSERT INTO member (email, password, name, phone_number) VALUES('test123@naver.com', '!As123456', '최낙준', '01012345670');
INSERT INTO member (email, password, name, phone_number) VALUES('test1234@naver.com', '!As123456', '최낙준', '01012345671');
INSERT INTO member (email, password, name, phone_number) VALUES('test12345@naver.com', '!As123456', '최낙준', '01012345672');



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


-- Product Review
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(1, 1, '이거 물건입니다!', '진짜 너무 예뻐요!!', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(2, 1, '이거 물건입니다!!!', '진짜 너무 예뻐요!!', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(3, 1, '이거 물건입니다!!!!!', '진짜 너무 예뻐요!!!!!', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(4, 1, '이거 물건입니다!!!!!!!!!!!!', '진짜 너무 예뻐요!!!!!!!!!!!!', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(5, 1, '이거 물건입니다!!!!!!!!!!!!!!', '진짜 너무 예뻐요!!!!!!!!!!!!!', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(1, 2, '이거 물건입니다!', '진짜 너무 예뻐요', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(2, 2, '이거 물건입니다!', '진짜 너무 예뻐요', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(3, 2, '이거 물건입니다!', '진짜 너무 예뻐요', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(4, 2, '이거 물건입니다!', '진짜 너무 예뻐요', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(5, 2, '이거 물건입니다!', '진짜 너무 예뻐요', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(1, 3, '이거 물건입니다!', '진짜 너무 예뻐요', 5);
INSERT INTO product_review (member_id, product_id, title, content, rating) VALUES(2, 3, '이거 물건입니다!', '진짜 너무 예뻐요', 5);
