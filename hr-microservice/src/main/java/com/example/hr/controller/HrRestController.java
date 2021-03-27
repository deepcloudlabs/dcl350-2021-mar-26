package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.boundary.HireEmployeeResponse;
import com.example.hr.service.business.HrService;

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
public class HrRestController {
	@Autowired
	private HrService hrService;

	// DDD -> ACL: Anti-Corruption Layer
	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody HireEmployeeRequest request) {
		return hrService.hireEmployee(request);
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fireEmployee(@PathVariable String identity) {
		return hrService.fireEmployee(identity);
	}
}
