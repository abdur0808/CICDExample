# Use official OpenJDK image as base
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy compiled Java app or source and jar
COPY ./target/*.jar /app

# expose the port where spring boot app run
EXPOSE 8080
# Run the application
CMD ["java", "-jar", "*.jar"]
