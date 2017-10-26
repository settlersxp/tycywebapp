package nastycraft.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import nastycraft.dao.RanksRepository;
import nastycraft.model.Ranks;



@Service
@Transactional
public class RanksService {
	
		private final RanksRepository ranksRepository ;


		public RanksService(RanksRepository ranksRepository) {
			this.ranksRepository = ranksRepository;
		}

		
		public List<Ranks> findAll(){
			List<Ranks> ranksList = new ArrayList<>();
			for(Ranks rank : ranksRepository.findAll()) {
				ranksList.add(rank);
			}
			
			return ranksList;
		}
		
		public void saveRank(Ranks ranks) {
			ranksRepository.save(ranks);
		}
		
		public void deleteRank(int id) {
			ranksRepository.delete(id);
		}
		
		public Ranks findOneRank(int id) {
			return ranksRepository.findOne(id);
		}
		
		
		
		
}
