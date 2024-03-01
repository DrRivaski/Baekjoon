-- 코드를 입력하세요
WITH CARS AS (SELECT CAR_ID, CAR_TYPE, DAILY_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = 'SUV' OR CAR_TYPE = '세단' ORDER BY CAR_ID),
DISCOUNT_RATE AS (SELECT CAR_TYPE, DURATION_TYPE, (100 - DISCOUNT_RATE) / 100 AS DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE DURATION_TYPE = '30일 이상' AND CAR_TYPE IN ('SUV', '세단')),
CARS_DISCOUNT_RATE AS (SELECT * FROM CARS INNER JOIN DISCOUNT_RATE USING(CAR_TYPE)),
NOT_AVAILABLE_CARS AS (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE DATE_FORMAT(START_DATE, "%Y-%m-%d") <= '2022-11-30' AND DATE_FORMAT(END_DATE, "%Y-%m-%d") >= '2022-11-01' GROUP BY CAR_ID ORDER BY CAR_ID)
SELECT CAR_ID, CAR_TYPE, ROUND(DAILY_FEE * DISCOUNT_RATE * 30, 0) AS FEE FROM CARS_DISCOUNT_RATE WHERE CAR_ID NOT IN (SELECT * FROM NOT_AVAILABLE_CARS) GROUP BY CAR_ID HAVING FEE >= 500000 AND FEE < 2000000 ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;