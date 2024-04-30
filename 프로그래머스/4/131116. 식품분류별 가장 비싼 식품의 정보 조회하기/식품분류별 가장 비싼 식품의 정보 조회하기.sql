SELECT CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM FOOD_PRODUCT T1
WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    AND PRICE = (
        SELECT MAX(PRICE) 
        FROM FOOD_PRODUCT AS T2
        WHERE T1.CATEGORY = T2.CATEGORY
    )
ORDER BY PRICE DESC

# SELECT * FROM FOOD_PRODUCT
