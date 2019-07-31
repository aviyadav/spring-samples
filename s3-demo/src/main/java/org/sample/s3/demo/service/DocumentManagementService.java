package org.sample.s3.demo.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentManagementService {
    void uploadMultipleFiles(List<MultipartFile> multipartFiles);
}
