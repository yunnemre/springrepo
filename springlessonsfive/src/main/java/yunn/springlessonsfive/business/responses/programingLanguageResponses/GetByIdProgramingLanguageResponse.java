package yunn.springlessonsfive.business.responses.programingLanguageResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdProgramingLanguageResponse {

	private int id;
	private String name;
	private List<String> subTechs;
}
