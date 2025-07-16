# Write your MySQL query statement below
SELECT 
    a.id as Id
FROM 
    Weather a
JOIN  
    Weather b

on DATEDIFF(a.recordDate, b.recordDate) = 1
WHERE a.temperature > b.temperature;

