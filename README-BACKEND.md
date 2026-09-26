Para ejecutar el backend es necesario seguir los siguientes comandos:

    1) En application.properties ya está puesto el usuario con permisos solo de lectura, por lo que no es necesario hacer cambios:

    DB_URL=jdbc:postgresql://db.hlyaqhfmndemtcpldbme.supabase.co:5432/postgres
    DB_READONLY_USER=readonly_user
    DB_READONLY_PASSWORD=grmjgklnre52617891bgd1ty1h8tyh17t8y%$%34564364bgfd

    2) mvn clean generate-sources compile

    3) mvn spring-boot:run  

Para probar los endpoints, se puede emplear los requests creados para el propio testeo:
- [events-api.http](../websiteDemoBackend/src/requests/events-api.http)
- [menu-api.http](../websiteDemoBackend/src/requests/menu-api.http)
- [books-api.http](../websiteDemoBackend/src/requests/books-api.http)
- [users-api.http](../websiteDemoBackend/src/requests/users-api.http)


O seguir con los pasos descritos para el frontend [README-FRONTEND.md](../websiteDemoFrontend/README-FRONTEND.md)

---

## Tests

Para poder ver los tests del backend hay dos opciones:

1) Simplemente poniendo _mvn test_ en la terminal

2) O ver el análisis creado por JaCoCo: 

    2.1) mvn clean test

    2.2) mvn jacoco:report
         
    2.3) en un explorador abrir el siguiente archivo generado: [JaCoCo index.html](../websiteDemoBackend/target/site/jacoco/index.html)
            
        

Estado actual de los tests del backend (Última actualización el 28-09-2025):

Actualmente hay un total de 43 tests.

[Tests del backend](../Material/images/tests_backend/ "Tests del backend")


### menuApi


![MenuApi Application ](../Material/images/tests_backend/menuApi/MenuApi_Application_09-09-2025.png)


![MenuApi Domain ](../Material/images/tests_backend/menuApi/MenuApi_Domain_09-09-2025.png)


![MenuApi Infraestructure ](../Material/images/tests_backend/menuApi/MenuApi_Infraestructure_09-09-2025.png)

---


### eventsApi


![EventsApi Application ](../Material/images/tests_backend/eventsApi/EventsApi_Application_09-09-2025.png)


![EventsApi Domain ](../Material/images/tests_backend/eventsApi/EventsApi_Domain_09-09-2025.png)


![EventsApi Infraestructure ](../Material/images/tests_backend/eventsApi/EventsApi_Infraestructure_09-09-2025.png)

---

### booksApi


![BooksApi Application ](../Material/images/tests_backend/booksApi/BooksApi_Application_13-09-2025.png)


![BooksApi Domain ](../Material/images/tests_backend/booksApi/BooksApi_Domain_13-09-2025.png)


![BooksApi Infraestructure ](../Material/images/tests_backend/booksApi/BooksApi_Infraestructure_13-09-2025.png)

---

### usersApi

![UsersApi Application ](../Material/images/tests_backend/usersApi/UsersApi_Application_28-09-2025.png)


![UsersApi Domain ](../Material/images/tests_backend/usersApi/UsersApi_Domain_28-09-2025.png)


![UsersApi Infraestructure ](../Material/images/tests_backend/usersApi/UsersApi_Infraestructure_28-09-2025.png)