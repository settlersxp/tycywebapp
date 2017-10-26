package nastycraft.dao;

import org.springframework.data.repository.CrudRepository;

import nastycraft.model.Users;




public interface UsersRepository extends CrudRepository<Users,Integer> {

}
