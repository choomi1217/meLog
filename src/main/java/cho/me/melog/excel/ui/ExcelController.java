package cho.me.melog.excel.ui;

import cho.me.melog.excel.application.ExcelQueueProcessor;
import cho.me.melog.excel.application.ExcelService;
import cho.me.melog.excel.dto.ExcelDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExcelController {

    private final ExcelService excelService;
    private final ExcelQueueProcessor excelQueueProcessor;

    public ExcelController(ExcelService excelService, ExcelQueueProcessor excelQueueProcessor) {
        this.excelService = excelService;
        this.excelQueueProcessor = excelQueueProcessor;
    }

    /**
     * 엑셀 다운로드 화면
     * */
    @GetMapping("/api/excelForm")
    public String downloadExcel() {
        return "/download/excel";
    }

    /**
     * 다운로드 할 수 있는 엑셀 리스트
     */
    @GetMapping("/api/excel/list")
    public ResponseEntity<List<ExcelDto>> excelList() {
        return ResponseEntity.ok(excelService.findAllExcelNameList());
    }

    /**
     * 엑셀 양식 다운로드
     */
    @GetMapping("/api/excel/download/{id}")
    public ResponseEntity<String> downloadExcel(@PathVariable Long id, HttpServletRequest request) {
        boolean queued = excelQueueProcessor.enqueueRequest(id, request);
        if (queued) {
            return ResponseEntity.ok("Excel download request queued successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Server is busy, please try again later.");
        }
        // return excelService.downloadExcel(id);
    }

}
