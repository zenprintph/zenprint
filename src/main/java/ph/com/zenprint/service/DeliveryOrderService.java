package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.repository.DeliveryOrderRepository;

/**
 * @author Choy
 * @date 11/3/2020.
 */

@RequiredArgsConstructor
@Service
public class DeliveryOrderService {

    private final DeliveryOrderRepository deliveryOrderRepository;
}