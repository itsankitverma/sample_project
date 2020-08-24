package com.fedex.lacitd.cashcontrol.prestier.struts.form;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAdminVO;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAcctAdminVO;

import java.util.Collection;

/**
 * Add receivable screen form class
 * @author  ccardenas
 */
public class EntitiesAcctAdminForm extends ActionForm implements java.io.Serializable{
    public EntityAcctAdminVO getEntityAcct() {
        return entityAcct;
    }

    public void setEntityAcct(EntityAcctAdminVO entityAcct) {
        this.entityAcct = entityAcct;
    }

    private EntityAcctAdminVO entityAcct=new EntityAcctAdminVO();


    public Collection getEntities() {
        return entities;
    }

    public void setEntities(Collection entities) {
        this.entities = entities;
    }

    private Collection entities;

    public Collection getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection accounts) {
        this.accounts = accounts;
    }

    private Collection accounts;
}
