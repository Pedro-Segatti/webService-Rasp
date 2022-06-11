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

/**
 *
 * @author Segatti
 */
@ViewScoped
@Named
public class MonitoramentoBean implements Serializable {

    @EJB
    private CrudService crudService;

    private List<RaspEquipamento> raspEquip = new ArrayList<>();
    private RaspEquipamento raspEquipSelecionado;
    private RaspMonitoramento raspMon = new RaspMonitoramento();

    @PostConstruct
    public void init() {
        raspEquip = getEquipamentosDisp();
        if (raspEquip != null && !raspEquip.isEmpty()) {
            raspEquipSelecionado = raspEquip.get(0);
        }
    }

    public void attInfosRasp() {
        if (this.raspEquipSelecionado != null) {
            this.raspMon = crudService.getUltimoRegistroMonitoramento(this.raspEquipSelecionado);
            crudService.deletaRegistrosAntigos();
        }
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

    public Integer getPorcentagemUtilizacaoRam() {
        if (raspMon.getMonInfoRamDisp() == null || raspMon.getMonInfoRamUtilizada() == null) {
            return 0;
        }

        Double memoriaTotal = Double.parseDouble(raspMon.getMonInfoRamDisp()) + Double.parseDouble(raspMon.getMonInfoRamUtilizada());

        return (int) (100 * Double.parseDouble(raspMon.getMonInfoRamUtilizada()) / memoriaTotal);
    }

    public Integer getPorcentagemRamDisponivel() {
        if (raspMon.getMonInfoRamDisp() == null || raspMon.getMonInfoRamUtilizada() == null) {
            return 0;
        }

        Double memoriaTotal = Double.parseDouble(raspMon.getMonInfoRamDisp()) + Double.parseDouble(raspMon.getMonInfoRamUtilizada());

        return (int) (100 * Double.parseDouble(raspMon.getMonInfoRamDisp()) / memoriaTotal);
    }

    public Integer getPorcentagemUtilizacaoDisco() {
        if (raspMon.getMonInfoDiscoDisp() == null || raspMon.getMonInfoDiscoUtilizado() == null) {
            return 0;
        }

        Double discoTotal = Double.parseDouble(raspMon.getMonInfoDiscoDisp()) + Double.parseDouble(raspMon.getMonInfoDiscoUtilizado());
        return (int) (100 * Double.parseDouble(raspMon.getMonInfoDiscoUtilizado()) / discoTotal);
    }

    public Integer getPorcentagemDiscoDisponivel() {
        if (raspMon.getMonInfoDiscoDisp() == null || raspMon.getMonInfoDiscoUtilizado() == null) {
            return 0;
        }

        Double discoTotal = Double.parseDouble(raspMon.getMonInfoDiscoDisp()) + Double.parseDouble(raspMon.getMonInfoDiscoUtilizado());
        return (int) (100 * Double.parseDouble(raspMon.getMonInfoDiscoDisp()) / discoTotal);
    }
}
