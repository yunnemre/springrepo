package yunn.springlessonsfive.business.abstracts;

import java.util.List;

import yunn.springlessonsfive.business.requests.programingLanguageRequests.CreateProgramingLanguageRequest;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.DeleteProgramingLanguageRequest;
import yunn.springlessonsfive.business.requests.programingLanguageRequests.UpdateProgramingLanguageRequest;
import yunn.springlessonsfive.business.responses.programingLanguageResponses.GetAllProgramingLanguagesResponse;
import yunn.springlessonsfive.business.responses.programingLanguageResponses.GetByIdProgramingLanguageResponse;

public interface ProgramingLanguageService {
	List<GetAllProgramingLanguagesResponse> getAll();
	void add(CreateProgramingLanguageRequest createProgramingLanguageRequest);
	void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest);
	void delete(DeleteProgramingLanguageRequest deleteProgramingLanguageRequest);
	GetByIdProgramingLanguageResponse getById(int id);
}
