-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE 
FROM ANIMAL_INS
WHERE LOWER(NAME) IN ('lucy', 'ella', 'pickle', 'rogan', 'sabrina', 'mitty')
ORDER BY ANIMAL_ID