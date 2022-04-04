package br.com.ConexaoBD;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Segatti
 */
@Stateless
@LocalBean
public class CrudService extends ConexaoBd{
    
    @PersistenceContext(unitName = "database")
    private EntityManager entityManager;
    
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
