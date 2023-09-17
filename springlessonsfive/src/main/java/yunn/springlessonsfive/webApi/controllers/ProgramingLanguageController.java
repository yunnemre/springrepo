package yunn.springlessonsfive.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunn.springlessonsfive.business.abstracts.ProgramingLanguageService;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.CreateProgramingLanguageRequest;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.DeleteProgramingLanguageRequest;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.UpdateProgramingLanguageRequest;
import yunn.springlessonsfive.business.responses.programingLanguageResponses.GetAllProgramingLanguagesResponse;
import yunn.springlessonsfive.business.responses.programingLanguageResponses.GetByIdProgramingLanguageResponse;

@RestController
@RequestMapping("/api/programs")
public class ProgramingLanguageController {
	
	private ProgramingLanguageService programingLanguageService;

	@Autowired
	public ProgramingLanguageController(ProgramingLanguageService programingLanguageService) {
		super();
		this.programingLanguageService = programingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllProgramingLanguagesResponse> getAll(){
		return programingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public  void add(CreateProgramingLanguageRequest createProgramingLanguageRequest) {
		this.programingLanguageService.add(createProgramingLanguageRequest);
		
	}
	
	@PutMapping("/update")
	public  void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) {
		this.programingLanguageService.update(updateProgramingLanguageRequest);
		
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteProgramingLanguageRequest deleteProgramingLanguageRequest) {
		this.programingLanguageService.delete(deleteProgramingLanguageRequest);
	}
	
	@GetMapping("/getbyid")
	public GetByIdProgramingLanguageResponse getById(int id) {
		return programingLanguageService.getById(id);
	}
}

