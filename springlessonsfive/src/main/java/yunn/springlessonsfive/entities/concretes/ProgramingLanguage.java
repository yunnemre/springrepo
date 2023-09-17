package yunn.springlessonsfive.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="programingLanguage")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProgramingLanguage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="programingLanguageId")
	private int programingLanguageId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "programingLanguage")
    private List<subTechnology> subTechs;
}
