SELECT life_registry.name, round(life_registry.omega*1.618, 3) AS "The N Factor" 
FROM life_registry 
INNER JOIN dimensions ON life_registry.dimensions_id = dimensions.id AND dimensions.name IN ('C774', 'C875') AND life_registry.name LIKE 'Richard%' 
ORDER BY "The N Factor";
