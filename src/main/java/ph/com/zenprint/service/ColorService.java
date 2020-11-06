package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.repository.ColorRepository;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@RequiredArgsConstructor
@Service
public class ColorService {

    private ColorRepository colorRepository;
}