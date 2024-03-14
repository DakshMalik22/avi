CREATE TABLE student_classes (
    student CHAR(1),
    class VARCHAR(20)
);

-- Insert the data
INSERT INTO student_classes (student, class) VALUES
    ('A', 'Math'),
    ('B', 'English'),
    ('C', 'Math'),
    ('D', 'Biology'),
    ('E', 'Math'),
    ('F', 'Computer'),
    ('G', 'Math'),
    ('H', 'Math'),
    ('I', 'Math');
    
    -- querry
    select class
    from student_classes
    group by class
    having count(distinct student)>=5;
