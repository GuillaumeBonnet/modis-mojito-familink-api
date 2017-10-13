package org.gestion.services.impl;

import java.util.List;

import org.gestion.entite.Groupe;
import org.gestion.repository.ContactRepository;
import org.gestion.repository.GroupeRepository;
import org.gestion.repository.UserRepository;
import org.gestion.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thomasportier
 */
@Service(value= "groupeServiceRepository")
public class GroupeServiceRepository implements IGroupeService {
	
	@Autowired
	private GroupeRepository groupeRepository;

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Groupe create(Groupe nouveauGroupe, Integer id) {
		nouveauGroupe.setOwner(userRepository.findOne(id));
		return groupeRepository.save(nouveauGroupe);
	}

	@Override
	public void update(Groupe groupe) {
		final Groupe toUpdate = groupeRepository.findOne(groupe.getId());
		
		if (toUpdate != null) {
			toUpdate.setName(groupe.getName());

			groupeRepository.save(toUpdate);
		}

	}

	@Override
	public List<Groupe> getGroupes() {
		return groupeRepository.findAll();
	}

	@Override
	public Groupe getGroupeById(int id) {
		return groupeRepository.findOne(id);
	}

	@Override
	public void deleteGroupe(int id) {
		groupeRepository.delete(id);

	}

}
