package ropandi.apps.email.receiver.transformer;

import ropandi.apps.model.test.avro.TestAvroModel;
import ropandi.apps.model.test.dto.TestDto;

public class TestDtoMapper {


    public static TestDto getDto(TestAvroModel testAvroModel){
        return TestDto.builder().
                id(testAvroModel.getId())
                .cc(testAvroModel.getCc())
                .build();
    }
}
