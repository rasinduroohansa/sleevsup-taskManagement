To-Do List

To-Do list is a simple, single-page web application that allows users to keep track of pending and completed tasks in order not to miss anything.
Features

    Create a new task with a priority level (set task status: unfinished)
    Three priority levels available based on the critically 
    Restrict creating duplicate tasks based on the composite key(task name, priority level and the status)
    Mark unfinished tasks as completed 
    Delete unfinished tasks
    View the list of unfinished and completed tasks
    Responsive design


Technologies used:

 Backend: Springboot, Java8, PostgreSQL(Heroku Cloud Database), Swagger-UI, JUnit, RestAPI

 Frontend: ReactJS, Material-UI, Bootstrap, Font-Awesome, Axios, HTML, CSS

Execution


Backend:

The application will run with the embedded apache tomcat server.

- Run-on default port ID (*8080*)

- And *Swagger UI* enabled for this application, and you can reach the Swagger UI, using *http://host:8080/swagger-ui.html*.


Frontend:

npm start o react-scripts start

Run-on *http://localhost:3000



Further improvements and suggestions

    Backend service
        Write more test cases. Example: validation, exceptions, etc
        Implement Spring security features
        Capture date-time when creating a new task
        Additional feature - task management with user login
        Create audit logs for task update and deletion
        Manage server log
        Mock data for testing


    Front end web application
        Implement OOP concepts and test cases
        Parameterise common data  
        Better to have a task edit
        Facility to view user wise audit log (history)
        Multiple task completion and deletion 
        Implement task search