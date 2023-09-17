package yunn.springlessonsfive.business.abstracts;

import java.util.List;

import yunn.springlessonsfive.business.requests.subTechRequests.CreateSubTechRequest;
import yunn.springlessonsfive.business.requests.subTechRequests.DeleteSubTechRequest;
import yunn.springlessonsfive.business.requests.subTechRequests.UpdateSubTechRequest;
import yunn.springlessonsfive.business.responses.subTechResponses.GetAllSubTechResponse;
import yunn.springlessonsfive.business.responses.subTechResponses.GetByIdSubTechResponse;


public interface subTechService {

	List<GetAllSubTechResponse> getAll();
	void add(CreateSubTechRequest createSubTechRequest);
	void update(UpdateSubTechRequest subTechRequest);
	void delete(DeleteSubTechRequest deleteSubTechRequest);
	GetByIdSubTechResponse getById(int id);
}
