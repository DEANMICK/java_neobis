SELECT CONCAT(substr(CPF,1,3),'.', substr(CPF,4,3),'.', substr(CPF,7,3),'-', substr(CPF,10,2)) AS CPF FROM natural_person;
