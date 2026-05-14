package com.anishek.org.hospitalManagement.dto;

import com.anishek.org.hospitalManagement.entity.type.BloodGroupType;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountEntity {

    private BloodGroupType bloodGroupType;
    private Long count;
}
