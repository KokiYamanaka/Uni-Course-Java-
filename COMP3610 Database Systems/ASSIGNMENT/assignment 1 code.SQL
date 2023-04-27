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

-- ============================
-- PART 2 - SQL QUERIES
-- ============================

-- get patrons were modified today 
-- SELECT * FROM patrons

-- Q 2.1
SELECT PATRON_ID, substr(UPPER(last_name),0,1) || '' ||
substr(UPPER(FIRST_name),0,1) || '.,' || substr(UPPER(last_name),0,1) || '' ||
substr((last_name),2) AS nameInfo, DOB
FROM patrons ORDER BY last_name;

-- Q 2.2
SELECT  PATRON_ID, CEIL((DOB-sysdate)/365) FROM patrons ORDER BY CEIL((DOB-sysdate)/365) ASC; 

-- Q 2.3  
SELECT  * FROM patrons WHERE PATRON_ID NOT IN (SELECT PATRON_ID FROM transactions); 

-- Q 2.4 
-- insert extra books for test case 
INSERT INTO books (book_id,title,author_last_name, author_first_name, rating) 
VALUES (sequence_1.nextval,'dataBASE 5thEd','Wilthin','Jackson','3');
INSERT INTO books (book_id,title,author_last_name, author_first_name, rating) 
VALUES (sequence_1.nextval,'data base 4thEd','Filthy','Mike','2');
INSERT INTO books (book_id,title,author_last_name, author_first_name, rating) 
VALUES (sequence_1.nextval,'DATAbases 3rdEd','Potty','Jiwwy','1');
INSERT INTO books (book_id,title,author_last_name, author_first_name, rating) 
VALUES (sequence_1.nextval,'dataScience','Long','Matthew','1');

SELECT AUTHOR_FIRST_NAME ,TITLE  FROM books where UPPER(TITLE) LIKE UPPER('%database%')
   OR UPPER(TITLE) LIKE UPPER('%data base%')
   OR UPPER(TITLE) LIKE UPPER('%databases%')
   ORDER BY RATING ASC; 


-- q 2.5 
-- add more transactions
INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date  , transaction_type) 
VALUES (sequence_transaction.nextval,2002,1006, to_date('09-05-22','MM-DD-YY') ,'1');
INSERT INTO transactions (transaction_id , patron_id , book_id  , transaction_date  , transaction_type) 
VALUES (sequence_transaction.nextval,2000,1007, to_date('09-05-22','MM-DD-YY') ,'1');

-- join command -- join 2 tables by their transaction ID, while transaction type is only checking out.
-- also remove duplicated patrons (patrons who have more than 1 checking out)
SELECT  *  FROM transactions
INNER JOIN patrons ON patrons.PATRON_ID=transactions.PATRON_ID WHERE TRANSACTION_TYPE = '1';

-- Q2.6 
SELECT book_id, count(TRANSACTION_ID) from transactions
group by book_id;



-- SELECT * from books where regexp_like(title,'.'); 
-- SELECT book_id, SUBSTR(title, 0, 10) AS new_title   FROM Books;
-- # of transactions
-- select count(*) as number_of_transactions from transactions 
-- inner join books ON books.BOOK_ID = transactions.BOOK_ID;
