-- 코드를 입력하세요
-- SELECT * FROM ONLINE_SALE ORDER BY USER_ID;
-- SELECT USER_ID, GENDER FROM USER_INFO WHERE GENDER IS NOT NULL;
-- SELECT *, DATE_FORMAT(SALES_DATE, "%Y") AS YEAR, CAST(DATE_FORMAT(SALES_DATE, "%m") AS UNSIGNED) AS MONTH, USER_ID, GENDER, COUNT(*) AS USERS FROM (SELECT USER_ID, GENDER FROM USER_INFO WHERE GENDER IS NOT NULL) AS USER_INFO NATURAL JOIN ONLINE_SALE GROUP BY YEAR, MONTH, GENDER ORDER BY YEAR, MONTH, GENDER;
SELECT YEAR, MONTH, GENDER, COUNT(*) AS USERS FROM (SELECT DATE_FORMAT(SALES_DATE, "%Y") AS YEAR, CAST(DATE_FORMAT(SALES_DATE, "%m") AS UNSIGNED) AS MONTH, USER_ID, GENDER FROM (SELECT USER_ID, GENDER FROM USER_INFO WHERE GENDER IS NOT NULL) AS USER_INFO NATURAL JOIN ONLINE_SALE GROUP BY YEAR, MONTH, USER_ID) AS T GROUP BY YEAR, MONTH, GENDER ORDER BY YEAR, MONTH, GENDER;
# SELECT DATE_FORMAT(SALES_DATE, "%Y") AS YEAR, CAST(DATE_FORMAT(SALES_DATE, "%m") AS UNSIGNED) AS MONTH, GENDER, SUM(SALES_AMOUNT) AS USERS FROM (SELECT USER_ID, GENDER FROM USER_INFO WHERE GENDER IS NOT NULL) AS USER_INFO NATURAL JOIN ONLINE_SALE 
# GROUP BY YEAR, MONTH, GENDER
# ORDER BY YEAR, MONTH, GENDER;

-- SELECT * FROM ONLINE_SALE ORDER BY SALES_DATE;