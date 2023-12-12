# GW-database-generator

The program is designed to interact with a third-party API providing data about weather stations in Gdansk. The main entity in the application is a "Station" class, representing a weather station with attributes for different weather data types. Each station can collect data such as rain, water, flow, wind direction, wind level, temperature, pressure, humidity, and sunlight.

1. Entity Model:
   - The central entity is the Station class, which has attributes representing different types of weather data.
   - Each station can have associated rain data, stored as a list of Rain entities. (more data types coming soon)

2. API Interaction:
   - The program interacts with Gdanskie Wody API to fetch data about weather stations.
   - The data retrieved includes information about multiple weather stations, and the program processes this data.

3. Data Persistence:
   - Station data, including rain data, is persisted in a MySQL database.
   - The Station entity and associated Rain entities are mapped to corresponding database tables.

4. Data Synchronization:
   - To keep the local database updated, the program periodically fetches new data from the third-party API.
   - Requests are sent to the API, and retrieved data is stored in the local database.

5. Error Handling:
   - The program includes error handling mechanisms for scenarios like connection errors, parsing errors, or other issues during API interactions.

6. Spring Boot Application:
   - The application is built using the Spring Boot framework, facilitating development and deployment.
   - RESTful endpoints, like the RainController, allow clients to retrieve rain data for specific stations and dates.

7. Database Relationships:
   - The Station entity has a one-to-many relationship with the Rain entity, indicating that a station can have multiple rain data entries.

8. Initialization and Startup:
   - During application startup, necessary database tables are created, and initial data may be fetched from the API.

9. Data Integrity and Orphan Removal:
    - Measures are taken to ensure data integrity, particularly regarding the relationship between Station and Rain. The use of orphanRemoval and proper initialization helps avoid issues related to orphaned entities.

10. Code Structure:
    - Code is organized into packages, with a clear separation of concerns.
    - A service layer (GWService) encapsulates business logic related to weather data.

In summary, the program is a weather data management system that retrieves, processes, and stores information from weather stations. It provides a convenient interface for clients to access specific weather data.

The "cloned" database will be used in my second project for more processing. 

