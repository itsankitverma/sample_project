package com.fedex.lacitd.cashcontrol.prestier.struts.form;
import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.OACDetailsTableVO;
/**
 * Created by Reinaldo Alvarez.
 * User: ralvarez
 * Date: 14-07-2005
 * Time: 16:27:03 PM
 * Description:
 */
public class AddOACForm extends ActionForm implements java.io.Serializable{

  /** Holds value of property newOac. */
  private OACDetailsTableVO newOac = new OACDetailsTableVO();
  /** Holds value of property awbs list. */

  private Object[] awbs;

  private Object[] awbSelected;

  /** Holds value of property oac list. */
  private List oacList = ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new OACDetailsTableVO();
                                                                           }
                                                                       } );
    private String locationCd;
    private String courier;
    private String currencyCd;

    private Collection currencySupported;

    /** Creates a new instance of AddOACForm */
  public AddOACForm() {

  }

  public void setOacList(List oacList){
        this.oacList = oacList;
  }

  public List getOacList(){
        return oacList;
  }

  public void setNewOac(OACDetailsTableVO newOac){
      this.newOac = newOac;
  }

  public OACDetailsTableVO getNewOac(){
     return newOac;
  }

  public void setAwbs(Object[] awbs){
      this.awbs = awbs;
  }

  public Object[] getAwbs(){
        return awbs;
  }

    public String getLocationCd() {
        return locationCd;
    }

    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    public Object[] getAwbSelected() {
        return awbSelected;
    }

    public void setAwbSelected(Object[] awbSelected) {
        this.awbSelected = awbSelected;
    }

    public Collection getCurrencySupported() {
        return currencySupported;
    }

    public void setCurrencySupported(Collection currencySupported) {
        this.currencySupported = currencySupported;
    }
}
