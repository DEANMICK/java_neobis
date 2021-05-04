SELECT customers.name 
FROM customers 
WHERE customers.id in (SELECT id_customers FROM legal_person);
