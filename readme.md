# Converter RESTful API - Java example

## Introduction

This is a Java Springboot project which will accept file as input and will convert the file content to xml and CSV format.




## Getting started

Follow these steps to get started:

#### Step 1: Configuring Eclipse IDE for Java

You need to download the last version of Eclipse IDE for Java EE Developers.

. Make sure that Eclipse has installed the Maven plugin.


#### Step 2: Import Maven Project into Eclipse
Make sure you have JDK 17 installed.
To import an existing Maven project into Eclipse, just right-click the Package Explorer and go to:

`
Import... > Existing Maven Projects > Select root directory > Finish
`

It's possible that you need to update Maven project. To do it, just right-click the project and go to:

`
Maven > Update Project...
`


#### Step 3: Running the application

- Right click on the springBootApplication class App.java and then choose Run as > Java application
- The application will be started on port 8123
- hit the endpoint "localhost:8123/upload" by uploading file (the text content in that file will be taken as input) using postman
- the content in the file will be converted to XML and CSV formats and saved to small.xml and small.csv files in c drive Temp folder.
- the xml and csv file generated for small.in file as input is available in the location along with readme.md file.

#### Step 3: Limitations of the code

- the string regex pattern is used to separate content to different sentence and words. Libraries for Natural Language Processing is not used. Because of that some words for example Mr. is not parsed correctly.
- the characters and words from other language are not encoded while writing to xml or CSV.special characters are not encoded as expected.
