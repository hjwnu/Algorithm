-- 코드를 입력하세요
SELECT T1.ANIMAL_ID, T1.ANIMAL_TYPE, T1.NAME FROM ANIMAL_INS T1
INNER JOIN ANIMAL_OUTS T2 
    ON T1.ANIMAL_ID = T2.ANIMAL_ID AND T1.SEX_UPON_INTAKE <> T2.SEX_UPON_OUTCOME
WHERE T1.SEX_UPON_INTAKE LIKE ('Intact%')
    