# Metropolitan Convention Center Event Registration App

This application will provide a simple interface for customers to look up events they are interested in, 
and register to the event so that they may attend in the future.

There will be multiple repositories separated by microservices, 
showing iterations as we build and add new features to produce a fully fledged event registration application.
For example, the first repository, `metro-data` holds the source code necessary to produce a simple RESTful API with basic CRUD functionality.
`metro-frontend` holds the source code for the frontend User Interface; `metro-auth` for the source code holding security authentication services.

Some examples of feature functionalities we would like to add include: 
- integrated `hsql` database to hold persistent state
- React.js frontend client
- containerized application using Docker
- Authentication via JWTs with appropriate filters on HTTP requests
- cluster management and load balancing with Kubernetes
- CI/CD management

## Component List:
### Data Service Endpoints: 
  - Service information:
    - context path = `\api`
    - port = `8080`
  - Backend Data:
    - Will use an embedded hsql database
  - Endpoints: 
    - `\account\customers`
    - `\account\events`
    - `\account\registrations`
  - Root Endpoint (`\api`):
    - Returns a message confirming that the service is up and running.
  - Security: 
    - A servlet filter will be used to intercept calls to the api and check requests for JWT tokens
  - Customers Endpoint:
    - Supports CRUD management of Customer records.
    - Supports GET, PUT, POST, and DELETE requests.
    - A JWT token is required for all requests.
  - Events Endpoint:
    - Supports CRUD management of Events records.
    - Supports GET, PUT, POST, and DELETE requests.
    - a JWT token is required for all requests.
  - Registrations Endpoint:
    - Supports CRUD management of Registration records.
    - Allows customers to register for events.
    - Supports GET, PUT, POST, and DELETE requests.
    - A JWT token is required for all requests.
