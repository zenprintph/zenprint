package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.repository.SalesDetailRepository;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@RequiredArgsConstructor
@Service
public class SalesDetailService {

    private final SalesDetailRepository salesDetailRepository;
}