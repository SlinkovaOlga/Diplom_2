package JSON;

public class LoginResponse {
    boolean success;
    private User user;

    public boolean getSuccess() {
        return true;
    }
    public void setSuccess(boolean success) {
        this.success=success;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
