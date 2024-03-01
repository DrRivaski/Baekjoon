-- 코드를 작성해주세요
WITH AVG_SCORE AS (SELECT EMP_NO, YEAR, AVG(SCORE) AS SCORE FROM HR_GRADE GROUP BY EMP_NO, YEAR),
AVG_SCORE_GRADE AS (SELECT EMP_NO, YEAR, (CASE 
                                          WHEN SCORE >= 96 THEN 'S'
                                        WHEN SCORE >= 90 AND SCORE < 96 THEN 'A'
                                         WHEN SCORE >= 80 AND SCORE < 90 THEN 'B'
                                         ELSE 'C'
                                         END) AS GRADE FROM AVG_SCORE),
AVG_SCORE_GRADE_RATE AS (SELECT *, (CASE
                                   WHEN GRADE = 'S' THEN 0.2
                                   WHEN GRADE = 'A' THEN 0.15
                                   WHEN GRADE = 'B' THEN 0.1
                                   ELSE 0
                                   END) AS GRADE_RATE FROM AVG_SCORE_GRADE)
SELECT GR.EMP_NO, EMP_NAME, GRADE, E.SAL * GRADE_RATE AS BONUS FROM AVG_SCORE_GRADE_RATE GR INNER JOIN HR_EMPLOYEES E USING(EMP_NO)
ORDER BY EMP_NO;