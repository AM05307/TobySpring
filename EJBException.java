package a01;

import java.rmi.RemoteException;
import java.sql.SQLException;
import javax.naming.NamingException;

public class EJBException {
	public void EJBExceptionTest() {
		try {
			OrderHome orderHome = EJBHomeFactory.getInstance().getOrderHome();
			Order order = orderHome.findByPrimaryKey(Integer id);
		} catch (NamingException ne) {
			throw new EJBException(ne);
		} catch (SQLException se) {
			throw new EJBException(se);
		} catch (RemoteException re) {
			throw new EJBException(re);
		}
	}
}
