package com.myOffice.Project.controller;


import com.myOffice.Project.dto.LoginRequestDTO;
import com.myOffice.Project.entity.Employee;
import com.myOffice.Project.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class AuthController {

    private EmployeeRepository employeeRepository;


    @PostMapping("/login")
    public ResponseEntity<?>login (@RequestBody LoginRequestDTO requestDTO){
        Employee employee = employeeRepository.findEmployeeByEmail(requestDTO.getEmail());

        if(employee != null & employee.getPassword().equals(requestDTO.getPassword())){
            return ResponseEntity.ok(employee);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }



}
