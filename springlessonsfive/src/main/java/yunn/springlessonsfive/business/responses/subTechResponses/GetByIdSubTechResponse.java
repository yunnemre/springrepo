package yunn.springlessonsfive.business.responses.subTechResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdSubTechResponse {

	private int id;
	private String name;
	private String programingLanguageName;
}
