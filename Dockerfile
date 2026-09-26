FROM eclipse-temurin:21-jdk AS build

WORKDIR /src

COPY mvnw .
RUN chmod +x mvnw
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline -B

COPY src src
COPY . .
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests -B

FROM eclipse-temurin:21-jre-alpine AS runtime

WORKDIR /app
COPY --from=build /src/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]