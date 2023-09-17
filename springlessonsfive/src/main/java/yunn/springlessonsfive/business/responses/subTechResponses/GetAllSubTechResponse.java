package yunn.springlessonsfive.business.responses.subTechResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubTechResponse {

	private int id;
	private String name;
	private String programingLanguageName;
}
