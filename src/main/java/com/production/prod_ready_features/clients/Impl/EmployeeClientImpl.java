package com.production.prod_ready_features.clients.Impl;

import com.production.prod_ready_features.advices.ApiResponse;
import com.production.prod_ready_features.clients.EmployeeClients;
import com.production.prod_ready_features.dto.EmployeeDto;
import com.production.prod_ready_features.exceptions.ResourceNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClients {


    private final RestClient restClient;
    //we are not going to create controller, we Create TEST for testing and calling.

    Logger log= (Logger) LoggerFactory.getLogger(EmployeeClientImpl.class);


    @Override
    public List<EmployeeDto> getAllEmployees() {
        try{
            ApiResponse<List<EmployeeDto>> employeeDtoList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
         //   log.info("Successfully retrieved the employees in getAllEmployees");
         //   log.fine("Successfully employees list in getAllEmployees: {}");
            return employeeDtoList.getData();
        }catch (Exception e){
            log.warning("Exception occurred in getAllEmployees");
            throw new RuntimeException();
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       try{
           ApiResponse<EmployeeDto> employeeDto=restClient.get()
                   .uri("employees/{employeeId}",employeeId)
                   .retrieve()
                   .body(new ParameterizedTypeReference<>() {
                   });
          return employeeDto.getData();
        }catch (Exception e){
           throw new RuntimeException();
       }
    }

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
        try{
            ResponseEntity<ApiResponse<EmployeeDto>> employeeDtoApiResponse=restClient.post()
                    .uri("employees")
                    .body(inputEmployee)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        System.out.println("Error occurred "+new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundExceptions("Could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });

            return employeeDtoApiResponse.getBody().getData();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
