#!/bin/sh
set -e

echo "--- Iniciando banco MySQL ---"
docker-compose up -d mysql

echo "--- Executando migrations Flyway ---"
docker-compose run --rm flyway

trap 'echo "--- Parando banco MySQL ---"; docker-compose down' EXIT

echo "--- Iniciando aplicação Java ---"
docker-compose run --rm app