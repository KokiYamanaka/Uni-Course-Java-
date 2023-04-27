
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
ALTER TABLE staff035
ADD bonus DECIMAL(10,2);

CREATE TABLE branch001(
    branchCode char(5),
    address VARCHAR(25),
    city  VARCHAR(25),
    phone  VARCHAR(25),
    yearOfOpening number(4),
    managerCode char(5), 
    CONSTRAINT branch_PK2 PRIMARY KEY (branchCode)
);

 

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
VALUES ('S1329', 'Yamanaka','koki','marketing', 'manager',to_date('10-03-1987','MM-DD-YY'),12000,'3','B1234');
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode)
VALUES ('S1330', 'Yamanaka','akito','marketing', 'low-tier employee',to_date('10-03-1987','MM-DD-YY'),12000,'3','B1234');
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode,WORKING_SINCE)
VALUES ('S1341', 'Yamanaka','SEIO','marketing', 'low-tier employee',to_date('10-03-1987','MM-DD-YY'),12000,'3','B1234',to_date('10-03-1987','MM-DD-YY'));
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode,WORKING_SINCE)
VALUES ('S1342', 'Yamanaka','yukako','marketing', 'manager',to_date('10-03-1990','MM-DD-YY'),12000,'3','B1234',to_date('10-03-1987','MM-DD-YY'));
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode,WORKING_SINCE)
VALUES ('S1350', 'Yamanaka','jin','marketing', 'manager',to_date('10-03-1990','MM-DD-YY'),12000,'3','B1234',to_date('10-03-1987','MM-DD-YY'));



SELECT * FROM branch001;
SELECT * FROM staff035;



-- pastManagers
CREATE TABLE pastManagers (
  brancid VARCHAR2(50),
  staffid VARCHAR2(50),
  managerfrom DATE,
  managerTo DATE,
  PRIMARY KEY (brancid, staffid)
);

-- q1
CREATE OR REPLACE TRIGGER update_manager_changed
AFTER UPDATE ON branch001
FOR EACH ROW
DECLARE
   v_reason VARCHAR2(50);  
   v_fname VARCHAR2(50);
   v_lname VARCHAR2(50);
   v_dob DATE;
   v_city VARCHAR2(50);
   v_gender CHAR(1);
BEGIN
     
END;

-- bonus table create
CREATE TABLE bonus(
  bonus_id INT PRIMARY KEY,
  bonus_amount DECIMAL(10, 2),
  bonus_added_date DATE,
  bonus_added_to_ID char(5)
);

-- q5
CREATE SEQUENCE bonus_sequence
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE  check_has_bonus (
  -- worker id and bonus amount as parameter
  p_worker_id staff035.staffNo%TYPE,
  p_bonus  VARCHAR2
)
AS 
   prev_bonus_amount NUMBER; -- store bonus amount
   new_bonus_id NUMBER; -- store bonus new bonus id for bonus transaction 
BEGIN
    SELECT BONUS INTO prev_bonus_amount FROM staff035 WHERE staffNo = p_worker_id;
	SELECT bonus_sequence.NEXTVAL INTO new_bonus_id FROM dual; -- get a new bonus id

	IF prev_bonus_amount IS NULL THEN -- first bonus
        INSERT INTO bonus (bonus_id , bonus_amount , bonus_added_date,bonus_added_to_ID  )
		VALUES (new_bonus_id, TO_NUMBER(p_bonus), sysdate, p_worker_id);
		DBMS_OUTPUT.PUT_LINE('Congratulations on your first bonus!');

    ELSIF prev_bonus_amount < TO_NUMBER(p_bonus) THEN
		INSERT INTO bonus (bonus_id , bonus_amount , bonus_added_date,bonus_added_to_ID  )
		VALUES (new_bonus_id, TO_NUMBER(p_bonus), sysdate, p_worker_id);
		DBMS_OUTPUT.PUT_LINE('Wow! You got the biggest bonus till yet!');
	ELSE
		INSERT INTO bonus (bonus_id , bonus_amount , bonus_added_date,bonus_added_to_ID  )
		VALUES (new_bonus_id, TO_NUMBER(p_bonus), sysdate, p_worker_id);
		DBMS_OUTPUT.PUT_LINE('Enjoy the bonus!!!');
	END IF; 
END;


SELECT * FROM bonus; 
SELECT * FROM staff035; 

-- UPDATE sample data 
UPDATE staff035
SET BONUS = 30
WHERE STAFFNO = 'S1326';

UPDATE staff035
SET BONUS = 56
WHERE STAFFNO = 'S1326';

INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode,WORKING_SINCE,bonus)
VALUES ('S1380', 'Yamanaka','lamda','marketing', 'manager',to_date('10-03-1990','MM-DD-YY'),12000,'3','B1234',to_date('10-03-1987','MM-DD-YY'),99);

-- test case 1, 1st condition
EXEC check_has_bonus('S1327',100); 
-- test case 1, 2nd condition
EXEC check_has_bonus('S1380',1000);  
-- test case 2, 3rd condition check
EXEC check_has_bonus('S1326',30);
 

UPDATE staff035
SET BONUS = 1
WHERE staffNo = 'S1324';

-- <><> Q6 <><> ----  purpose : record past managers for each branch 
CREATE OR REPLACE PROCEDURE newBranchManager (p_staffid IN VARCHAR2, p_branchid IN VARCHAR2)
AS
	retrieved_branchCode varchar(5);
	retrieved_desig varchar(25);
	retrieved_working_manager_since DATE; 
BEGIN
  -- Check if the staff works at the same branch as the p_branchid
    SELECT BRANCHCODE INTO retrieved_branchCode FROM staff035 WHERE staffNo = p_staffid;
	IF retrieved_branchCode != p_branchid THEN
        RAISE_APPLICATION_ERROR(-20001, 'The staff does not work at the same branch.');
    END IF;

  -- Check if the staff's designation is not "manager"
    SELECT DESIG INTO retrieved_desig FROM staff035 WHERE staffNo = p_staffid;
	IF retrieved_desig = 'manager' THEN
        RAISE_APPLICATION_ERROR(-20002, 'The staff is already a manager.');
    END IF;

	-- change staff desig to manager
	UPDATE staff035 SET DESIG = 'manager' WHERE STAFFNO = p_staffid;
	

  -- Insert a record into the pastManagers table
    SELECT WORKING_SINCE INTO retrieved_working_manager_since FROM staff035 WHERE staffNo = p_staffid;
    INSERT INTO pastManagers (brancid, staffid, managerfrom, managerTo)
	VALUES (p_branchid, p_staffid, retrieved_working_manager_since, SYSDATE);

  -- Step 4: Update the branch001 table
    UPDATE branch001 SET managercode = p_staffid WHERE branchCode = p_branchid;

  -- Step 5: Update the staff035 table
  -- Add your code here

  -- Step 6: Commit the transaction
  COMMIT;
END;

-- TEST CASE 0 
SELECT * FROM staff035; 
SELECT * FROM branch001; 
SELECT * FROM pastManagers;
SELECT * FROM bonus; 
    

-- TEST CASE 1 : manager is not working at same branch
UPDATE staff035 -- alter a worker branch code
SET BRANCHCODE = 'B4444'
WHERE STAFFNO = 'S1326';
EXEC newBranchManager('S1326','B1234');
EXEC newBranchManager('S1326','B4444');
-- TEST CASE 1 : staff is not manager
EXEC newBranchManager('S1329','B1234'); -- is mananger
EXEC newBranchManager('S1330','B1234'); -- not mananger
-- TEST CASE 2 : insert record
EXEC newBranchManager('S1342','B1234'); 
-- TEST CASE 3 : set manager code on branch table
EXEC newBranchManager('S1350','B1234'); 
-- test case 4 
EXEC newBranchManager('S1324','B1234'); 

-- additional 
CREATE SEQUENCE branch_managercode_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE pastManagers (
  brancid VARCHAR2(50),
  staffid VARCHAR2(50),
  managerfrom DATE,
  managerTo DATE,
  PRIMARY KEY (brancid, staffid)
);
-- <additional modify on table>
ALTER TABLE staff035
ADD working_since VARCHAR(50)
-- <><> NOTES <><> 
-- idea :  when update is made, trigger auto update main table
-- keep all transactions happening
-- do last question 


SELECT * FROM staff035; 
SELECT * FROM branch001; 
SELECT * FROM pastManagers;
SELECT * FROM bonus;

    
-- <QUESTION 1> - Q1. Create a trigger that will run on update on the branch table when a manager is changed. 
CREATE OR REPLACE TRIGGER update_branch_manager_changed
AFTER UPDATE OF managerCode ON branch001
FOR EACH ROW
BEGIN
  -- Insert the information on the pastManagers table as managerCode, BranchCode, dateFrom, dateTo
  INSERT INTO pastManagers (brancid, staffid, managerfrom, managerTo)
  VALUES (:new.branchCode, :old.managerCode, :old.managersince, sysdate);
END;

-- <QUESTION 1: TEST CASE> 
-- Insert a record into the branch001 table
INSERT INTO branch001 (branchCode, address, city, phone, yearOfOpening, managerCode, managersince)
VALUES ('B100', '123 Main St', 'Seattle', '555-555-1212', 1990, 'M100', to_date('03-10-1990', 'MM-DD-YYYY'));

-- Update the managerCode in the branch001 table
UPDATE branch001
SET managerCode = 'M100', managersince = sysdate
WHERE branchCode = 'B100';

-- Check the pastManagers table to see if the information was inserted
SELECT * FROM pastManagers;

-- <QUESTION 2> - automatically add bonus information to a bonus table every time a bonus is given to a staff member in the staff table.
CREATE SEQUENCE bonus_sequence
START WITH 1
INCREMENT BY 1;
	
CREATE OR REPLACE TRIGGER add_bonus
AFTER UPDATE ON staff035 -- update bonus on staff035
FOR EACH ROW
BEGIN
  -- add bonus amount to bonus table
    INSERT INTO bonus (BONUS_ID, BONUS_AMOUNT, BONUS_ADDED_DATE, BONUS_ADDED_TO_ID)
	VALUES (bonus_sequence.NEXTVAL, :NEW.BONUS, SYSDATE, :NEW.STAFFNO);
END;
-- <QUESTION 2:  TEST CASE> 
UPDATE staff035 SET BONUS = 9994 WHERE STAFFNO = 'S1324';
SELECT * FROM staff035; 
SELECT * FROM bonus; 

-- <QUESTION 3 : sample data> 
INSERT INTO bonus (bonus_id, bonus_amount, bonus_added_date, bonus_added_to_ID)
VALUES (1, 500.00, to_date('10-03-2022','MM-DD-YY'), 'S9998');
INSERT INTO bonus (bonus_id, bonus_amount, bonus_added_date, bonus_added_to_ID)
VALUES (2, 700.00, to_date('10-03-1967','MM-DD-YY'), 'S1008');
INSERT INTO bonus (bonus_id, bonus_amount, bonus_added_date, bonus_added_to_ID)
VALUES (3, 9000.00, to_date('10-03-1968','MM-DD-YY'), 'S1008');

-- <QUESTION 3 : function > - return number of times bonuses received.
CREATE OR REPLACE FUNCTION number_of_times_bonuses_received (
	p_staffId IN staff035.STAFFNO%TYPE
)
RETURN NUMBER
AS
    num_times_bonuses_received NUMBER;
BEGIN 
	SELECT COUNT(BONUS_ID) INTO num_times_bonuses_received FROM bonus WHERE  BONUS_ADDED_TO_ID =  p_staffId ;
	RETURN num_times_bonuses_received;
END;

-- <QUESTION 3 TEST CASE>
SELECT number_of_times_bonuses_received('S1008')  FROM dual; 


-- TEST TABLE>>>>>>>>> 
SELECT * FROM staff035; 
SELECT * FROM branch001; 
SELECT * FROM pastManagers;
SELECT * FROM bonus;

-- <QUESTION 4> - procedure to display bonuses received by an employee
CREATE OR REPLACE PROCEDURE display_bonus_details  (
	p_staffId IN staff035.STAFFNO%TYPE
) AS
    first_name staff035.fname%TYPE;
    last_name staff035.lname%TYPE;
    dept staff035.dept%TYPE;
    doj staff035.joiningDate%TYPE;
    bonus_amount bonus.bonus_amount%TYPE;
    bonus_date bonus.bonus_added_date%TYPE;
    total_bonus NUMBER;
BEGIN
     -- 1) The first name, last name, department, and date of joining of the employee.
	SELECT FNAME,LNAME,DEPT	,JOININGDATE INTO first_name,last_name,dept,doj FROM staff035 WHERE STAFFNO = p_staffId ; 
	DBMS_OUTPUT.PUT_LINE('Bonus Details of ' || first_name || ' ' || last_name || ' from ' || dept || ' since ' || doj);

	-- 2) List of all bonuses the employee has received, listed date wise.
	DECLARE
    CURSOR c_bonus_details IS
    SELECT BONUS_ADDED_DATE, BONUS_AMOUNT FROM bonus WHERE BONUS_ADDED_TO_ID = p_staffId ;
    BEGIN
    OPEN c_bonus_details;
    FETCH c_bonus_details INTO bonus_date, bonus_amount;
    WHILE c_bonus_details%FOUND
    LOOP
    DBMS_OUTPUT.PUT_LINE(bonus_date || ' ' || bonus_amount);
    FETCH c_bonus_details INTO bonus_date, bonus_amount;
    END LOOP;
    CLOSE c_bonus_details;
    END;

	-- 3) Total amount of bonus received
	SELECT SUM(bonus_amount) INTO total_bonus FROM bonus WHERE bonus_added_to_ID = p_staffId;
	DBMS_OUTPUT.PUT_LINE('TOTAL AMOUNT :' || total_bonus);
	-- 4) The total number of bonus transactions
	DBMS_OUTPUT.PUT_LINE('TOTAL TRANSACTIONS OCCURED ?'||number_of_times_bonuses_received(p_staffId));
	
END;
-- <QUESTION 4 TEST CASE>
EXEC display_bonus_details('S1119'); 

-- <QUESTION 4 SAMPLE DATA INSERT>
INSERT INTO staff035 staffNo (staffNo, lname, fname, dept, desig, joiningDate, salary, rating, branchCode,WORKING_SINCE)
VALUES ('S1119', 'jamyson','jin','marketing', 'manager',to_date('10-03-1990','MM-DD-YY'),12000,'3','B1234',to_date('10-03-1987','MM-DD-YY'));
INSERT INTO bonus (bonus_id, bonus_amount, bonus_added_date, bonus_added_to_ID) -- insert bonus 
VALUES (4, 1000, to_date('10-03-1990','MM-DD-YY'), 'S1119');
INSERT INTO bonus (bonus_id, bonus_amount, bonus_added_date, bonus_added_to_ID)
VALUES (5, 1500, to_date('10-03-1990','MM-DD-YY'), 'S1119');
INSERT INTO bonus (bonus_id, bonus_amount, bonus_added_date, bonus_added_to_ID)
VALUES (6, 1500, to_date('10-03-2001','MM-DD-YY'), 'S1119');