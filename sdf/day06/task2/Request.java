package sdf.day06.task2;

public class Request {
    private String requestId;
    private String name;
    private String email;
    private String[] items;
    private Double spent;
    private Double remaining;

    public String getRequestID() {
        return requestId;
    }
    public  void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String[] getItems() {
        return items;
    }
    public void setItems(String[] items) {
        this.items = items;
    }
    public Double getSpent() {
        return spent;
    }
    public void setSpent(Double spent) {
        this.spent = spent;
    }
    public Double getRemaining() {
        return remaining;
    }
    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }
}
