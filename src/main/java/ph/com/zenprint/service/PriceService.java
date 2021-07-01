package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.PriceDto;
import ph.com.zenprint.repository.PriceRepository;

/**
 * @author Choy
 * @date 5/3/2021.
 */

@Log4j2
@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceDto getShirtPrice(Integer quantity, Integer numberOfColors) {

        var price = priceRepository.findByNumberOfColors(numberOfColors);
        var unitPrice = 0;

        if (quantity >= 30 && quantity <= 49) {
            unitPrice = price.getThirtyPieces();
        } else if (quantity >= 50 && quantity <= 99) {
            unitPrice = price.getFiftyPieces();
        } else if (quantity >= 100 && quantity <= 199) {
            unitPrice = price.getOneHundredPieces();
        } else if (quantity >= 200 && quantity <= 299) {
            unitPrice = price.getTwoHundredPieces();
        } else if (quantity >= 300 && quantity <= 399) {
            unitPrice = price.getThreeHundredPieces();
        } else if (quantity >= 400 && quantity <= 499) {
            unitPrice = price.getOneHundredPieces();
        } else if (quantity >= 500) {
            unitPrice = price.getFiveHundredPieces();
        }

        return PriceDto.builder()
                .numberOfColors(numberOfColors)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .build();
    }
}
