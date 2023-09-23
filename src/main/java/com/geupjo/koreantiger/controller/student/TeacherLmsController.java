package com.geupjo.koreantiger.controller.student;

import com.geupjo.koreantiger.facade.TeacherLmsFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "TeacherLmsController", description = "선생님 LMS 창에 들어가는 기능 api입니다")
@RequestMapping("/v1/teacherLms")
@RestController
@RequiredArgsConstructor
public class TeacherLmsController {
    private static final String ACCEPT = "text/csv";
    public static final String CSV_EXTENSION = ".csv";
    private final TeacherLmsFacade teacherLmsFacade;

    @GetMapping("/report/export")
    public ResponseEntity<ByteArrayResource> exportReport() {
        String content = teacherLmsFacade.exportReport();

        ByteArrayResource resource = new ByteArrayResource(content.getBytes());
        String filename = "students-report" + CSV_EXTENSION;

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(ACCEPT))
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .body(resource);
    }
}
