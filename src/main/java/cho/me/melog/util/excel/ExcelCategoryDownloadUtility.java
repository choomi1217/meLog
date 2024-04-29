package cho.me.melog.util.excel;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ExcelCategoryDownloadUtility implements ExcelDownloadUtility {
    @Override
    public void excelDownload(List dtoList, HttpServletResponse response) {

    }

    @Override
    public void render(List dtoList, Sheet sheet, Cell cell) {

    }

    @Override
    public List readExcel(MultipartFile file) {
        return null;
    }
}
