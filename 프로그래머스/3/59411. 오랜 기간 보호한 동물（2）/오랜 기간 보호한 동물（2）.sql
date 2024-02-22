-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.NAME FROM ANIMAL_INS I RIGHT OUTER JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID WHERE I.ANIMAL_ID IS NOT NULL ORDER BY TO_DAYS(O.DATETIME) - TO_DAYS(I.DATETIME) DESC LIMIT 2; 
-- TO_DAYS('2015-05-03') - TO_DAYS('2014-05-02');