-- 코드를 입력하세요
SELECT T2.PRODUCT_ID, T1.PRODUCT_NAME, (SUM(T2.AMOUNT) * T1.PRICE) AS TOTAL_SALES FROM FOOD_PRODUCT T1 
    INNER JOIN FOOD_ORDER T2 
        ON T1.PRODUCT_ID = T2.PRODUCT_ID AND T2.PRODUCE_DATE LIKE '2022-05%'
GROUP BY PRODUCT_ID 
ORDER BY SUM(T2.AMOUNT) * T1.PRICE DESC, PRODUCT_ID

# SELECT * FROM FOOD_ORDER T2 WHERE YEAR(T2.PRODUCE_DATE) = 2022 AND MONTH(T2.PRODUCE_DATE) = 5
# SELECT * FROM FOOD_PRODUCT