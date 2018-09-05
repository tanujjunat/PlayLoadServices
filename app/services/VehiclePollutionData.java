package services;

import java.io.Serializable;

public class VehiclePollutionData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4376503048167363598L;
	
	public String _id;
	
	public String APIKey;
	
	public String DateTime;
	
	public String CO_gas;
	
	public String CO2;
	
	public String NOX;
	
	public String NH4;
	
	public String C6H6;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAPIKey() {
		return APIKey;
	}

	public void setAPIKey(String aPIKey) {
		APIKey = aPIKey;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

	public String getCO_gas() {
		return CO_gas;
	}

	public void setCO_gas(String cO_gas) {
		CO_gas = cO_gas;
	}

	public String getCO2() {
		return CO2;
	}

	public void setCO2(String cO2) {
		CO2 = cO2;
	}

	public String getNOX() {
		return NOX;
	}

	public void setNOX(String nOX) {
		NOX = nOX;
	}

	public String getNH4() {
		return NH4;
	}

	public void setNH4(String nH4) {
		NH4 = nH4;
	}

	public String getC6H6() {
		return C6H6;
	}

	public void setC6H6(String c6h6) {
		C6H6 = c6h6;
	}

}
