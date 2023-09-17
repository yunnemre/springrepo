package yunn.springlessonsfive.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import yunn.springlessonsfive.business.abstracts.subTechService;
import yunn.springlessonsfive.business.requests.subTechRequests.CreateSubTechRequest;
import yunn.springlessonsfive.business.requests.subTechRequests.DeleteSubTechRequest;
import yunn.springlessonsfive.business.requests.subTechRequests.UpdateSubTechRequest;
import yunn.springlessonsfive.business.responses.subTechResponses.GetAllSubTechResponse;
import yunn.springlessonsfive.business.responses.subTechResponses.GetByIdSubTechResponse;
import yunn.springlessonsfive.dataAccess.abstracts.ProgramingLanguageRepository;
import yunn.springlessonsfive.dataAccess.abstracts.subTechRepository;
import yunn.springlessonsfive.entities.concretes.ProgramingLanguage;
import yunn.springlessonsfive.entities.concretes.subTechnology;

@Service
@AllArgsConstructor
public class subTechManager implements subTechService {

	private subTechRepository subTechRepository;
	private ProgramingLanguageRepository programingLanguageRep;
	
	


	@Override
	public List<GetAllSubTechResponse> getAll() {
		List<subTechnology> subTechs=subTechRepository.findAll();
		List<GetAllSubTechResponse> subTechResponse=new ArrayList<GetAllSubTechResponse>();
		
		for (subTechnology subTech:subTechs) {
			GetAllSubTechResponse responseItem=new GetAllSubTechResponse();
			responseItem.setId(subTech.getSubTechId());
			responseItem.setName(subTech.getSubTechName());
			responseItem.setProgramingLanguageName(subTech.getProgramingLanguage().getName());
			subTechResponse.add(responseItem);
		}
		
		return subTechResponse;
	}

	@Override
	public void add(CreateSubTechRequest createSubTechRequest) {
		
		int Id= createSubTechRequest.getProgramingLanguageId();
		subTechnology subTech=new subTechnology();
		subTech.setSubTechName(createSubTechRequest.getName());
		subTech.setProgramingLanguage(programingLanguageRep.getReferenceById(Id));
		
		this.subTechRepository.save(subTech);
		
		
		
		
	}

	@Override
	public void update(UpdateSubTechRequest subTechRequest) {
		try {
			Optional<subTechnology> optional = subTechRepository.findById(subTechRequest.getId());
			Optional<ProgramingLanguage> optionalPrograming = programingLanguageRep.findById(subTechRequest.getProgramingLanguageId());
			if(optionalPrograming.isEmpty()) {
				 optionalPrograming = programingLanguageRep.findById(optional.get().getProgramingLanguage().getProgramingLanguageId());}
			if( StringUtils.isNotBlank(subTechRequest.getName())) {optional.get().setSubTechName(subTechRequest.getName());}
			
			optional.get().setSubTechName(optional.get().getSubTechName());
			optional.get().setProgramingLanguage(optionalPrograming.get());
			this.subTechRepository.save(optional.get());
		} catch (NoSuchElementException e) {
			System.err.println("Bilgiler Eksik");
		}
		
		}
		
		
		
		

	@Override
	public void delete(DeleteSubTechRequest deleteSubTechRequest) {
		try {
			Optional<subTechnology> optional = subTechRepository.findById(deleteSubTechRequest.getId());
			if(optional.isPresent()) {
				this.subTechRepository.deleteById(optional.get().getSubTechId());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public GetByIdSubTechResponse getById(int id) {
		try {
			Optional<subTechnology> optional = subTechRepository.findById(id);
			GetByIdSubTechResponse getByIdSubTechResponse = new GetByIdSubTechResponse();

			if (optional.isPresent()) {

				getByIdSubTechResponse.setId(optional.get().getSubTechId());
				getByIdSubTechResponse.setName(optional.get().getSubTechName());
				getByIdSubTechResponse.setProgramingLanguageName(optional.get().getProgramingLanguage().getName());
			}
			return getByIdSubTechResponse;
			 
		} catch (Exception e) {
			return null;
		}
	}

}
