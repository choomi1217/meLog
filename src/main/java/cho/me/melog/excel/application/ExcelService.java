package cho.me.melog.excel.application;

import cho.me.melog.excel.dto.ExcelDto;
import cho.me.melog.excel.dto.ExcelRequest;
import cho.me.melog.excel.repository.dao.ExcelDao;
import cho.me.melog.excel.repository.domain.Excel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
public class ExcelService {

    @Value("${file.path}")
    private String filePath;

    private final ExcelDao excelDao;

    public ExcelService(ExcelDao excelDao) {
        this.excelDao = excelDao;
    }

    public List<ExcelDto> findAllExcelNameList() {
        return excelDao.findAllExcel().stream()
                .map(ExcelDto::new)
                .toList();
    }

    public ResponseEntity<Resource> downloadExcel(ExcelRequest excelRequest) {
        Excel excel = excelDao.findById(excelRequest.getId());
        String path = excel.getPath();
        String fileName = excel.getTitle();
        Resource resource = new FileSystemResource(path + fileName);
        log.debug("resource: {}", resource);

        if (!resource.exists()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
        }

        String contentType = "application/octet-stream";
        try {
            contentType = Files.probeContentType(Paths.get(resource.getFile().getAbsolutePath()));
        } catch (IOException ex) {
            log.error("Could not determine file type.");
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

    }

}
