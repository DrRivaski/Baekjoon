-- 코드를 입력하세요
# SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# WHERE DATE_FORMAT(START_DATE, "%Y-%m-%d") BETWEEN '2022-10-01' AND '2022-10-31'
# GROUP BY CAR_ID;
SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = '세단' AND CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE DATE_FORMAT(START_DATE, "%Y-%m-%d") BETWEEN '2022-10-01' AND '2022-10-31'
GROUP BY CAR_ID)
ORDER BY CAR_ID DESC;