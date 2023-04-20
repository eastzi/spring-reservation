package com.spring.reservation.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

//validation 순서 de -> no -> pa
//dto에서 group으로 구분한 것에 따라 유효성 검사가 체크됨
@GroupSequence({
				ValidationGroups.NotBlankGroup.class,
			    ValidationGroups.SizeCheckGroup.class,
			    ValidationGroups.PatternCheckGroup.class,
			    Default.class})
public interface ValidationSequence {
	//api에서 해당 interface를 참조하게하여 위의 순서에 따르게 함.
}
