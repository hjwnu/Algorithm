-- 코드를 입력하세요
SELECT T1.CAR_ID
    , CASE 
    WHEN SUM(CASE WHEN '2022-10-16' BETWEEN T1.START_DATE AND T1.END_DATE 
             THEN 1 ELSE 0 
             END) = 0
             THEN '대여 가능'
             ELSE '대여중' END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY T1
GROUP BY CAR_ID
ORDER BY CAR_ID DESC