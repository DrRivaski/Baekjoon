-- 코드를 작성해주세요
WITH CODES AS (SELECT SUM(CODE) AS CODE FROM SKILLCODES WHERE NAME IN ('Python', 'C#'))
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME FROM CODES C INNER JOIN DEVELOPERS D ON C.CODE & D.SKILL_CODE > 0
ORDER BY ID;