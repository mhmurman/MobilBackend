FROM maven:3.8.2-openjdk-17
COPY ./ ./
CMD mvn clean install