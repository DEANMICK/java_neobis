SELECT name, cast(extract(day FROM payday) AS int) FROM loan;
