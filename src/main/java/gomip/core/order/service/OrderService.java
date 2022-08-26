package gomip.core.order.service;

import gomip.core.order.dto.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
