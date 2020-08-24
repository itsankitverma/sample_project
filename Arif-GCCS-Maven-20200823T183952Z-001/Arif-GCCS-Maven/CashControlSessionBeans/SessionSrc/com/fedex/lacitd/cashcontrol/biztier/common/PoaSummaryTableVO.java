package com.fedex.lacitd.cashcontrol.biztier.common;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaPaymentVO;

/**
 * @author ccardenas
 */
public class PoaSummaryTableVO extends PoaPaymentVO implements java.io.Serializable {
    private boolean selected;

    /**
     * @return Returns the selected.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected The selected to set.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
