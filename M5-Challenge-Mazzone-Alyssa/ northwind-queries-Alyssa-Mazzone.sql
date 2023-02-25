--What are the categories of products in the database?

Use northwind;
SELECT DISTINCT category
FROM products;

--What products are made by Dell?

Use northwind;
SELECT product_name FROM products WHERE product_name LIKE 'Dell%';

--List all the orders shipped to Pennsylvania.

Use northwind;
SELECT *
FROM orders o
JOIN customers c ON o.customer_id = c.id
WHERE o.ship_state = 'Pennsylvania';

--List the first name and last name of all employees with last names that start with the letter W.

Use northwind;
SELECT first_name, last_name
FROM employees
WHERE last_name LIKE 'W%';

--List all customers from zip codes that start with 55.

Use northwind;
SELECT *
FROM customers
WHERE postal_code LIKE '55%';

--List all customers from zip codes that end with 0.

Use northwind;
SELECT *
FROM customers
WHERE RIGHT(postal_code, 1) = '0';

--List the first name, last name, and email for all customers with a ".org" email address.

Use northwind;
SELECT *
FROM customers
WHERE RIGHT(email, 4) = '.org';

--List the first name, last name, and phone number for all customers from the 202 area code.

Use northwind;
SELECT first_name, last_name, phone
FROM customers
WHERE phone LIKE '1-(202)%';

--List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.

Use northwind;
SELECT first_name, last_name, phone
FROM customers
WHERE phone LIKE '1-(202)%'
ORDER BY last_name, first_name;