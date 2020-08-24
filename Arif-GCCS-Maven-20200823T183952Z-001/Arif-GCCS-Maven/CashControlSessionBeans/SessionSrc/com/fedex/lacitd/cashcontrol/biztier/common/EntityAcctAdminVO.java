package com.fedex.lacitd.cashcontrol.biztier.common;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ccardenas
 * Date: Mar 31, 2005
 * Time: 12:26:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityAcctAdminVO implements Serializable {
    private String entCd;

    public String getEntCd() {
        return entCd;
    }

    public void setEntCd(String entCd) {
        this.entCd = entCd;
    }

    public int getBankAccCd() {
        return bankAccCd;
    }

    public void setBankAccCd(int bankAccCd) {
        this.bankAccCd = bankAccCd;
    }

    public String getDepLocCurrAccNbr() {
        return depLocCurrAccNbr;
    }

    public void setDepLocCurrAccNbr(String depLocCurrAccNbr) {
        this.depLocCurrAccNbr = depLocCurrAccNbr;
    }

    public String getDepUsdCurrAccNbr() {
        return depUsdCurrAccNbr;
    }

    public void setDepUsdCurrAccNbr(String depUsdCurrAccNbr) {
        this.depUsdCurrAccNbr = depUsdCurrAccNbr;
    }

    public String getCostCenterNbr() {
        return costCenterNbr;
    }

    public void setCostCenterNbr(String costCenterNbr) {
        this.costCenterNbr = costCenterNbr;
    }

    public String getRodAccNbr() {
        return rodAccNbr;
    }

    public void setRodAccNbr(String rodAccNbr) {
        this.rodAccNbr = rodAccNbr;
    }

    public String getPrpAccNbr() {
        return prpAccNbr;
    }

    public void setPrpAccNbr(String prpAccNbr) {
        this.prpAccNbr = prpAccNbr;
    }

    public String getPoaAccNbr() {
        return poaAccNbr;
    }

    public void setPoaAccNbr(String poaAccNbr) {
        this.poaAccNbr = poaAccNbr;
    }

    public String getWoffRodDbtAccNbr() {
        return woffRodDbtAccNbr;
    }

    public void setWoffRodDbtAccNbr(String woffRodDbtAccNbr) {
        this.woffRodDbtAccNbr = woffRodDbtAccNbr;
    }

    public String getWoffPrpDbtAccNbr() {
        return woffPrpDbtAccNbr;
    }

    public void setWoffPrpDbtAccNbr(String woffPrpDbtAccNbr) {
        this.woffPrpDbtAccNbr = woffPrpDbtAccNbr;
    }

    public String getWoffCrdtAccNbr() {
        return woffCrdtAccNbr;
    }

    public void setWoffCrdtAccNbr(String woffCrdtAccNbr) {
        this.woffCrdtAccNbr = woffCrdtAccNbr;
    }

    public int getPsCashActFlg() {
        return psCashActFlg;
    }

    public void setPsCashActFlg(int psCashActFlg) {
        this.psCashActFlg = psCashActFlg;
    }

    public int getPsWoffActFlg() {
        return psWoffActFlg;
    }

    public void setPsWoffActFlg(int psWoffActFlg) {
        this.psWoffActFlg = psWoffActFlg;
    }

    private int bankAccCd;
    private String depLocCurrAccNbr;
    private String depUsdCurrAccNbr;
    private String costCenterNbr;
    private String rodAccNbr;
    private String prpAccNbr;
    private String poaAccNbr;
    private String woffRodDbtAccNbr;
    private String woffPrpDbtAccNbr;
    private String woffCrdtAccNbr;
    private int psCashActFlg;
    private int psWoffActFlg;


}
