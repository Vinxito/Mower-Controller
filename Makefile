.PHONY: all build test ping-mysql

all: build

build:
	@./gradlew build --warning-mode all

test:
	@./gradlew test --warning-mode all

run:
	@./gradlew :run

