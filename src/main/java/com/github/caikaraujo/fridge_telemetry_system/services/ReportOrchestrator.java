package com.github.caikaraujo.fridge_telemetry_system.services;
import com.github.caikaraujo.fridge_telemetry_system.model.DailySummary;
import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;
import com.github.caikaraujo.fridge_telemetry_system.utils.DateUtils;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ReportOrchestrator {

    private final DailySummaryService summary;
    private final PdfReportService reportService;
    private final EmailService emailService;


    public ReportOrchestrator(DailySummaryService summary, PdfReportService reportService, EmailService emailService) {
        this.summary = summary;
        this.reportService = reportService;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void executeEndOfDayProcess() throws DocumentException, MessagingException {

        DailySummary dailySummary = summary.saveDailySummary();
        List<Temperature> list = summary.getTemp();

        byte[] pdfContent = reportService.generateDailyReport(list , dailySummary);

        String dateToday = DateUtils.fomatLocalDateTime(LocalDateTime.now());
        String subjectWDate = "Telemetry Report - VF FROID " + dateToday;
        emailService.sendEmail("Caik.dantas007@gmail.com", subjectWDate , "PDF containing daily reports" , pdfContent);
        summary.clearData();
    }
}
