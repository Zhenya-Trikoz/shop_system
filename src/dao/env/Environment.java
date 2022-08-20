package dao.env;

public enum Environment {
    DB_URL("jdbc:mysql://localhost/banking_system"),
    USERNAME("Zhenya"),
    PASSWORD("root");

    private final String environmentValue;

    Environment(String environmentValue) {
        this.environmentValue = environmentValue;
    }

    public String getEnvironmentValue() {
        return environmentValue;
    }
}
