/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConexaoBD;

import br.com.mapeamento.RaspEquipamento;
import br.com.mapeamento.RaspMonitoramento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Segatti
 */
public abstract class ConexaoBd implements Serializable {

    public abstract EntityManager getEntityManager();

    public void commitState() {
        getEntityManager().flush();
    }

    public <T> T salvar(T t) {
        t = getEntityManager().merge(t);
        commitState();
        return t;
    }

    public <T> T procurar(Class classe) {
        return (T) getEntityManager().find(classe, 1);
    }

    public void deletaRegistrosAntigos() {
        getEntityManager().createNativeQuery("DELETE FROM RASP_MONITORAMENTO WHERE MON_DATA_INFO <= DATE_SUB(DATE(NOW()), INTERVAL 10 DAY)").executeUpdate();
    }

    public RaspMonitoramento getUltimoRegistroMonitoramento(RaspEquipamento equip) {
        return (RaspMonitoramento) getEntityManager().createNativeQuery("SELECT * FROM RASP_MONITORAMENTO WHERE MON_COD_RASP = " + equip.getEqpId() + " ORDER BY MON_ID DESC limit 1;", RaspMonitoramento.class).getSingleResult();
    }
    
    public List<RaspEquipamento> getEquipmentos() {
        return getEntityManager().createNativeQuery("SELECT * FROM RASP_EQUIPAMENTO", RaspEquipamento.class).getResultList();
    }

    public <T> T procurar(Class classe, Object id) {
        return (T) getEntityManager().find(classe, id);
    }

    public void criarParametros(Object[] parametros, Query sql) {
        int i = 0;
        for (Object parametro : parametros) {
            sql.setParameter(++i, parametro);
        }
    }

    private Query criaSqlNativa(String sqlQuery, Object[] parametros) {
        Query query = getEntityManager().createNativeQuery(sqlQuery);
        criarParametros(parametros, query);
        return query;
    }

    public <T> List<T> executarSqlNativa(String sql, Object... parametros) {
        Query query = criaSqlNativa(sql, parametros);
        return query.getResultList();
    }

    public void deletar(Object objDeletar) {
        getEntityManager().remove(getEntityManager().merge(objDeletar));
        commitState();
    }
}
