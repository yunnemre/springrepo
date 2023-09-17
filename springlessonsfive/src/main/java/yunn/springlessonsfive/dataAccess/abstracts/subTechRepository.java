package yunn.springlessonsfive.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunn.springlessonsfive.entities.concretes.subTechnology;

public interface subTechRepository extends JpaRepository<subTechnology, Integer> {

}
