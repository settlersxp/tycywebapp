package nastycraft.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import nastycraft.dao.ForumRepository;
import nastycraft.dao.TaskRepository;
import nastycraft.model.Forum;
import nastycraft.model.Task;

@Service
@Transactional
public class ForumService {
	
		private final ForumRepository forumRepository;

	
		
		public ForumService(ForumRepository forumRepository) {
			this.forumRepository = forumRepository;
		}

		public List<Forum> findAll(){
			List<Forum> linkk = new ArrayList<>();
			for(Forum links : forumRepository.findAll()) {
				linkk.add(links);
			}
			
			return linkk;
		}
		
		public void saveForumLinks(Forum link) {
			forumRepository.save(link);
		}
		
		public void deleteForumLinks(int id) {
			forumRepository.delete(id);
		}
		
		public Forum findOne(int id) {
			return forumRepository.findOne(id);
		}
		
		
		
		
}
