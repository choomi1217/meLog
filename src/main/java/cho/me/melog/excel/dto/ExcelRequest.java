package cho.me.melog.excel.dto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;

@Getter
public class ExcelRequest {
    private Long id;
    private HttpServletRequest request;

    public ExcelRequest(Long id, HttpServletRequest request) {
        this.id = id;
        this.request = request;
    }
}
