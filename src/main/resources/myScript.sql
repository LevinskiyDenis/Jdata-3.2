select product_name
from orders
where customer_id in (select id from customers where upper(name) = upper(:name));