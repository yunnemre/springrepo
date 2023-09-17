package yunn.springlessonsfive.business.requests.subTechRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubTechRequest {

	private String name;
	private int programingLanguageId;
	
}
