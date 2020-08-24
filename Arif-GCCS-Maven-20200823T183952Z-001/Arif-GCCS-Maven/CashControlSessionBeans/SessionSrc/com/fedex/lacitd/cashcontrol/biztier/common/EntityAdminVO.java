package com.fedex.lacitd.cashcontrol.biztier.common;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: ccardenas
 * Date: Mar 31, 2005
 * Time: 12:26:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityAdminVO implements Serializable {
	
	private String entCd;
    private Collection locations;
    private String cntryCd;
    private String regionCd;
    private String subRegionCd;
    private String nerCd;
    private String glEntCd;
    private String glCurrCd;
    private int dtrcUpldActFlg;
    private String psOprEmpId;
    private int poaUpldOceanFlg;
    private String rihEntCd;

    /*
     * Added new Fields
     * Author : Kapil
     */
    private int rodUpldActFlg;
    private int prpUpldActFlg;
    private int grdUpldActFlg;
    private int othUpldActFlg;
    private int ftcUpldActFlg;
    private String paymentAccountNbr;
    
	
    public void setRihEntCd(String rihEntCd) {
        this.rihEntCd = rihEntCd;
    }

    public int getPoaUpldOceanFlg() {
        return poaUpldOceanFlg;
    }

    public void setPoaUpldOceanFlg(int poaUpldOceanFlg) {
        this.poaUpldOceanFlg = poaUpldOceanFlg;
    }


    public String getEntCd() {
        return entCd;
    }

    public void setEntCd(String entCd) {
        this.entCd = entCd;
    }

    public Collection getLocations() {
        return locations;
    }

    public void setLocations(Collection locations) {
        this.locations = locations;
    }

    public String getCntryCd() {
        return cntryCd;
    }

    public void setCntryCd(String cntryCd) {
        this.cntryCd = cntryCd;
    }

    public String getRegionCd() {
        return regionCd;
    }

    public void setRegionCd(String regionCd) {
        this.regionCd = regionCd;
    }

    public String getSubRegionCd() {
        return subRegionCd;
    }

    public void setSubRegionCd(String subRegionCd) {
        this.subRegionCd = subRegionCd;
    }

    public String getNerCd() {
        return nerCd;
    }

    public void setNerCd(String nerCd) {
        this.nerCd = nerCd;
    }

    public String getGlEntCd() {
        return glEntCd;
    }

    public void setGlEntCd(String glEntCd) {
        this.glEntCd = glEntCd;
    }

    public String getGlCurrCd() {
        return glCurrCd;
    }

    public void setGlCurrCd(String glCurrCd) {
        this.glCurrCd = glCurrCd;
    }

    public int getDtrcUpldActFlg() {
        return dtrcUpldActFlg;
    }

    public void setDtrcUpldActFlg(int dtrcUpldActFlg) {
        this.dtrcUpldActFlg = dtrcUpldActFlg;
    }

    public String getPsOprEmpId() {
        return psOprEmpId;
    }

    public void setPsOprEmpId(String psOprEmpId) {
        this.psOprEmpId = psOprEmpId;
    }

    public String getRihEntCd() {
        return rihEntCd;
    }

    /*
     * Added new Fields
     * Author : Kapil
     */
	public int getRodUpldActFlg() {
		return rodUpldActFlg;
	}

	public void setRodUpldActFlg(int rodUpldActFlg) {
		this.rodUpldActFlg = rodUpldActFlg;
	}

	public int getPrpUpldActFlg() {
		return prpUpldActFlg;
	}

	public void setPrpUpldActFlg(int prpUpldActFlg) {
		this.prpUpldActFlg = prpUpldActFlg;
	}

	public int getGrdUpldActFlg() {
		return grdUpldActFlg;
	}

	public void setGrdUpldActFlg(int grdUpldActFlg) {
		this.grdUpldActFlg = grdUpldActFlg;
	}

	public int getOthUpldActFlg() {
		return othUpldActFlg;
	}

	public void setOthUpldActFlg(int othUpldActFlg) {
		this.othUpldActFlg = othUpldActFlg;
	}

	public int getFtcUpldActFlg() {
		return ftcUpldActFlg;
	}

	public void setFtcUpldActFlg(int ftcUpldActFlg) {
		this.ftcUpldActFlg = ftcUpldActFlg;
	}

	public String getPaymentAccountNbr() {
		return paymentAccountNbr;
	}

	public void setPaymentAccountNbr(String paymentAccountNbr) {
		this.paymentAccountNbr = paymentAccountNbr;
	}

}
