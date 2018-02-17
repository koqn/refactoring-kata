package com.odde;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getSingleOrderContents(Order order) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"id\": ");
        sb.append(order.getOrderId());
        sb.append(", ");
        sb.append("\"products\": [");
        for (int j = 0; j < order.getProductsCount(); j++) {
            Product product = order.getProduct(j);
            sb.append(product.getProductContents());
            if (j !=  order.getProductsCount() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            sb.append(getSingleOrderContents(orders.getOrder(i)));
            if (i != orders.getOrdersCount() - 1) {
                sb.append(", ");
            }
        }

        return sb.append("]}").toString();
    }

}