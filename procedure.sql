DELIMITER //

CREATE PROCEDURE insert_employee(
    IN p_name VARCHAR(50),
    IN p_dep VARCHAR(50),
    IN p_desg VARCHAR(50),
    IN p_email VARCHAR(100),
    IN p_salary DOUBLE
)
BEGIN
    INSERT INTO employee (emp_name, dep, desg, email, salary)
    VALUES (p_name, p_dep, p_desg, p_email, p_salary);
END //

DELIMITER ;