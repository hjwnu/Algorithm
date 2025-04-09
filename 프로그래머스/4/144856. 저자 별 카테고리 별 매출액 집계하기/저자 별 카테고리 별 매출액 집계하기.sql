-- 코드를 입력하세요
# SELECT 
#     T3.AUTHOR_ID,
#     T3.AUTHOR_NAME,
#     T2.CATEGORY,
#     SUM(T1.SALES)*T2.PRICE AS TOTAL_SALES
# FROM BOOK_SALES T1
#      INNER JOIN BOOK T2 ON T1.BOOK_ID = T2.BOOK_ID
#      INNER JOIN AUTHOR T3 ON T2.AUTHOR_ID = T3.AUTHOR_ID
# WHERE SALES_DATE LIKE '2022-01%'
# GROUP BY T3.AUTHOR_ID, T2.CATEGORY
# ORDER BY T3.AUTHOR_ID ASC, T2.CATEGORY DESC

SELECT
    a.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    SUM(b.PRICE * s.SALES) AS TOTAL_SALES
FROM
    BOOK_SALES s
    INNER JOIN BOOK b ON s.BOOK_ID = b.BOOK_ID
    INNER JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE
    s.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
    a.AUTHOR_ID,
    b.CATEGORY
ORDER BY
    a.AUTHOR_ID ASC,
    b.CATEGORY  DESC;