package sdf.day06.task2;

public class Product {
    private String productId;
    private String title;
    private Double rating;
    private Double price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product(String productId, String title, Double rating, Double price) {
        this.productId = productId;
        this.title = title;
        this.rating = rating;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prod_id='" + productId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}

    

    

