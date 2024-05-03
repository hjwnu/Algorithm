-- 코드를 작성해주세요
SELECT COUNT(T1.FISH_TYPE) AS FISH_COUNT, T2.FISH_NAME FROM FISH_INFO T1
    INNER JOIN FISH_NAME_INFO T2 ON T1.FISH_TYPE = T2.FISH_TYPE
    GROUP BY T2.FISH_NAME ORDER BY FISH_COUNT DESC