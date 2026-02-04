# ---------- Build stage ----------
FROM public.ecr.aws/docker/library/maven:3.9.6-eclipse-temurin-17
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Runtime stage ----------
FROM public.ecr.aws/docker/library/eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=0 /app/target/hello-world.jar hello-world.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "hello-world.jar"]
