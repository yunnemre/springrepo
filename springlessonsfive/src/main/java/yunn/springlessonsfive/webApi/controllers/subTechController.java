package yunn.springlessonsfive.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunn.springlessonsfive.business.abstracts.subTechService;
import yunn.springlessonsfive.business.requests.subTechRequests.CreateSubTechRequest;
import yunn.springlessonsfive.business.requests.subTechRequests.DeleteSubTechRequest;
import yunn.springlessonsfive.business.requests.subTechRequests.UpdateSubTechRequest;
import yunn.springlessonsfive.business.responses.subTechResponses.GetAllSubTechResponse;
import yunn.springlessonsfive.business.responses.subTechResponses.GetByIdSubTechResponse;

@RestController
@RequestMapping("/api/subTechs")
public class subTechController {

	private subTechService subTechService;

	@Autowired
	public subTechController(yunn.springlessonsfive.business.abstracts.subTechService subTechService) {
		super();
		this.subTechService = subTechService;
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechResponse> getAll(){
		return subTechService.getAll();
	}
	
	@PostMapping("/add")
	public  void add(CreateSubTechRequest createSubTechRequest) {
		this.subTechService.add(createSubTechRequest);
		
	}
	@PutMapping("/update")
	public  void update(UpdateSubTechRequest subTechRequest) {
		this.subTechService.update(subTechRequest);
		
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteSubTechRequest deleteSubTechRequest) {
		this.subTechService.delete(deleteSubTechRequest);
	}
	
	@GetMapping("/getbyid")
	public GetByIdSubTechResponse getById(int id) {
		return subTechService.getById(id);
	}
}
