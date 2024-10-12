-- postgres
-- Create table if it does not exist using CHAR for low_fats and recyclable
CREATE TABLE IF NOT EXISTS Products (
    product_id INT,
    low_fats CHAR(1),
    recyclable CHAR(1)
);

-- Truncate the Products table
TRUNCATE TABLE Products;

-- Insert values into the Products table
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (0, 'Y', 'N');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (1, 'Y', 'Y');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (2, 'N', 'Y');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (3, 'Y', 'Y');
INSERT INTO Products (product_id, low_fats, recyclable) VALUES (4, 'N', 'N');