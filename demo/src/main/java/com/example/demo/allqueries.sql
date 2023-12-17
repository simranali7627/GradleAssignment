CREATE DATABASE GRADPROGRAM;
USE GRADPROGRAM;

CREATE TABLE STUDENT(
	DATE INT, 
    MONTH VARCHAR(100), 
    TEAM VARCHAR(100), 
    PANELNAME VARCHAR(100),
    ROUND VARCHAR(100),
    SKILL VARCHAR(100),
    TIME INT,
    CANDIDATECURRENTLOCATION VARCHAR(100),
    CANDIDATEPREFERREDLOCATION VARCHAR(100),
    CANDIDATENAME VARCHAR(100)
    
);
select * from STUDENT;


SELECT
    team,
    COUNT(*) AS interview_count
FROM
    STUDENT
WHERE
    MONTH = "Oct-23" OR MONTH = "Nov-23"
GROUP BY
    team
ORDER BY
    interview_count ASC
LIMIT 1;

/* ANSWER IS BENCH */
/* GBOT */


CREATE VIEW top_skills_view AS
SELECT
    skill,
    COUNT(*) AS skill_count
FROM
    student
WHERE
    MONTH = "Oct-23" OR MONTH = "Nov-23" -- Filter for October and November
    
GROUP BY
    skill;

SELECT
    skill,
    skill_count
FROM
    top_skills_view
ORDER BY
    skill_count DESC
LIMIT 3;



CREATE VIEW peak_time_skills_view AS
SELECT
    skill,
    COUNT(*) AS skill_count
FROM
    student
WHERE
    time BETWEEN 9 AND 17 
GROUP BY
    skill;
    
SELECT
    skill,
    skill_count
FROM
    peak_time_skills_view
ORDER BY
    skill_count DESC
LIMIT 1;
