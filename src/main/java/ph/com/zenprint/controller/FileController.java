package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.FileDto;
import ph.com.zenprint.service.FileService;

/**
 * @author Choy
 * @date 12/14/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @PostMapping
    public BaseResponse<Void> upload(@RequestBody FileDto fileDto) {

        fileService.saveFile(fileDto);

        return BaseResponse.<Void>builder()
                .code(ResponseCode.GEN200)
                .build();
    }
}
