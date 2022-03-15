insert into company (id, name)
values (1, 'Apple'),
       (2, 'Google');

SELECT setval('company_id_seq', (SELECT MAX(id) FROM company));

insert into employee (id, first_name, last_name, birth_day, salary, company_id)
values (1, 'Ivan', 'Ivanov', '2022-03-15', 1000, 1),
       (2, 'Petr', 'Petrov', '2022-03-07', 2000, 1);

SELECT setval('employee_id_seq', (SELECT MAX(id) FROM employee))