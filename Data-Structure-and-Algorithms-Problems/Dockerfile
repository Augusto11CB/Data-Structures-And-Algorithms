# Use the official Ubuntu base image
FROM ubuntu:latest

# Update the package list and install Python
RUN apt-get update && apt-get install -y python3

# Set the working directory
WORKDIR /app

# Copy the Python script into the Docker image
COPY hello.py .

# Run the Python script
CMD ["python3", "hello.py"]