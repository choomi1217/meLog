package cho.me.melog.util.excel;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelDownloadUtility<T> {

    void excelDownload(List<T> dtoList, HttpServletResponse response);
    void render(List<T> dtoList, Sheet sheet, Cell cell);
    List<T> readExcel(MultipartFile file);
}
