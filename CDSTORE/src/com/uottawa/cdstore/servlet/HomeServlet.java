package com.uottawa.cdstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.uottawa.cdstore.dao.CdDriveDao;
import com.uottawa.cdstore.model.CdDrive;
import com.uottawa.cdstore.model.PurchaseOrder;
import com.uottawa.cdstore.model.PurchaseOrderItem;
import com.uottawa.cdstore.service.CdService;
import com.uottawa.cdstore.util.HibernateUtil;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HomeServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		CdDriveDao cdDriveDao = new CdDriveDao(session);
		CdService cdService = new CdService(cdDriveDao);

		List<CdDrive> cdDriveList = cdService.getCdDriveList();

		for (CdDrive cdDrive : cdDriveList) {
			for (PurchaseOrderItem purchaseOrderItem : cdDrive
					.getPurchaseOrderItem()) {
				PurchaseOrder purchaseOrder = purchaseOrderItem.getPoId()
						.getPurchaseOrder();
				System.out
						.println(" Lastname : " + purchaseOrder.getLastName());
			}
		}

		session.close();
		request.setAttribute("cdDriveList", cdDriveList);

		this.getServletContext().getRequestDispatcher("/index.jsp")
				.include(request, response);
	}

}
