package com.app12306.db.dac;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.app12306.db.DB;
import com.app12306.db.model.Station;

public class StationDac extends Dac {
	private static StationDac instance = null;

	private StationDac() {
	}

	public static StationDac getInstance() {
		if (instance == null)
			instance = new StationDac();
		return instance;
	}

	public List<Station> allStations() {
		List<Station> stationList = null;
		try {
			stationList = DB.getInstance().qr().query(getSql("allStations"), new BeanListHandler<>(Station.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stationList;
	}

	public boolean addStation(Station station) {
		try {
			return 1 == DB.getInstance().qr().update(getSql("addStation"), station.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delStation(String name) {
		try {
			return 1 == DB.getInstance().qr().update(getSql("delStation"), name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
