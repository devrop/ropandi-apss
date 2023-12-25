package ropandi.apps.email.sender.transformer;

import ropandi.apps.email.sender.request.TestRequest;
import ropandi.apps.model.test.avro.TestAvroModel;

public class TestRequestMapper {

    public static TestAvroModel convertToAvro(TestRequest request){
        return TestAvroModel.newBuilder().setId(request.getId()).setCc(request.getCc()).build();
    }
}
