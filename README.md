## Simple Demo Employee Application

### Application has following functions:

- Get employee by ID
- Add employee
- Update employee
- Delete employee
- Get all information

JWT token is available from the following endpoint:
- /users/signin - get Jwt token (with username and password)

`curl --location --request POST 'http://localhost:8080/users/signin' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'username=admin' \
--data-urlencode 'password=admin'`

it returns JWT token and with JWT token you are able to send request with Bearer Authorization

- /users/signup - add user

Swagger url: `/swagger-ui.html`