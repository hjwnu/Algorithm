-- 코드를 작성해주세요
SELECT T1.ITEM_ID
, T1.ITEM_NAME 
FROM ITEM_INFO T1
    INNER JOIN ITEM_TREE T2 ON (T1.ITEM_ID = T2.ITEM_ID AND T2.PARENT_ITEM_ID IS NULL)
ORDER BY T1.ITEM_ID
    