-- 코드를 입력하세요
WITH DUR_TABLE AS (SELECT CAR_ID, CAR_TYPE, DAILY_FEE, HISTORY_ID, DATEDIFF(END_DATE, START_DATE) + 1 AS DURATION FROM CAR_RENTAL_COMPANY_CAR JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY USING(CAR_ID) WHERE CAR_TYPE = '트럭'),
DUR_TYPE_TABLE AS (SELECT *, (
CASE
    WHEN DURATION > 0 AND DURATION < 7 THEN NULL
    WHEN DURATION >= 7 AND DURATION < 30 THEN '7일 이상'
    WHEN DURATION >= 30 AND DURATION < 90 THEN '30일 이상'
    ELSE '90일 이상'
END) AS DURATION_TYPE
FROM DUR_TABLE),
DISCOUNT_PLAN AS (
SELECT DURATION_TYPE, DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭')
SELECT HISTORY_ID, ROUND(DAILY_FEE * DURATION * (100 - IFNULL(DISCOUNT_RATE, 0)) / 100, 0) AS FEE FROM DUR_TYPE_TABLE D LEFT OUTER JOIN DISCOUNT_PLAN P 
ON D.DURATION_TYPE = P.DURATION_TYPE ORDER BY FEE DESC, HISTORY_ID DESC;
-- SELECT * FROM DISCOUNT_RATE;
-- SELECT HISTORY_ID, (DAILY_FEE * DISCOUNT_RATE)

-- SELECT CAR_ID, CAR_TYPE, HISTORY_ID, DATEDIFF(END_DATE, START_DATE) + 1 AS DURATION FROM CAR_RENTAL_COMPANY_CAR JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY USING(CAR_ID) WHERE CAR_TYPE = '트럭'