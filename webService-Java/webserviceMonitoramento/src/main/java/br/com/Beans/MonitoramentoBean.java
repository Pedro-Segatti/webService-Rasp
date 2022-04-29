package br.com.Beans;

import br.com.ConexaoBD.CrudService;
import br.com.mapeamento.RaspEquipamento;
import br.com.mapeamento.RaspMonitoramento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author Segatti
 */
@ViewScoped
@Named
public class MonitoramentoBean implements Serializable {

    @EJB
    private CrudService crudService;

    private DashboardModel dashModel;

    private List<RaspEquipamento> raspEquip = new ArrayList<>();
    private RaspEquipamento raspEquipSelecionado;
    private RaspMonitoramento raspMon = new RaspMonitoramento();

    @PostConstruct
    public void init() {
        raspEquip = getEquipamentosDisp();
        if (raspEquip != null && !raspEquip.isEmpty()) {
            raspEquipSelecionado = raspEquip.get(0);
        }
        criaModel();
    }

    public void attInfosRasp() {
        if (this.raspEquipSelecionado != null) {
            this.raspMon = crudService.getUltimoRegistroMonitoramento(this.raspEquipSelecionado);
        }
    }

    private void criaModel() {
        dashModel = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();

        System.out.println(column3.getStyle());
        
        column1.addWidget("ramDisp");
        column1.addWidget("cpuDisp");
        column1.addWidget("discoDisp");

        column2.addWidget("ramUtil");
        column2.addWidget("cpuUtil");
        column2.addWidget("discoUtil");

        column3.addWidget("qntdProcess");
        column3.addWidget("conectadoRede");
        column3.addWidget("temperatura");

        dashModel.addColumn(column1);
        dashModel.addColumn(column2);
        dashModel.addColumn(column3);
    }
    
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private List<RaspEquipamento> getEquipamentosDisp() {
        return crudService.getEquipmentos();
    }

    public RaspMonitoramento getRaspMon() {
        return raspMon;
    }

    public DashboardModel getDashModel() {
        return dashModel;
    }

    public void setDashModel(DashboardModel dashModel) {
        this.dashModel = dashModel;
    }
}
