-- create table for branch 
CREATE TABLE branch001(
    branchCode char(5),
    address VARCHAR(25),
    city  VARCHAR(25),
    phone  VARCHAR(25),
    yearOfOpening number(4),
    
    CONSTRAINT branch_PK2 PRIMARY KEY (branchCode)
);

-- create table for staff 
CREATE TABLE staff035(
    staffNo char(5) primary key, 
    lname VARCHAR(25),
    fname  VARCHAR(25),
    dept  VARCHAR(25),
    desig VARCHAR(25),
    joiningDate DATE,
    salary NUMBER,
    rating char(1) CHECK(rating IN ('1','2','3')),
    branchCode char(5),
    
    CONSTRAINT staff_PK2  FOREIGN KEY (branchCode) REFERENCES branch001(branchCode)
);

--  insert 5 data to branch table and print all row
INSERT INTO branch001 (branchCode, address, city, phone,yearOfOpening)
VALUES ('B1234', '1232 Mc Gill', 'Kamloops', '2368898767',2022);
INSERT INTO branch001 (branchCode, address, city, phone,yearOfOpening)
VALUES ('B5555', '1232 Mc West', 'Vancouver', '4343435343',2033);
INSERT INTO branch001 (branchCode, address, city, phone,yearOfOpening)
VALUES ('B4444', 'Kashiwa', 'Toshi city', '499699256',2001);
INSERT INTO branch001 (branchCode, address, city, phone,yearOfOpening)
VALUES ('B3333', 'Wilson Road', 'Sunway city', '434343432',2000);
INSERT INTO branch001 (branchCode, address, city, phone,yearOfOpening)
VALUES ('B7777', 'Maniac Road', 'Chilli city', '122222223',1999);

-- print all entered data for each branch
SELECT * FROM branch001;


--  insert unique 10 data to staff table and print all row
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1324', 'windy','jackson','sales', '12563',to_date('10-01-22','MM-DD-YY'),150000,'1','B1234');
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1325', 'min','tong','computer', '12564',to_date('10-02-2001','MM-DD-YY'),154000,'2','B1234'); 
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1326', 'goodwin','hash','sales', '12565',to_date('10-03-2022','MM-DD-YY'),40000,'2','B1234'); 
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1327', 'fes','mike','sales', '12566',to_date('10-03-1997','MM-DD-YY'),400000,'2','B1234'); 
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1328', 'fes','john','marketing', '12566',to_date('10-03-1987','MM-DD-YY'),12000,'3','B1234'); 

INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1329', 'fes','wendy','marketing', '12566',to_date('10-03-1987','MM-DD-YY'),128000,'3','B1234');
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1370', 'chiho','min','computer', '12545',to_date('10-03-1997','MM-DD-YY'),8000,'3','B1234');
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1331', 'twil','cohen','computer', '12532',to_date('10-03-1997','MM-DD-YY'),80000,'1','B1234');
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1332', 'min','finly','consulting', '12589',to_date('10-03-1997','MM-DD-YY'),80000,'1','B1234');
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1333', 'duck','donald','cleaning', '12575',to_date('10-03-1997','MM-DD-YY'),150,'1','B1234');

-- print all entered data for branch B1234 
SELECT * FROM staff035;

-- add 3 new columns
ALTER TABLE staff035
ADD DOB DATE;

ALTER TABLE staff035
ADD commision NUMBER;

ALTER TABLE staff035
ADD grossSalary NUMBER;

-- question 6
-- a. list all full time employees 
SELECT * FROM staff035 WHERE rating ='1';

-- !ADDTIONAL UPDATE! - update someone to a manager position
UPDATE staff035
SET dept = 'managing'
WHERE staffNo = 'S1370';

-- b. list names of employees who are managers 
SELECT fname, lname  FROM staff035 WHERE dept ='managing';

-- c.	List the names of all employees who joined in last year
-- !ADDTIONAL UPDATE! - update someones joined date to be last year
UPDATE staff035
SET joiningDate =  to_date('10-12-22','MM-DD-YY')
WHERE staffNo = 'S1370';
UPDATE staff035
SET joiningDate = to_date('10-03-22','MM-DD-YY')
WHERE staffNo = 'S1325';

SELECT  fname, lname FROM staff035 WHERE joiningDate >= TO_DATE('01-01-22','MM-DD-YY');

-- d.	List all the manager based on decreasing order of their salary

-- !ADDTIONAL UPDATE! - update someone to a manager position
UPDATE staff035
SET dept = 'managing'
WHERE staffNo = 'S1329';

SELECT  * FROM staff035 WHERE dept = 'managing' ORDER BY salary DESC;
-- SELECT * FROM staff035;

-- e.	Calculate the commission as 5% for managers and 4% for others
-- update for manager
UPDATE staff035
SET commision = salary*0.05
WHERE dept = 'managing';
-- update other than manager
UPDATE staff035
SET commision = salary*0.04
WHERE commision IS NULL;

-- f.	Calculate gross salary as sum of salary and commission
UPDATE staff035
SET grossSalary = salary + commision;

-- g.	Display the estimated retirement date of every employee (based on the retirement age of 65, it should be the last day of that month)

-- g(1) add date of birth to each staff
UPDATE staff035
SET DOB = to_date('10-02-1978','MM-DD-YY')
WHERE staffNo = 'S1324';
UPDATE staff035
SET DOB = to_date('10-05-1988','MM-DD-YY')
WHERE staffNo = 'S1325';
UPDATE staff035
SET DOB = to_date('10-05-1981','MM-DD-YY')
WHERE staffNo = 'S1326';
UPDATE staff035
SET DOB = to_date('12-05-1981','MM-DD-YY')
WHERE staffNo = 'S1327';
UPDATE staff035
SET DOB = to_date('01-05-1971','MM-DD-YY')
WHERE staffNo = 'S1328';

UPDATE staff035
SET DOB = to_date('05-05-1961','MM-DD-YY')
WHERE staffNo = 'S1329';
UPDATE staff035
SET DOB = to_date('05-08-1972','MM-DD-YY')
WHERE staffNo = 'S1333';
UPDATE staff035 
SET DOB = to_date('08-08-1980','MM-DD-YY')
WHERE staffNo = 'S1331';
UPDATE staff035
SET DOB = to_date('08-07-1970','MM-DD-YY')
WHERE staffNo = 'S1332';
UPDATE staff035
SET DOB = to_date('08-06-1971','MM-DD-YY')
WHERE staffNo = 'S1370';
 
-- g(2) calculate employee's retirement date
-- done through by adding 65 years to date of birth also note retirement date is last day of the month 
SELECT last_day(ADD_MONTHS(DOB, 12*65)) FROM staff035; 

-- h.	Display all employees whose ages are greater than 50
SELECT  * FROM staff035 WHERE ROUND((to_date('01-18-2023','MM-DD-YY')-DOB)/365,0) >= 50 ; 

-- i.	Display the employees based on ages (i.e. eldest on top)
SELECT  * FROM staff035  ORDER BY  ROUND((to_date('01-18-2023','MM-DD-YY')-DOB)/365,0)DESC; 

-- j.	List the branches from the oldest to the newest branch. 
SELECT * FROM branch001 ORDER BY yearOfOpening ASC; 


