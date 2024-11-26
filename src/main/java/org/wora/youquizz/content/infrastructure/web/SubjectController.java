package org.wora.youquizz.content.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wora.youquizz.content.application.dto.request.SubjectRequestDTO;
import org.wora.youquizz.content.application.dto.response.SubjectResponseDTO;
import org.wora.youquizz.content.application.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> createSubject(@RequestBody SubjectRequestDTO requestDTO) {
        return ResponseEntity.ok(subjectService.createSubject(requestDTO));
    }

    @GetMapping("/{subjectId}/sub-subjects")
    public ResponseEntity<List<SubjectResponseDTO>> getSubSubjects(@PathVariable Long subjectId) {
        return ResponseEntity.ok(subjectService.getSubSubjects(subjectId));
    }
}
