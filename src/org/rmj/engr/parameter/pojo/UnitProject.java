/**
 * @author  Michael Cuison
 */
package org.rmj.engr.parameter.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.rmj.appdriver.constants.RecordStatus;
import org.rmj.appdriver.iface.GEntity;

@Entity
@Table(name="Project")

public class UnitProject implements Serializable, GEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "sProjCode")
    private String sProjCode;
    
    @Column(name = "sProjDesc")
    private String sProjDesc;
    
    @Basic(optional = false)
    @Column(name = "dProjStrt")
    @Temporal(TemporalType.DATE)
    private Date dProjStrt;
    
    @Basic(optional = false)
    @Column(name = "dProjStop")
    @Temporal(TemporalType.DATE)
    private Date dProjStop;
    
    @Basic(optional = false)
    @Column(name = "dActlStrt")
    @Temporal(TemporalType.DATE)
    private Date dActlStrt;
    
    @Basic(optional = false)
    @Column(name = "dActlStop")
    @Temporal(TemporalType.DATE)
    private Date dActlStop;
    
    @Column(name = "sInChrgex")
    private String sInChrgex;
    
    @Column(name = "sContrtor")
    private String sContrtor;
    
    @Column(name = "cRecdStat")
    private String cRecdStat;
    
    @Column(name = "sModified")
    private String sModified;
    
    @Basic(optional = false)
    @Column(name = "dModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dModified;

    LinkedList laColumns = null;
    
    public UnitProject(){
        this.sProjCode = "";
        this.sProjDesc = "";
        this.sInChrgex = "";
        this.sContrtor = "";
        this.cRecdStat = RecordStatus.ACTIVE;
        this.sModified = "";
        
        laColumns = new LinkedList();
        laColumns.add("sProjCode");
        laColumns.add("sProjDesc");
        laColumns.add("dProjStrt");
        laColumns.add("dProjStop");
        laColumns.add("dActlStrt");
        laColumns.add("dActlStop");
        laColumns.add("sInChrgex");
        laColumns.add("sContrtor");
        laColumns.add("cRecdStat");
        laColumns.add("sModified");
        laColumns.add("dModified");
    }
    
    public void setProjectCode(String sProjCode){
        this.sProjCode = sProjCode;
    }
    public String getProjectCode(){
        return sProjCode;
    }
    
    public void setProjectName(String sProjDesc){
        this.sProjDesc = sProjDesc;
    }
    public String getProjectName(){
        return sProjDesc;
    }
    
    public void setEstStart(Date dProjStrt){
        this.dProjStrt = dProjStrt;
    }
    public Date getEstStart(){
        return dProjStrt;
    }
    
    public void setEstFinish(Date dProjStop){
        this.dProjStop = dProjStop;
    }
    public Date getEstFinish(){
        return dProjStop;
    }
    
    public void setActualStart(Date dActlStrt){
        this.dActlStrt = dActlStrt;
    }
    public Date getActualStart(){
        return dActlStrt;
    }
    
    public void setActualFinish(Date dActlStop){
        this.dActlStop = dActlStop;
    }
    public Date getActualFinish(){
        return dActlStop;
    }
    
    public void setInCharge(String sInChrgex){
        this.sInChrgex = sInChrgex;
    }
    public String getInCharge(){
        return sInChrgex;
    }
    
    public void setContractor(String sContrtor){
        this.sContrtor = sContrtor;
    }
    public String getContractor(){
        return sInChrgex;
    }
    
    public void setRecordStat(String cRecdStat){
        this.cRecdStat = cRecdStat;
    }
    public String getRecordStat(){
        return cRecdStat;
    }
    
    public void setModifiedBy(String sModified){
        this.sModified = sModified;
    }
    public String getModifiedBy(){
        return sModified;
    }
    
    public void setDateModified(Date dModified){
        this.dModified = dModified;
    }
    public Date getDateModified(){
        return dModified;
    }
    
    @Override
    public int hashCode(){
        int hash = 0;
        hash += (sProjCode != null ? sProjCode.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnitProject)) {
            return false;
        }
        UnitProject other = (UnitProject) object;
        if ((this.sProjCode == null && other.sProjCode != null) || (this.sProjCode != null && !this.sProjCode.equals(other.sProjCode))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "org.rmj.parameter.pojo.UnitProject[sProjCode=" + sProjCode + "]";
    }
    
    @Override
    public Object getValue(int fnColumn) {
        switch(fnColumn){
            case 1: return sProjCode;
            case 2: return sProjDesc;
            case 3: return dProjStrt;
            case 4: return dProjStop;
            case 5: return dActlStrt;
            case 6: return dActlStop;
            case 7: return sInChrgex;
            case 8: return sContrtor;
            case 9: return cRecdStat;
            case 10: return sModified;
            case 11: return dModified;
            default: return null;
        }
    }

    @Override
    public Object getValue(String fsColumn) {
        int lnCol = getColumn(fsColumn);
        
        if (lnCol > 0){
            return getValue(lnCol);
        } else
            return null;
    }

    @Override
    public String getTable() {
        return "Project";
    }

    @Override
    public String getColumn(int fnCol) {
        if (laColumns.size() < fnCol){
            return "";
        } else 
            return (String) laColumns.get(fnCol - 1);
    }

    @Override
    public int getColumn(String fsCol) {
        return laColumns.indexOf(fsCol) + 1;
    }

    @Override
    public void setValue(int fnColumn, Object foValue) {
        switch(fnColumn){
            case 1: sProjCode = (String) foValue; break;
            case 2: sProjDesc = (String) foValue; break;
            case 3: dProjStrt = (Date) foValue; break;
            case 4: dProjStop = (Date) foValue; break;
            case 5: dActlStrt = (Date) foValue; break;
            case 6: dActlStop = (Date) foValue; break;
            case 7: sInChrgex = (String) foValue; break;
            case 8: sContrtor = (String) foValue; break;
            case 9: cRecdStat = (String) foValue; break;
            case 10: sModified = (String) foValue; break;
            case 11: dModified = (Date) foValue; break;
        }    
    }

    @Override
    public void setValue(String fsColumn, Object foValue) {
        int lnCol = getColumn(fsColumn);
        if (lnCol > 0){
            setValue(lnCol, foValue);
        }
    }

    @Override
    public int getColumnCount() {
        return laColumns.size();
    }

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
