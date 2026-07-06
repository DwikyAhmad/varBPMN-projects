#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE bankaccount_product_mybank' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'bankaccount_product_mybank') \gexec" | psql "postgresql://:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://:@localhost/bankaccount_product_mybank"
done

java -cp bankaccount.product.mybank --module-path bankaccount.product.mybank -m bankaccount.product.mybank &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait