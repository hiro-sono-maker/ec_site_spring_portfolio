package com.ecsite;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

  List<OrderDetail> findByOrderId(Integer orderId);

}
