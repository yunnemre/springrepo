package yunn.springlessonsfive.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import yunn.springlessonsfive.business.abstracts.ProgramingLanguageService;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.CreateProgramingLanguageRequest;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.DeleteProgramingLanguageRequest;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.UpdateProgramingLanguageRequest;
import yunn.springlessonsfive.business.requests.subTechRequests.CreateSubTechRequest;
import yunn.springlessonsfive.business.responses.programingLanguageResponses.GetAllProgramingLanguagesResponse;
import yunn.springlessonsfive.business.responses.programingLanguageResponses.GetByIdProgramingLanguageResponse;
import yunn.springlessonsfive.dataAccess.abstracts.ProgramingLanguageRepository;
import yunn.springlessonsfive.dataAccess.abstracts.subTechRepository;
import yunn.springlessonsfive.entities.concretes.ProgramingLanguage;
import yunn.springlessonsfive.entities.concretes.subTechnology;


@Service
@AllArgsConstructor
public class ProgramingLanguageManager implements ProgramingLanguageService {
	
	private ProgramingLanguageRepository programingLanguageRepository;
	private subTechRepository subTechRepository;
	
	

	@Override
	public List<GetAllProgramingLanguagesResponse> getAll() {
		List<ProgramingLanguage> programingLanguages=programingLanguageRepository.findAll();
		List<GetAllProgramingLanguagesResponse> programingLanguageResponse=new ArrayList<GetAllProgramingLanguagesResponse>();
		
		for (ProgramingLanguage programingLanguage:programingLanguages) {
			List<String> sslist= new ArrayList <String>();
			for (subTechnology ss: programingLanguage.getSubTechs()){
				sslist.add(ss.getSubTechName());
			}
			GetAllProgramingLanguagesResponse responseItem=new GetAllProgramingLanguagesResponse();
			responseItem.setId(programingLanguage.getProgramingLanguageId());
			responseItem.setName(programingLanguage.getName());
			responseItem.setSubTechs(sslist);
			programingLanguageResponse.add(responseItem);
		}
		return programingLanguageResponse;
	}

	@Override
	public void add(CreateProgramingLanguageRequest createProgramingLanguageRequest) {
		ProgramingLanguage programingLanguage=new ProgramingLanguage();
		programingLanguage.setName(createProgramingLanguageRequest.getName());
		this.programingLanguageRepository.save(programingLanguage);
		
	}

	@Override
	public void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) {
		try {
			
		Optional<ProgramingLanguage> optional=programingLanguageRepository.findById(updateProgramingLanguageRequest.getId());
		if (optional.isPresent()) {
			
			if( StringUtils.isNotBlank(updateProgramingLanguageRequest.getName())) {optional.get().setName(updateProgramingLanguageRequest.getName());}
			
			if(StringUtils.isNotBlank(updateProgramingLanguageRequest.getSubTechName())) {
				
				CreateSubTechRequest createSubTechRequest=new CreateSubTechRequest();
				createSubTechRequest.setName(updateProgramingLanguageRequest.getSubTechName());
				createSubTechRequest.setProgramingLanguageId(updateProgramingLanguageRequest.getId());
				subTechManager manager = new subTechManager(subTechRepository, programingLanguageRepository);
				manager.add(createSubTechRequest);
			}
			this.programingLanguageRepository.save(optional.get());
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(DeleteProgramingLanguageRequest deleteProgramingLanguageRequest) {
		try {
			Optional<ProgramingLanguage> optional = programingLanguageRepository.findById(deleteProgramingLanguageRequest.getId());
			if(optional.isPresent()) {
				this.programingLanguageRepository.deleteById(optional.get().getProgramingLanguageId());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}

	@Override
	public GetByIdProgramingLanguageResponse getById(int id) {
		Optional<ProgramingLanguage> optional = programingLanguageRepository.findById(id);
		GetByIdProgramingLanguageResponse getByIdLanguageResponse = new GetByIdProgramingLanguageResponse();

		if (optional.isPresent()) {
			
			getByIdLanguageResponse.setId(optional.get().getProgramingLanguageId());
			getByIdLanguageResponse.setName(optional.get().getName());
			List<String> sslist= new ArrayList <String>();
			for (subTechnology ss: optional.get().getSubTechs()){
				sslist.add(ss.getSubTechName());
			}
			getByIdLanguageResponse.setSubTechs(sslist);
		}
		return getByIdLanguageResponse;

		
	}
	

}
