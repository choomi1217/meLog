package cho.me.melog.excel.application;

import cho.me.melog.excel.dto.ExcelRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class ExcelQueueProcessor {
    private final BlockingQueue<ExcelRequest> excelQueue = new LinkedBlockingQueue<ExcelRequest>(100);
    private final ExcelService excelService;

    public ExcelQueueProcessor(ExcelService excelService) {
        this.excelService = excelService;
    }

    public boolean enqueueRequest(Long id, HttpServletRequest request) {
        return excelQueue.offer(new ExcelRequest(id, request));
    }

    @Scheduled(fixedRate = 1000)
    public void processQueue() {
        ExcelRequest request;
        while ((request = excelQueue.poll()) != null) {
            excelService.downloadExcel(request);
        }
    }
}
