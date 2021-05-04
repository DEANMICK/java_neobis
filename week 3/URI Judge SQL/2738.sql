SELECT candidate.name, round((math*2+specific*3+project_plan*5)/10, 2) AS AVG 
FROM candidate, score 
WHERE score.candidate_id = candidate.id 
ORDER BY AVG DESC;
