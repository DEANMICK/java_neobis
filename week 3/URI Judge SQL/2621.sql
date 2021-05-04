SELECT products.name 
FROM products
JOIN providers
ON products.id_providers = providers.id
AND products.amount BETWEEN 10 AND 20
WHERE providers.name LIKE "P%";
