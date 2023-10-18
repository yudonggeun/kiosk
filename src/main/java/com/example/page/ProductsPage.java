package com.example.page;

public class ProductsPage implements Page{

    private int order;
    private String subject;
    private String description;

    public ProductsPage(String subject, String description) {
        this.subject = subject;
        this.description = description;
    }

    @Override
    public String render() {
        var sb = new StringBuilder();

        return sb.toString();
    }

    @Override
    public String href() {
        return String.format("%d. %-10s | %s\n", order, subject, description);
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }
}
