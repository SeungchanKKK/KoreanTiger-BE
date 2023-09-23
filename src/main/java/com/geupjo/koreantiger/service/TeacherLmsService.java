package com.geupjo.koreantiger.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.geupjo.koreantiger.common.exception.CustomException;
import com.geupjo.koreantiger.common.exception.ErrorCode;
import com.geupjo.koreantiger.dto.TeacherExportItem;
import com.geupjo.koreantiger.entity.Class;
import com.geupjo.koreantiger.entity.ClassInfo;
import com.geupjo.koreantiger.entity.DetailedAnalysis;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.repository.ClassInfoRepository;
import com.geupjo.koreantiger.repository.ClassRepository;
import com.geupjo.koreantiger.repository.DetailedAnalysisRepository;
import com.geupjo.koreantiger.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherLmsService {

    private final ClassRepository classRepository;
    private final DetailedAnalysisRepository detailedAnalysisRepository;
    private final ClassInfoRepository classInfoRepository;
    private final MemberRepository memberRepository;


    public String exportReport(Member teacher) {
        List<Class> classes = classRepository.findAllByTeacherId(teacher.getId());

        Map<Long, List<Class>> classMap = classes
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Class::getClassInfoId,
                        Collectors.mapping(Function.identity(), Collectors.toList())
                ));

        List<TeacherExportItem> teacherExportItems = classMap.entrySet()
                .stream()
                .map(this::getExportItem)
                .flatMap(Collection::stream)
                .toList();

        String content = loadCsvFormat(teacherExportItems, TeacherExportItem.ORDERED_COLUMN_NAME, TeacherExportItem.class);

        if (StringUtils.isBlank(content)) {
            throw new CustomException(ErrorCode.CAN_NOT_EXPORT_ITEM);
        }

        return content;
    }

    private List<TeacherExportItem> getExportItem(Map.Entry<Long, List<Class>> entry) {
        List<Class> classList = entry.getValue();
        Set<Long> studentIds = classList.stream()
                .map(Class::getStudentId)
                .collect(Collectors.toSet());

        ClassInfo classInfo = classInfoRepository.findById(entry.getKey())
                .orElse(null);

        Map<Long, DetailedAnalysis> analysisMap = detailedAnalysisRepository.findByMemberIdIn(studentIds)
                .stream()
                .collect(Collectors.toMap(DetailedAnalysis::getMemberId, Function.identity()));

        Map<Long, Member> studentMap = memberRepository.findByIdIn(studentIds)
                .stream()
                .collect(Collectors.toMap(Member::getId, Function.identity()));

        return studentIds
                .stream()
                .map(id -> {
                    DetailedAnalysis analysis = analysisMap.get(id);
                    Member student = studentMap.get(id);
                    return TeacherExportItem.from(classInfo, student, analysis);
                })
                .toList();
    }

    private <T> String loadCsvFormat(List<T> exportItems, String[] orderedColumnName, java.lang.Class<T> clazz) {
        try {
            CsvSchema schema = new CsvMapper()
                    .schemaFor(clazz)
                    .withArrayElementSeparator(",")
                    .sortedBy(orderedColumnName)
                    .withHeader();

            return new CsvMapper()
                    .writer(schema)
                    .writeValueAsString(exportItems);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
