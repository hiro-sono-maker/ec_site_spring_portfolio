CREATE TABLE IF NOT EXISTS users
(
    user_id SERIAL PRIMARY KEY,
    login_id VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products
(
    product_id VARCHAR(255) PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    stock INTEGER NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    image_data BYTEA
);

CREATE TABLE IF NOT EXISTS orders
(
    order_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    order_date TIMESTAMP NOT NULL,

    CONSTRAINT fk_orders_users
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS order_details
(
    detail_id SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    price INTEGER NOT NULL,

    CONSTRAINT fk_order_details_orders
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id),

    CONSTRAINT fk_order_details_products
        FOREIGN KEY (product_id)
        REFERENCES products(product_id)
);