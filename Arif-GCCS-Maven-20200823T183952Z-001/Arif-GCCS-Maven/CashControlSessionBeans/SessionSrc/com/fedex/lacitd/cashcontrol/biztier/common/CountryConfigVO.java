package com.fedex.lacitd.cashcontrol.biztier.common;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryCurrencyVO;

/**
 * Created by IntelliJ IDEA.
 * User: ccardenas
 * Date: Jan 26, 2005
 * Time: 11:03:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class CountryConfigVO extends CountryCurrencyVO {
    public int getDtrcUpldFlg() {
        return dtrcUpldFlg;
    }

    public void setDtrcUpldFlg(int dtrcUpldFlg) {
        this.dtrcUpldFlg = dtrcUpldFlg;
    }

    public int getCashUpldFlg() {
        return cashUpldFlg;
    }

    public void setCashUpldFlg(int cashUpldFlg) {
        this.cashUpldFlg = cashUpldFlg;
    }

    public int getWoffUpldFlg() {
        return woffUpldFlg;
    }

    public void setWoffUpldFlg(int woffUpldFlg) {
        this.woffUpldFlg = woffUpldFlg;
    }

    private int dtrcUpldFlg;

    private int cashUpldFlg;

    private int woffUpldFlg;

    public String getPsOperId() {
        return psOperId;
    }

    public void setPsOperId(String psOperId) {
        this.psOperId = psOperId;
    }

    private String psOperId;
}
