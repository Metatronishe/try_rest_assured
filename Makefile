PROJECT_NAME?=twitter_test_api
COMPOSE_FILE?=./Docker/docker-compose.yml

aaa:
	docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} build

run:
	@test docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} run up -d

test:
	@test docker-compose exec -it ${PROJECT_NAME}_java gradle clean test

ssh:
	docker-compose exec -it ${PROJECT_NAME}_java bash

report:
	docker-compose exec -it ${PROJECT_NAME}_java allure serve build/allure-results/