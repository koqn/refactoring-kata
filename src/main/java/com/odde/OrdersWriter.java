package com.odde;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
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
            if (i != orders.getOrdersCount() - 1) {
                sb.append(", ");
            }
        }

        return sb.append("]}").toString();
    }

}