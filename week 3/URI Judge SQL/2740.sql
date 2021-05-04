(SELECT concat('Podium: ', team) AS name FROM league ORDER BY position LIMIT 3)
UNION ALL (SELECT concat('Demoted: ', team) FROM league 
WHERE position > (SELECT COUNT(position)-2 FROM league));

