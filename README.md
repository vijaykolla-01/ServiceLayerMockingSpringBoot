# Service Layer Dependency Mocking — Spring Boot Project

This is a Spring Boot application for the experiment: **Service Layer Dependency Mocking in Unit Tests**.

## Project configuration
- Spring Boot 3.5.6
- Java 21
- Maven
- Spring Web
- JUnit 5, Mockito, and MockMvc

## Why MySQL is not configured
This experiment tests only the controller layer. `@WebMvcTest` loads the web layer, and `@MockitoBean` supplies a mock `UserService`. The test does not access a database, so a MySQL username, password, or schema is not required. Your MySQL password is deliberately not stored in the project.

## Import into Spring Tool Suite / Eclipse on Mac
1. Extract `ServiceLayerMockingSpringBoot.zip`.
2. Open Spring Tool Suite (or Eclipse with Spring Tools and Maven support).
3. Choose **File → Import… → Maven → Existing Maven Projects**.
4. For **Root Directory**, select the extracted `ServiceLayerMockingSpringBoot` folder.
5. The project should appear in the list. Select its checkbox and click **Finish**.
6. If Maven dependencies do not load, right-click the project → **Maven → Update Project…** → **OK**.

Alternative import: **File → Import… → General → Existing Projects into Workspace**, then select the extracted folder.

## Run the Spring Boot app
Open `src/main/java/com/example/demo/DemoApplication.java`, right-click, then choose **Run As → Spring Boot App**.

Visit: http://localhost:8080/users/1

Expected response:
```json
{
  "id": 1,
  "name": "Vijay"
}
```

## Run the unit test
Open `src/test/java/com/example/demo/controller/UserControllerTest.java`, right-click, then choose **Run As → JUnit Test**.

Or run from a terminal opened in the project folder:
```bash
mvn test
```

Expected: `getUser_returnsMockedUserAndHttp200` passes with HTTP 200 OK.

## Main experiment files
- `User.java` — model
- `UserService.java` — service dependency
- `UserController.java` — controller under test
- `UserControllerTest.java` — web-slice test with mocked service
