package yunn.springlessonsfive.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="subTechnology")
public class subTechnology {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subTechId")
	private int subTechId;
	
	@Column(name="subTechName")
	private String subTechName;
	
	@ManyToOne
	@JoinColumn(name = "programingLanguageId",referencedColumnName = "programingLanguageId", nullable = false)
	private ProgramingLanguage programingLanguage;
}
