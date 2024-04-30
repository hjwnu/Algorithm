SELECT 
  T1.WRITER_ID AS USER_ID, 
  T2.NICKNAME,
  SUM(CASE WHEN T1.STATUS = 'DONE' THEN T1.PRICE ELSE 0 END) AS TOTAL_SALES
FROM USED_GOODS_BOARD T1
INNER JOIN USED_GOODS_USER T2 ON T1.WRITER_ID = T2.USER_ID
GROUP BY T1.WRITER_ID, T2.NICKNAME
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES 
