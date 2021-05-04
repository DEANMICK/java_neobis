SELECT movies.id, movies.name 
FROM movies 
JOIN genres 
ON movies.id_genres = genres.id AND genres.description = 'Action';
