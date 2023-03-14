FROM openjdk
COPY ./target/MiniProjectCalculator-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["Java","-cp","MiniProjectCalculator-1.0-SNAPSHOT.jar","org/example/Calculator"]
