public class LegacyUser {
    private int id;
    private String username;
    private String passwordHash;
    private String email;
    private String role;

    // 1. Default constructor (Main.java - Scenario C)
    public LegacyUser() {
        this.id = 0;
        this.username = "guest";
        this.passwordHash = "";
        this.email = "none";
        this.role = "guest";
    }

    // 2. Database retrieval constructor without password (UserDAO.java)
    public LegacyUser(int id, String username, String email, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    // 3. New signup constructor without ID (Main.java - Scenario B)
    public LegacyUser(String username, String passwordHash, String email, String role) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    // 4. Full constructor (Main.java - Scenario A)
    public LegacyUser(int id, String username, String passwordHash, String email, String role) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LegacyUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}