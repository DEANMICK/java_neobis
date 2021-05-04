SELECT name, price FROM
    (SELECT id,name, CASE type WHEN 'A' THEN 20.0
                        WHEN 'B' THEN 70.0
                        ELSE 530.5
                        END AS price
    , DENSE_RANK () OVER(PARTITION BY type 
        ORDER BY id DESC
    ) AS Sums
    FROM products) b
ORDER BY price ASC, Sums ASC;
