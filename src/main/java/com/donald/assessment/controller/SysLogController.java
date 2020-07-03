package com.donald.assessment.controller;

import com.donald.assessment.pojo.CustomerEmail;
import com.donald.assessment.pojo.Report;
import com.donald.assessment.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author Donald
 * @data 01/07/2020 16:37
 */
@RestController
@RequestMapping("/api")
public class SysLogController {
    @Autowired
    private UserActivityService userActivityService;


    @GetMapping("/admin/{month}/logs")
    public ResponseEntity<Page<Report>> listResportsByMonth(@PathVariable("month") int month,@PageableDefault(size = 5) Pageable pageable){
        if(0!=month){
            return ResponseEntity.ok(userActivityService.listNyMonth(month,pageable));
        }else{
            return ResponseEntity.ok(userActivityService.list(pageable));
        }

    }
    @PostMapping("/email")
    public ResponseEntity<String> email(@RequestBody @Valid CustomerEmail email, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("name or email error", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().build();
    }

}
