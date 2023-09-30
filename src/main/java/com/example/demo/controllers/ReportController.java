package com.example.demo.controllers;

import com.example.demo.service.GuitarPartService;
import com.example.demo.service.GuitarService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

@RestController
public class ReportController {
    @Autowired
    private GuitarService guitarService;
    @Autowired
    private GuitarPartService guitarPartService;

    @GetMapping("/guitarpdf")
    public ResponseEntity<byte[]> generateGuitarPdf() {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=guitar-report.pdf");
        JRBeanCollectionDataSource cdsGuitar = new JRBeanCollectionDataSource(guitarService.findAll());
        JRBeanCollectionDataSource cdsGuitarPart = new JRBeanCollectionDataSource(guitarPartService.findAll());
        try {
            JasperReport reportGuitar = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/guitar-inventory-report_A4.jrxml"));
            JasperReport reportGuitarPart = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/guitar-part-inventory-report_A4.jrxml"));
            HashMap<String, Object> guitarMap = new HashMap<>();
            HashMap<String, Object> guitarPartMap = new HashMap<>();
            JasperPrint guitarPdf = JasperFillManager.fillReport(reportGuitar, guitarMap, cdsGuitar);
            JasperPrint guitarPartPdf = JasperFillManager.fillReport(reportGuitarPart, guitarPartMap, cdsGuitarPart);
            // JasperExportManager
            byte[] guitarData = JasperExportManager.exportReportToPdf(guitarPdf);
            byte[] guitarPartDate = JasperExportManager.exportReportToPdf(guitarPartPdf);

            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(guitarData);
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.GONE).headers(headers).contentType(MediaType.APPLICATION_PDF).body(new byte[0]);

    }

    @GetMapping("/guitarpartpdf")
    public ResponseEntity<byte[]> generateGuitarPartPdf() {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=guitar-report.pdf");
        JRBeanCollectionDataSource cdsGuitarPart = new JRBeanCollectionDataSource(guitarPartService.findAll());
        try {
            JasperReport reportGuitarPart = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/guitar-part-inventory-report_A4.jrxml"));
            HashMap<String, Object> guitarPartMap = new HashMap<>();
            JasperPrint guitarPartPdf = JasperFillManager.fillReport(reportGuitarPart, guitarPartMap, cdsGuitarPart);
            byte[] guitarPartData = JasperExportManager.exportReportToPdf(guitarPartPdf);
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(guitarPartData);
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.GONE).headers(headers).contentType(MediaType.APPLICATION_PDF).body(new byte[0]);

    }

}
