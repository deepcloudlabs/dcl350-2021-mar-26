package com.example.hr.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.boundary.FireEmployeeResponse;
import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.boundary.HireEmployeeResponse;
import com.example.hr.boundary.RestErrorMessage;
import com.example.hr.service.business.HrService;
import com.example.hr.validation.TcKimlikNo;

// REST API
// 1. URL -> Resource
//           application.properties
//           @RequestMapping("employees") + GetMapping/PostMapping/PutMapping/PatchMapping/DeleteMapping
// 2. GetMapping/PostMapping/PutMapping/PatchMapping/DeleteMapping
// 3. Representation -> application/json
// ADAPTER : HTTP -> Java Class
@RestController
@RequestScope
@RequestMapping("employees") // convention -> plural
@CrossOrigin
@Validated
public class HrRestController {
	@Autowired
	private HrService hrService;

	// DDD -> ACL: Anti-Corruption Layer
	@PostMapping
	public ResponseEntity<HireEmployeeResponse> hireEmployee(@RequestBody @Validated HireEmployeeRequest request) {
		try {
			hrService.hireEmployee(request); // throws IllegalArgumentException if fails
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new HireEmployeeResponse(e.getMessage()));
		}
		return ResponseEntity.ok(new HireEmployeeResponse("success"));
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fireEmployee(@PathVariable @TcKimlikNo String identity) {
		return hrService.fireEmployee(identity);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RestErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
		return new RestErrorMessage(e.getMessage());
	}
}
