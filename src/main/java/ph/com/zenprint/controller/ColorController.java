package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.ColorDto;
import ph.com.zenprint.service.ColorService;

import java.util.List;

/**
 * @author Choy
 * @date 12/14/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/colors")
public class ColorController {

    private final ColorService colorService;

    @GetMapping
    public BaseResponse<List<ColorDto>> getAllColors() {
        return BaseResponse.<List<ColorDto>>builder()
                .code(ResponseCode.GEN200)
                .data(colorService.getAllColors())
                .build();
    }
}
