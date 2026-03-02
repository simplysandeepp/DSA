SELECT 
    users.user_id as buyer_id,
    users.join_date,
    COALESCE(COUNT(orders.buyer_id),0) as orders_in_2019
FROM users
LEFT JOIN orders ON orders.buyer_id = users.user_id
AND
    EXTRACT(YEAR FROM orders.order_date) = 2019
GROUP BY
    users.user_id, users.join_date