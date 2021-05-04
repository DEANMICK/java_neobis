SELECT DISTINCT movies.id, movies.name FROM movies
JOIN movies_actors ON movies.id = movies_actors.id_movies
JOIN actors ON actors.id = movies_actors.id_actors
JOIN genres ON movies.id_genres = genres.id
WHERE genres.description = 'Action' AND
(actors.name =  'Marcelo Silva' OR  actors.name = 'Miguel Silva');
