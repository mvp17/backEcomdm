package com.portfolio.ecomdm.pdf;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.portfolio.ecomdm.products.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PDFGenerator {

    public byte[] generatePDF(Product product) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDocument = new PdfDocument(writer);
             Document document = new Document(pdfDocument)) {

            // Add Title
            addTitleText(document, product.getName());

            // Add Table
            addProductTable(document, product);

            document.close();
            return outputStream.toByteArray();
        } catch (IOException e) {
            log.error("Error generating PDF", e);
            return new byte[0]; // Return empty byte array if error occurs
        }
    }

    private void addTitleText(Document document, String titleText) {
        titleText = (titleText != null && !titleText.isEmpty()) ? titleText : "Untitled Product";
        Paragraph paragraph = new Paragraph(new Text(titleText).setFontSize(20))
                .setMarginTop(20)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(paragraph);
    }

    private void addProductTable(Document document, Product product) {
        Table table = new Table(new float[]{2, 4}); // Define column widths
        //table.setWidthPercent(80); // Set width to 80% of page

        // Add headers
        table.addHeaderCell(new Cell().add(new Paragraph("Attribute")));
        table.addHeaderCell(new Cell().add(new Paragraph("Value")));

        // Add product details
        addTableRow(table, "ID", String.valueOf(product.getId()));
        addTableRow(table, "Title", product.getName());
        addTableRow(table, "Description", product.getDescription());
        addTableRow(table, "Price", "$" + product.getPrice());

        document.add(table);
    }

    private void addTableRow(Table table, String key, String value) {
        value = (value != null && !value.isEmpty()) ? value : "-"; // Default empty values to "-"
        table.addCell(new Cell().add(new Paragraph(key)));
        table.addCell(new Cell().add(new Paragraph(value)));
    }
}