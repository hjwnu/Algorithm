

SELECT
    e.NAME,
    CASE
        WHEN e.BOSS IS NULL THEN 'CEO'
        WHEN EXISTS (
            SELECT 1 FROM employee_relationships WHERE BOSS = e.NAME
        ) THEN 'MANAGER'
        ELSE 'WORKER'
        END AS BOSS
FROM
    employee_relationships e
ORDER BY
    e.NAME;
