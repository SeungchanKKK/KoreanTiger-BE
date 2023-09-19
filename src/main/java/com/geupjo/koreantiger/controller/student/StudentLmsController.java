package com.geupjo.koreantiger.controller.student;

import com.geupjo.koreantiger.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "StudentLmsController", description = "학생 LMS 창에 들어가는 기능 api입니다")
@RequestMapping("v1")
@RestController
public class StudentLmsController {
        @Operation(summary = "학생경험치 api 입니다")
        @GetMapping("/experience/{studentId}")
        public ApiResponse StudentExperienceResponse(@Parameter(description = "학생Id") @RequestParam(value = "studentID", required = false) Long studentId) {
            ApiResponse response = new ApiResponse<>("suc",500);
            return response ;
    }
}
