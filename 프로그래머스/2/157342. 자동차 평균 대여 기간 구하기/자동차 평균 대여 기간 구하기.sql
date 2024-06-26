-- 코드를 입력하세요
WITH DUR_TABLE AS (SELECT CAR_ID, DATEDIFF(END_DATE, START_DATE) + 1 AS DURATION FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
),
TOTAL_DUR_TABLE AS
(SELECT *, SUM(DURATION) AS TOTAL_DURATION, COUNT(*) AS CNT FROM DUR_TABLE GROUP BY CAR_ID ORDER BY CAR_ID)
-- SELECT * FROM TOTAL_DUR_TABLE;

SELECT CAR_ID, ROUND(TOTAL_DURATION / CNT, 1) AS AVERAGE_DURATION FROM TOTAL_DUR_TABLE WHERE ROUND(TOTAL_DURATION / CNT , 2) >= 7 ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;
-- SELECT CAR_ID, DATEDIFF(END_DATE, START_DATE) + 1 AS DURATION FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY ORDER BY CAR_ID;
-- SELECT * FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY ORDER BY CAR_ID;