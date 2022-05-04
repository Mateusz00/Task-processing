# Task-processing
### Prerequisites
- JDK17

# How to use API
Server listens on port `8080` by default

- ###  Method: `POST` <br/>URI: `/tasks`
Request body:
```
"base": double (required)
"exponent": double (required)
```
Response:
```
"id": long
```
Description:<br/>
`Creates and runs task asynchronously, result of the task will be exponentation of "base" and "exponent". Returns unique id of the created task`
<br/>
- ###  Method: `GET` <br/>URI: `/task/{id}`
Response:
```
"id": long
"status": string (Possible values: QUEUED, RUNNING, FINISHED, ABORTED)
"progress": int (Values 0-100)
"result": double (Returned only when the task is completed)
```
Description:<br/>
`Retrieves information about task with specified id. "result" is returned only when status is set to "FINISHED"` 
<br/>
- ###  Method: `GET` <br/>URI: `/tasks`
Response:
```
[
  {
    "id": long
    "status": string (Possible values: QUEUED, RUNNING, FINISHED, ABORTED)
    "progress": int (Values 0-100)
    "result": double (Returned only when the task is completed)
  },
  ...
]
```
Description:<br/>
`Retrieves information about all tasks. "result" is returned only when status is set to "FINISHED"`
<br/>
# How to run
Run these commands in the project directory (JAVA_HOME environment variable needs to be set and pointing to JDK17)
```
./mvnw clean package
./mvnw spring-boot:run
```
