package com.app12306.service.station;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.json.JSONObject;

import com.app12306.db.dac.StationDac;
import com.easyweb.core.EasyHttpServlet;
import com.easyweb.core.HttpReqResp;

@WebServlet(name = "com.app12306.service.station.StationList", urlPatterns = "/service/station/StationList")
public class StationList extends EasyHttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpReqResp hrr) throws ServletException, IOException {
		doPost(hrr);
	}

	@Override
	public void doPost(HttpReqResp hrr) throws ServletException, IOException {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("data", StationDac.getInstance().allStations());
			jsonObject.put("status", "success");
		} catch (Exception e) {
			jsonObject.put("status", "failure");
		}
		hrr.getResponse().getWriter().append(jsonObject.toString());
	}
}
