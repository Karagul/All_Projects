
USE sakila;
-- 1a
SELECT actor.first_name,actor.last_name FROM actor;

-- 1b
SELECT CONCAT(first_name, ' ' ,last_name) AS 'Actor Name' FROM actor;

-- 2a
SELECT actor.actor_id,first_name,last_name FROM actor WHERE first_name = "Joe";

-- 2b

SELECT actor.first_name,actor.last_name FROM actor WHERE last_name like "%Gen%";

-- 2c
SELECT actor.first_name,actor.last_name FROM actor WHERE last_name like "%LI%" ORDER BY last_name;

-- 2d

SELECT country.country_id,country.country FROM country WHERE country IN ('Afghanistan', 'Bangladesh','China');

-- 3a
ALTER TABLE actor ADD middle_name VARCHAR(30) AFTER first_name;

-- 3b
ALTER TABLE actor MODIFY middle_name BLOB;

-- 3c
ALTER TABLE actor DROP middle_name;

-- 4a

SELECT last_name, COUNT(last_name IS NOT NULL) AS 'Number of actors have same last name' FROM actor WHERE last_name IS NOT NULL GROUP BY last_name;

-- 4b
SELECT last_name, COUNT(last_name IS NOT NULL) AS dupl FROM actor WHERE last_name IS NOT NULL GROUP BY last_name HAVING dupl >= 2;

-- 4c
UPDATE actor SET actor.first_name ='HARPO' where actor.first_name='GROUCHO' AND last_name ='Williams';

 -- TO RECHECK THE RESULT AFTER RUN QUERY
SELECT CONCAT(first_name, ' ' ,last_name) AS 'Actor Name' FROM actor WHERE first_name='HARPO' AND last_name ='Williams';
-- 4d
SET SQL_SAFE_UPDATES = 0;

UPDATE actor SET 
actor.first_name = CASE 
WHEN (actor.first_name ='HARPO' AND actor.last_name ='WILLIAMS') THEN 'GROUCHO' ELSE  'MUCHO GROUCHO' END 
WHERE actor.first_name ='GROUCHO' OR actor.first_name = 'HARPO';

 -- TO RECHECK THE RESULTS AFTER RUN QUERY
SELECT CONCAT(first_name, ' ' ,last_name) AS 'Actor Name' FROM actor WHERE first_name ='MUCHO GROUCHO';
SELECT CONCAT(first_name, ' ' ,last_name) AS 'Actor Name' FROM actor WHERE first_name ='GROUCHO';


-- 5a
SHOW CREATE TABLE address; -- or use EXPLAIN or DESCRIBE 'table' with same result

-- 6a
SELECT staff.first_name,staff.last_name,address FROM staff LEFT JOIN address 
ON staff.address_id = address.address_id; 

-- 6b
SELECT first_name,last_name ,SUM(payment.amount) FROM staff 
JOIN payment ON (staff.staff_id= payment.staff_id) WHERE payment_date LIKE '2005-08%' GROUP BY first_name,last_name;
-- 6c
SELECT film.title,COUNT(film_actor.actor_id) FROM film INNER JOIN film_actor ON
(film.film_id=film_actor.film_id) GROUP BY film.title;
-- 6d
SELECT count(inventory.film_id) AS 'Total `Hunchback Impossible` film exist in the inventory system' FROM inventory LEFT JOIN film ON inventory.film_id =  film.film_id WHERE film.title = 'Hunchback Impossible';

-- 6e
SELECT customer.first_name,customer.last_name,SUM(payment.amount) FROM customer 
LEFT JOIN payment ON customer.customer_id=payment.customer_id GROUP BY payment.customer_id ORDER BY customer.last_name;
-- 7a

SELECT film.title FROM film WHERE (film.title LIKE 'K%' OR film.title LIKE 'Q%') AND film.language_id IN 
(SELECT film.language_id FROM film LEFT JOIN language ON (film.language_id= language.language_id) and language.name = 'English');

-- 7b

SELECT actor.first_name,actor.last_name FROM actor WHERE actor.actor_id IN (
SELECT film_actor.actor_id FROM film_actor WHERE film_actor.film_id IN (
SELECT film.film_id FROM film WHERE film.title='Alone Trip'
)); 

-- 7c
SELECT customer.first_name,customer.last_name,customer.email FROM customer JOIN address
ON (customer.address_id = address.address_id ) JOIN city ON (address.city_id=city.city_id)
JOIN country ON (city.country_id=country.country_id) WHERE country.country='CANADA';

-- 7d
SELECT film.title FROM film JOIN film_category ON (film.film_id=film_category.film_id)
JOIN category ON (film_category.category_id=category.category_id) WHERE category.name='Family';

-- 7e
SELECT inventory.film_id,film.title, count(inventory.film_id) FROM inventory JOIN film ON film.film_id=inventory.film_id
GROUP BY inventory.film_id ORDER BY count(inventory.film_id) DESC;

-- 7f
SELECT store.store_id, CONCAT("$", CAST(sum(payment.amount) AS CHAR)) AS 'Total Revenue in USD' FROM store JOIN staff ON store.store_id= staff.store_id
JOIN payment ON staff.staff_id = payment.staff_id
GROUP BY store.store_id;

-- 7g
SELECT store.store_id,city.city,country.country FROM store JOIN address ON store.address_id=address.address_id JOIN city ON 
address.city_id=city.city_id JOIN country ON city.country_id = country.country_id;

-- 7h

SELECT category.name AS 'The Top Five Genres' ,sum(payment.amount) AS 'Total Revenue' FROM category JOIN film_category ON
category.category_id = film_category.category_id JOIN inventory ON film_category.film_id  = inventory.film_id
JOIN rental ON inventory.inventory_id=rental.inventory_id JOIN payment ON rental.rental_id=payment.rental_id
 GROUP BY category.name ORDER BY 'total revenue' DESC LIMIT 5;

-- 8a
CREATE VIEW The_top_five_genres AS 
SELECT category.name AS 'The Top Five Genres' ,sum(payment.amount) AS 'Total Revenue' FROM category JOIN film_category ON
category.category_id = film_category.category_id JOIN inventory ON film_category.film_id  = inventory.film_id
JOIN rental ON inventory.inventory_id=rental.inventory_id JOIN payment ON rental.rental_id=payment.rental_id
GROUP BY category.name ORDER BY 'total revenue' DESC LIMIT 5;

-- 8b
SELECT * FROM The_top_five_genres;

-- 8c
DROP VIEW The_top_five_genres;
 
