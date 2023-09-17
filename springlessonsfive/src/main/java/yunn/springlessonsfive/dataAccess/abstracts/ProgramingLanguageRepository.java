package yunn.springlessonsfive.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunn.springlessonsfive.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage,Integer> {

}
