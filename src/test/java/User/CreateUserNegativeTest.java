package User;

import Users.RestAssuredUser;
import Users.UserClient;
import Users.UsersData;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserNegativeTest extends RestAssuredUser {
    private UsersData usersData;
    private UserClient userClient;


    @Before
    public void setUp() {
        userClient = new UserClient();
        usersData = UsersData.getRandom();
    }

    @Test
    @DisplayName("Create User Without Password")
    @Description("Создание клиента без пароля")
    public void createUserWithoutPassword() {
        usersData.setPassword("");
        userClient.createUser(usersData)
                .assertThat()
                .statusCode(SC_FORBIDDEN)
                .and()
                .body(equalTo(BODY_403));
    }
    @Test
    @DisplayName("Create User Without Email")
    @Description("Создание клиента без email")
    public void createUserWithoutEmail() {
        usersData.setEmail("");
        userClient.createUser(usersData)
                .assertThat()
                .statusCode(SC_FORBIDDEN)
                .and()
                .body(equalTo(BODY_403));
    }
    @Test
    @DisplayName("Create User Without Name")
    @Description("Создание клиента без имени")
    public void createUserWithoutName() {
        usersData.setName("");
        userClient.createUser(usersData)
                .assertThat()
                .statusCode(SC_FORBIDDEN)
                .and()
                .body(equalTo(BODY_403));
    }
    @Test
    @DisplayName("Create User With Empty Body")
    @Description("Создание клиента с пустым телом запроса")
    public void createUserWithEmptyBody() {
        usersData.setName(null);
        usersData.setEmail(null);
        usersData.setPassword(null);
        userClient.createUser(usersData)
                .assertThat()
                .statusCode(SC_FORBIDDEN)
                .and()
                .body(equalTo(BODY_403));
    }
}
