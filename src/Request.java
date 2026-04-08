public class Request {
    public String username;
    public int initialDeposit;

    public Request(String username, int initialDeposit) {
        this.username = username;
        this.initialDeposit = initialDeposit;
    }

    public String toString() {
        return username + " (deposit: " + initialDeposit + ")";
    }
}