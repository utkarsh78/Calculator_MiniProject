FROM openjdk
COPY ./target/MiniProjectCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java","-jar","MiniProjectCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar"]