package com.fedex.lacitd.cashcontrol.datatier.dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.datatier.exception.DAOException;

/**
 * Created by Jorge Quiroz 03/05/08
 */
public class LocationDaoUtils {

    public static boolean existLocation(String locCD) throws DAOException
    {
        ArrayList usersProfiles = new ArrayList();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;        

        try {
            Hashtable prop=new Hashtable();

            InitialContext ic = new InitialContext();

            DataSource ds = (DataSource) ic.lookup(Constants.CCSDataSource);

            conn = ds.getConnection();

            ps = conn.prepareStatement("SELECT count(1) FROM LOCATION WHERE LOC_CD = '" + locCD + "'");

            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

            return false;

        } catch (Exception e)
        {
            throw new DAOException(e.getMessage(), e);
        }
        finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
            }

            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
            
            ps = null;
            conn = null;
        }
    }
}
