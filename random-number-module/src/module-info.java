import com.example.random.service.RandomNumberService;
import com.example.random.service.business.SecureRandomNumberService;
import com.example.random.service.business.SimpleRandomNumberService;

module com.example.random {
	exports com.example.random.service;
	provides RandomNumberService with SimpleRandomNumberService, SecureRandomNumberService;
}