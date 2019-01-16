PROJECT_NAME?=twitter_test_api
COMPOSE_FILE?=./Docker/docker-compose.yml

build: stop
	docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} build

run: stop
	@test docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} run up -d

stop:
	@test docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} stop

rm: stop
	@test docker-compose -p ${PROJECT_NAME} -f ${COMPOSE_FILE} rm

test:
	@test docker-compose exec -it ${PROJECT_NAME}_java gradle clean test

ssh:
	docker-compose exec -it ${PROJECT_NAME}_java bash

report:
	docker-compose exec -it ${PROJECT_NAME}_java gradle allureReport && docker-compose exec -it ${PROJECT_NAME}_java gradle allureServe
