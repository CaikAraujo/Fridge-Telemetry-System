package com.github.caikaraujo.fridge_telemetry_system.services;

import com.github.caikaraujo.fridge_telemetry_system.model.DailySummary;
import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;
import com.github.caikaraujo.fridge_telemetry_system.utils.DateUtils;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfReportService {

    public byte[] generateDailyReport(List<Temperature> temperatures, DailySummary summary) throws DocumentException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();
        document.add(new Paragraph("Telemetry Report - VF FROID"));

        document.add(new Paragraph("Average Temperature: " + String.format("%.2f", summary.getAvaregeTemperature())));
        document.add(new Paragraph("Max Temperature: " + summary.getMaxTemperature()));
        document.add(new Paragraph("Min Temperature: " + summary.getMinTemperature()));

        PdfPTable table = new PdfPTable(2);
        table.addCell("Date/Time");
        table.addCell("Temperature");

        for(Temperature temperature : temperatures){
            String fomatedDate = DateUtils.fomatLocalDateTime(temperature.getDatestamp());
            table.addCell(fomatedDate);
            table.addCell(temperature.getValue().toString());
        }
        document.add(table);

        document.close();

        return outputStream.toByteArray();
    }
}
