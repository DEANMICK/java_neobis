SELECT customers.name, orders.id  FROM customers INNER JOIN orders ON orders.id_customers = customers.id WHERE orders.orders_date < DATE('2016-07-01');
