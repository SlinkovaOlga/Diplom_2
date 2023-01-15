package Users;

import io.qameta.allure.Step;
import lombok.Data;

@Data
public class UsersCredentials {
    private String email;
    private String password;

    public UsersCredentials(UsersData usersData) {
        this.email = usersData.getEmail();
        this.password = usersData.getPassword();
    }

    @Step("Получение email и password из созданного клиента")
    public static UsersCredentials from(UsersData usersData) {
        return new UsersCredentials(usersData);
    }
}
