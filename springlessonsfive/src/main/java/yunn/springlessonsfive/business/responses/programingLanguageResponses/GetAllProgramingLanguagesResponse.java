package yunn.springlessonsfive.business.responses.programingLanguageResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgramingLanguagesResponse {

	private int id;
	private String name;
	private List<String> subTechs;
}
