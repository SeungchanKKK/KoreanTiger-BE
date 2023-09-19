package com.geupjo.koreantiger.controller.hello;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Hello Controller", description = "Swagger Hello Controller")
@RestController
public class HelloController {

    @Operation(summary = "조회")
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@Parameter(description = "이름") @RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok("Hello, " + name + "!");
    }

    @Operation(summary = "저장")
    @PostMapping("/hello")
    public ResponseEntity<HelloResponse> hello(@RequestBody @Valid HelloRequest request) {
        HelloResponse response = new HelloResponse(1, request.age(), request.name());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "업데이트")
    @PutMapping("/hello")
    public ResponseEntity<HelloResponse> hello(@RequestBody @Valid HelloUpdateRequest request) {
        HelloResponse response = new HelloResponse(1, 20, request.name());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "삭제")
    @DeleteMapping("/hello/{memberId}")
    public ResponseEntity<Void> hello(@PathVariable("memberId") long memberId) {
        return ResponseEntity.noContent().build();
    }


    private record HelloRequest(
            @Schema(description = "나이")
            @NotNull
            int age,

            @Schema(description = "이름")
            @NotBlank
            String name
    ) {
    }

    private record HelloUpdateRequest(
            @Schema(description = "이름")
            @NotBlank
            String name
    ) {
    }

    private record HelloResponse(
            @Schema(description = "유저 아이디")
            long memberIds,

            @Schema(description = "나이")
            @NonNull
            int age,

            @Schema(description = "이름")
            String name
    ) {
    }
}
