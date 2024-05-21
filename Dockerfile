
#*************************************** Special ---------------------------------------
FROM openjdk:17-alpine
#
# Set the working direkictory
WORKDIR /usr/src/app

# Install Tesseract OCR and other required dependencies
RUN apk update && \
    apk add tesseract-ocr

# Install Wine
RUN apk add --no-cache wine

# Set the Tesseract OCR executable path
ENV TESSDATA_PREFIX=/usr/share/tesseract-ocr/tessdata/

# Create the output directory for the OCR results
RUN mkdir -p src/main/java/com/card/card/write/

# Copy Tesseract OCR directory from host machine into Docker image
COPY Tesseract-OCR /usr/share/tesseract-ocr/

# Copy the application JAR file
COPY ./target/card.jar ./

## Define a volume for Python dependencies
VOLUME /usr/src/app/python_dependencies

# Command to run the Java application
ENTRYPOINT ["java", "-jar", "card.jar"]







#FROM openjdk:17-alpine
#
## Set the working directory
#WORKDIR /usr/src/app
#
## Install Tesseract OCR and other required dependencies
#RUN apk update && \
#    apk add tesseract-ocr
#
## Install Wine
#RUN apk add --no-cache wine
#
## Set the Tesseract OCR executable path
#ENV TESSDATA_PREFIX=/usr/share/tesseract-ocr/tessdata/
#
## Create the output directory for the OCR results
#RUN mkdir -p src/main/java/com/card/card/write/
#
## Copy Tesseract OCR directory from host machine into Docker image
#COPY Tesseract-OCR /usr/share/tesseract-ocr/
#
## Copy the application JAR file
#COPY ./target/card.jar ./
#
### Define a volume for Python dependencies
#VOLUME /usr/src/app/python_dependencies
#
## Set the entry point for the Docker container
#ENTRYPOINT ["java", "-jar", "card.jar"]
#
## Pass the image file path as an argument to the Java application
#CMD ["${IMAGE_PATH}"]
