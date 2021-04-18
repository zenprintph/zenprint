package ph.com.zenprint.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.FileDto;
import ph.com.zenprint.entity.SysFile;
import ph.com.zenprint.repository.FileRepository;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Choy
 * @date 12/27/2020.
 */

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    private final ObjectMapper mapper;

    public void saveFile(FileDto fileDto) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("D://asd.psd")) {

            String base64String = fileDto.getBase64String().substring(
                    fileDto.getBase64String().indexOf(",") + 1);
            byte[] decoder = Base64.decodeBase64(base64String.getBytes());

            fileOutputStream.write(decoder);

            SysFile file = mapper.convertValue(fileDto, SysFile.class);

            fileRepository.save(file);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
