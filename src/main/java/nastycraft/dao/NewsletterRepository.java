package nastycraft.dao;

import org.springframework.data.repository.CrudRepository;

import nastycraft.model.Newsletter;


public interface NewsletterRepository extends CrudRepository<Newsletter,Integer>{

}
