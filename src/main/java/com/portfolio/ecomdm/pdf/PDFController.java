package com.portfolio.ecomdm.pdf;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PDFController {
    private final PDFGenerator pdfGenerator;
    private final MinioClient minioClient;
    private final String bucketName = "product-reports";

    public PDFController(PDFGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;

        this.minioClient = MinioClient.builder()
                .endpoint("http://localhost:9000")
                .credentials("minioadmin", "minioadmin")
                .build();

        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error initializing MinIO bucket", e);
        }
    }

    @PostMapping("/report")
    public ResponseEntity<Map<String, String>> generatePDF(@RequestBody Product product) {
        byte[] pdfContent = pdfGenerator.generatePDF(product);
        // Convert byte array to Base64 string
        String base64Pdf = Base64.getEncoder().encodeToString(pdfContent);

        try {
            String objectName = "report-" + product.getTitle() + UUID.randomUUID() + ".pdf";

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(new ByteArrayInputStream(pdfContent), pdfContent.length, -1)
                            .contentType("application/pdf")
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Upload failed: " + e.getMessage()));
        }

        // Return as JSON response
        return ResponseEntity.ok(Map.of("pdfBase64", base64Pdf));
    }
}
