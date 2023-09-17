package yunn.springlessonsfive.business.requests.programingLanguageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProgramingLanguageRequest {
	
	private int id;
	private String name;
	private String subTechName;
}
