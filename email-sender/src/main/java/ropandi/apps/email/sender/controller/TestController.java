package ropandi.apps.email.sender.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ropandi.apps.email.sender.request.TestRequest;
import ropandi.apps.email.sender.service.TestService;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping
    public ResponseEntity<String> test(@RequestBody TestRequest request){
        return new ResponseEntity<>(testService.sendTest(request), HttpStatus.OK);
    }
}
