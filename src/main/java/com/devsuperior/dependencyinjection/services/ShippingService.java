package com.devsuperior.dependencyinjection.services;

import org.springframework.stereotype.Service;

import com.devsuperior.dependencyinjection.entities.Order;

@Service
public class ShippingService {
   public double shipment(Order order) {
      return (order.getBasic() < 100.0) ? 20.0 : (order.getBasic() < 200.0) ? 12.0 : 0.0;
   }
}