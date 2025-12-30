package com.portfolio.ecomdm.profile;

import io.minio.*;
import io.minio.errors.ErrorResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user/profile")
public class ProfileController {
    private final MinioClient minioClient;
    private final String bucketName = "profile-pictures";

    public ProfileController() {
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

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId) {
        try {
            //String objectName = userId + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();

            // Upload new file
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(userId)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );

            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/download-image/{id}")
    public ResponseEntity<String> getImageBase64(@PathVariable String id) {
        try (InputStream is = minioClient.getObject(
                GetObjectArgs.builder().bucket(bucketName).object(id).build())) {

            byte[] imageBytes = is.readAllBytes();

            // Optionally detect the MIME type (fallback to jpeg)
            String mimeType = "image/jpeg";
            if (id.endsWith(".png")) mimeType = "image/png";
            else if (id.endsWith(".webp")) mimeType = "image/webp";

            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            String dataUri = "data:" + mimeType + ";base64," + base64;

            return ResponseEntity.ok(dataUri);
        } catch (Exception e) {
            return ResponseEntity.ok("");
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}
