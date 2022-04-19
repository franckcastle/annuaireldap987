package pfe.annuaireldap.repo;

import org.springframework.data.ldap.repository.LdapRepository;
import pfe.annuaireldap.entities.Group;

public interface GroupRepo extends LdapRepository<Group> {
    Group findByCn(String username);
}
