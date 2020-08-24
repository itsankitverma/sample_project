package com.examples;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtilsBean;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import javax.naming.*;


/**
 *
 * @author  ccardenas
 */
public class UpdateUsersUtil {

    /** Creates a new instance of DTRCUpload */
    public UpdateUsersUtil() {
    }

    /**
     * @param args the command line arguments
     */
public static void main(String[] args)throws Exception
{
    SystemUtilsBean sub=new SystemUtilsBean();

    Iterator emps=getEmployees().iterator();

    while(emps.hasNext()){
        String empid=(String)emps.next();
        System.out.println("FROM DB " + empid);
        EmployeeVO empVO=sub.findFedExEmployee(empid);

        if(empVO==null){
            System.out.println(empid+" DOES NOT EXIST");
        }else{
            updateEmployee(empVO);
        }
    }
    System.out.println("WORK DONE.");
}

public static Collection getEmployees(){
      CallableStatement cs      =   null;
      Connection conn           =   null;
      ResultSet  rs             =   null;
      Collection col=new ArrayList();
      try{
            Hashtable env = new Hashtable(11);
            env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            //env.put(Context.PROVIDER_URL, "t3://161.135.144.222:7001");
            env.put(Context.PROVIDER_URL, "t3://gccsapp.prod.fedex.com:9999");
            InitialContext ic = new InitialContext(env);
            DataSource ds=(DataSource)ic.lookup("jdbc/CashControlDS");

            conn=ds.getConnection();
            cs=conn.prepareCall("SELECT EMP_ID_NBR FROM EMPLOYEE WHERE UPPER(EMP_NM) LIKE '%UNKNOWN%'");
            rs=cs.executeQuery();

            while(rs.next()){
                col.add(rs.getString(1));
            }


      }catch(Exception e){
            e.printStackTrace();
      }finally{
            try{
                if (cs!=null) cs.close();
            }catch(Exception e){}
            try{
                if (conn!=null) conn.close();
            }catch(Exception e){}

           cs   = null;
           conn = null;
        }
        return col;
    }


public static void updateEmployee(EmployeeVO employee){
      CallableStatement cs      =   null;
      Connection conn           =   null;
      ResultSet  rs             =   null;

      try{
            Hashtable env = new Hashtable(11);
            env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            //env.put(Context.PROVIDER_URL, "t3://161.135.144.222:7001");
            env.put(Context.PROVIDER_URL, "t3://gccsapp.prod.fedex.com:9999");
            InitialContext ic = new InitialContext(env);
             DataSource ds=(DataSource)ic.lookup("jdbc/CashControlDS");
            conn=ds.getConnection();
            cs=conn.prepareCall("UPDATE EMPLOYEE SET EMP_NM=?,EMAIL_DESC=? WHERE EMP_ID_NBR=?");
            System.out.println("TO DB "+employee.getEmployeeId());
            cs.setString(1,employee.getEmployeeNm());
            cs.setString(2,employee.getEmail());
            cs.setString(3,employee.getEmployeeId());
            cs.execute();

      }catch(Exception e){
            e.printStackTrace();
      }finally{
            try{
                if (cs!=null) cs.close();
            }catch(Exception e){}
            try{
                if (conn!=null) conn.close();
            }catch(Exception e){}

           cs   = null;
           conn = null;
        }
    }
}