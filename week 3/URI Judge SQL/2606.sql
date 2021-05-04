SELECT products.id, products.name
FROM products
JOIN categories
ON products.id_categories = categories.id
AND caregories.name LIKE 'super%';
