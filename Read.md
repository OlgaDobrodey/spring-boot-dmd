docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=company -p 5432:5432 -d postgres
docker login --username olgadobrodey
docker logout

