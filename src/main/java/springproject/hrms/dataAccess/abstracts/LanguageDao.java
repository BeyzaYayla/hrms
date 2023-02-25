package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import springproject.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
