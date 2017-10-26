package nastycraft.dao;

import org.springframework.data.repository.CrudRepository;

import nastycraft.model.Task;

public interface TaskRepository extends CrudRepository<Task,Integer>{

}
