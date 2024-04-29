package cho.me.melog.excel.ui;

import cho.me.melog.excel.application.ExcelService;
import cho.me.melog.excel.dto.ExcelDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
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
     * 엑셀 다운로드
     * */
    @GetMapping("/api/excel/download/{id}")
    public ResponseEntity<Resource> downloadExcel(@PathVariable Long id) {
        return excelService.downloadExcel(id);
    }

}
