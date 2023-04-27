-- create schemas
-- create table for books
CREATE TABLE books ( 
    book_id int, 
    title varchar(20),  
    author_last_name varchar(20), 
    author_first_name varchar(20), 
    rating char(1)
);  

-- create table for staff
CREATE TABLE
patrons (
    patron_id int,  
    last_name varchar(20), 
    first_name varchar(20), 
    street_address varchar(30), 
    city varchar(10),
    zip char(7)
); 

-- create table for transactions
CREATE TABLE
transactions (
    transaction_id int,
    patron_id int, 
    book_id int, 
    transaction_date date, 
    transaction_type char(1)
);  

-- generate primary keys
-- generate for books 
CREATE SEQUENCE sequence_1
start with 1000
increment by 1; 
-- generate for patrons
CREATE SEQUENCE sequence_patrons
start with 2000
increment by +1; 
-- generate for transaction
CREATE SEQUENCE sequence_transaction
start with 3000
increment by +1; 

-- drop a sequence from database
-- DROP SEQUENCE sequence_patrons;

-- (1) add primary keys (and insert data to table)
-- add 3 books
INSERT INTO books (book_id,title,author_last_name, author_first_name, rating) 
VALUES (sequence_1.nextval,'Java foundations','Patty','Jimmy','1');
INSERT INTO books (book_id,title,author_last_name, author_first_name, rating) 
VALUES (sequence_1.nextval,'Stochastics models','Szim','Peter','2');
INSERT INTO books (book_id,title,author_last_name, author_first_name, rating) 
VALUES (sequence_1.nextval,'Lord of the Rings','Yamanaka','Mike','3');
 
 -- add 3 patrons
INSERT INTO patrons (patron_id ,last_name ,first_name, street_address , city , zip)
VALUES (sequence_patrons.nextval,'noual','patrick','882 apt' ,'Kamloops','V2C6N7');
INSERT INTO patrons (patron_id ,last_name ,first_name, street_address , city , zip)
VALUES (sequence_patrons.nextval,'white','john','886 apt Finly street' ,'Kamloops','V2C2N7'); 
INSERT INTO patrons (patron_id ,last_name ,first_name, street_address , city , zip)
VALUES (sequence_patrons.nextval,'black','hank','596 apt Flying street' ,'Kamloops','V3C8E7');

-- add 3 transactions 
INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date  , transaction_type) 
VALUES (sequence_transaction.nextval,2000,1000, to_date('09-01-22','MM-DD-YY') ,'1');
INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date  , transaction_type) 
VALUES (sequence_transaction.nextval,2001,1001, to_date('09-03-22','MM-DD-YY') ,'2');
INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date  , transaction_type) 
VALUES (sequence_transaction.nextval,2002,1002, to_date('09-05-22','MM-DD-YY') ,'3');
 
-- list all inserted datas
SELECT * FROM books;
SELECT * FROM patrons;
SELECT * FROM transactions;

-- (2) add new columns

-- (2a) add DOB column to patrons table
ALTER TABLE patrons
ADD DOB DATE;
-- insert data to DOB column 
UPDATE patrons -- 1ST
SET DOB = to_date('10-12-71','MM-DD-YY')
WHERE PATRON_ID = '2000';
UPDATE patrons -- 2ND
SET DOB = to_date('07-31-72','MM-DD-YY')
WHERE PATRON_ID = '2001';
UPDATE patrons -- 3RD
SET DOB = to_date('02-27-73','MM-DD-YY')
WHERE PATRON_ID = '2002';

-- (2b) add LAST_MODIFIED and MODIFIED_BY columns to patrons table
ALTER TABLE PATRONS 
ADD LAST_MODIFIED VARCHAR(50);
ALTER TABLE PATRONS 
ADD MODIFIED_BY VARCHAR(10);

-- add 2 patrons
INSERT INTO patrons (patron_id ,last_name ,first_name, street_address , city , zip,DOB, LAST_MODIFIED, MODIFIED_BY)
VALUES (sequence_patrons.nextval,'manham','jew','869 apt john street' ,'Kamloops','V3C8E7',to_date('02-20-68','MM-DD-YY'),TO_CHAR (Sysdate, 'DD-MM-YYYY HH24:MI:SS'),'jew569');

INSERT INTO patrons (patron_id ,last_name ,first_name, street_address , city , zip,DOB, LAST_MODIFIED, MODIFIED_BY)
VALUES (sequence_patrons.nextval,'long','donald','59 apt Jumping street' ,'Kamloops','V3A8W6',to_date('12-20-85','MM-DD-YY'),TO_CHAR (Sysdate, 'DD-MM-YYYY HH24:MI:SS'),'donald81');

-- add 2 new more patrons
INSERT INTO patrons (patron_id ,last_name ,first_name, street_address , city , zip,DOB, LAST_MODIFIED, MODIFIED_BY)
VALUES (sequence_patrons.nextval,'liew','Edward','wild street' ,'Kamloops','V2B8W2',to_date('02-20-89','MM-DD-YY'),TO_CHAR (Sysdate, 'DD-MM-YYYY HH24:MI:SS'),'edward4054');

INSERT INTO patrons (patron_id ,last_name ,first_name, street_address , city , zip,DOB, LAST_MODIFIED, MODIFIED_BY)
VALUES (sequence_patrons.nextval,'feing','watson','Haha street' ,'Kamloops','V3A8O8',to_date('12-12-70','MM-DD-YY'),TO_CHAR (Sysdate, 'DD-MM-YYYY HH24:MI:SS'),'watsonB9');

SELECT * FROM patrons;
SELECT * FROM books;  
ALTER TABLE transactions 
ADD fine_amount int;
ALTER TABLE transactions 
ADD rating  VARCHAR(1);

CREATE OR REPLACE PROCEDURE issueBook (
  p_patron_id    patrons.patron_id%TYPE, 
  p_book_id      books.book_id%TYPE
) AS 
  patron_exists INT;
  book_exists INT;
  transaction_id INT;
  today_date DATE;
BEGIN 
  -- for patron 
  SELECT COUNT(*) INTO patron_exists FROM patrons WHERE patron_id = p_patron_id;   -- check patron exists or not in table 
  IF patron_exists = 0 THEN -- raise an error if patron id is invalid 
     RAISE_APPLICATION_ERROR(-20001, 'you entered an invalid patron ID ');
  END IF;

  -- for book 
  SELECT COUNT(*) INTO book_exists FROM books WHERE book_id = p_book_id AND rating != 1; 
  IF book_exists = 0 THEN
     RAISE_APPLICATION_ERROR(-20002, 'you entered an invalid book ID ');
  END IF;

  transaction_id := sequence_transaction.nextval;
  today_date := sysdate;
  INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date,FINE_AMOUNT,rating) 
  VALUES (sequence_transaction.nextval,p_patron_id,p_book_id, today_date,0,'1');

END;

-- To execute the procedure, you can use the following syntax:
EXEC issueBook(2003,1002 );

SELECT * FROM transactions;  

-- q2 ============================================
UPDATE transactions
SET TRANSACTION_TYPE = '1'
WHERE TRANSACTION_ID = 3021;
 

CREATE OR REPLACE PROCEDURE returnBook (
  p_patron_id    patrons.patron_id%TYPE, 
  p_book_id      books.book_id%TYPE
) AS 
   extract_date DATE;
   fine         NUMBER(8,2);
BEGIN 
  SELECT TRANSACTION_DATE INTO extract_date FROM transactions WHERE TRANSACTION_TYPE = '1' AND  PATRON_ID = p_patron_id AND BOOK_ID = p_book_id; 
  extract_date := extract_date + INTERVAL '7' DAY;
  IF sysdate < extract_date THEN
    fine := (SYSDATE - extract_date) * 3; -- 3 dollar per day fine  
    DBMS_OUTPUT.PUT_LINE(fine);

    INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date,FINE_AMOUNT,rating) 
    VALUES (sequence_transaction.nextval,p_patron_id,p_book_id, sysdate,ABS(fine),'2');

  END IF; 
END; 

EXEC returnBook(2003,1002);
SELECT * FROM transactions;  

-- q3 

CREATE OR REPLACE FUNCTION returnBook2 (
  p_patron_id    patrons.patron_id%TYPE, 
  p_book_id      books.book_id%TYPE
) RETURN NUMBER
AS 
   extract_date DATE;
   fine         NUMBER(8,2);
BEGIN 
  SELECT TRANSACTION_DATE INTO extract_date FROM transactions WHERE TRANSACTION_TYPE = '1' AND  PATRON_ID = p_patron_id AND BOOK_ID = p_book_id; 
  extract_date := extract_date + INTERVAL '7' DAY;
  IF sysdate < extract_date THEN
    fine := (SYSDATE - extract_date) * 3; -- 3 dollar per day fine  
    DBMS_OUTPUT.PUT_LINE(fine);
    RETURN fine; 
  ELSE 
    RETURN 0; 
  END IF; 
  
END; 

SELECT returnBook2(2003,1002) FROM DUAL;

-- q4  

CREATE OR REPLACE PROCEDURE display_books_issued_in_feb
IS
  v_book_id books.book_id%TYPE;
  v_title books.title%TYPE;
  v_author_last_name books.author_last_name%TYPE;
  v_author_first_name books.author_first_name%TYPE;
  v_transaction_date transactions.transaction_date%TYPE;
  
  CURSOR c_books_issued_in_feb IS
    SELECT b.book_id, b.title, b.author_last_name, b.author_first_name, t.transaction_date
    FROM books b
    JOIN transactions t ON b.book_id = t.book_id
    WHERE TO_CHAR(t.transaction_date, 'MM') = '02';
BEGIN

  OPEN c_books_issued_in_feb;
  LOOP
    FETCH c_books_issued_in_feb INTO v_book_id, v_title, v_author_last_name, v_author_first_name, v_transaction_date;
    EXIT WHEN c_books_issued_in_feb%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Book ID: ' || v_book_id || ', Title: ' || v_title || ', Author: ' || v_author_last_name || ', ' || v_author_first_name || ', Transaction Date: ' || v_transaction_date);
  END LOOP;
  CLOSE c_books_issued_in_feb;

END;

INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date  , transaction_type) 
VALUES (sequence_transaction.nextval,2002,1004, to_date('02-05-22','MM-DD-YY') ,'1');
SELECT * FROM transactions;  


EXEC display_books_issued_in_feb; 

 