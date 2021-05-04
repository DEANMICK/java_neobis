(SELECT name, customers_number FROM lawyers ORDER BY customers_number DESC LIMIT 1)
UNION ALL
(SELECT name, customers_number FROM lawyers ORDER BY customers_number LIMIT 1)
UNION ALL
(SELECT 'Average' AS name, cast(AVG(customers_number) AS int) FROM lawyers);
