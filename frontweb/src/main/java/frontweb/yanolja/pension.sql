CREATE TABLE pension (
NO number(2,0),
name varchar2(100),
numberOfPeople number(2,0),
price number(6,0),
EmptyOfDate varchar2(20),
loc varchar2(50));

INSERT INTO pension VALUES (
1, '사랑펜션', 4, 200000,
'20231110',
'가평'); --6~10일 가능 

INSERT INTO pension VALUES (
2, '희망펜션', 2, 180000,
'20231112',
'가평'); --11,12일 가능

INSERT INTO pension VALUES (
3, '평화펜션', 4, 220000,
'20231112',
'가평'); --6 , 8,10,12

INSERT INTO pension VALUES (
4, '지옥펜션', 6, 150000,
'20231112',
'가평'); --10,11,12 가능 

SELECT * FROM PENSION p ;


SELECT * FROM PENSION p 
WHERE loc LIKE '가평' AND NUMBEROFPEOPLE = 6  
AND EMPTYOFDATE='20231110';