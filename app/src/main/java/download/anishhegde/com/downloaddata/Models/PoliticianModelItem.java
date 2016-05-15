package download.anishhegde.com.downloaddata.Models;

/**
 * Created by anishhegde on 08/05/16.
 */
public class PoliticianModelItem {
      /*  ========================================================

         { "results": [{"name": "Pete Aguilar",
            "party": "D",
            "state": "CA",
            "district": "31",
            "phone": "202-225-3201",
            "office": "1223 Longworth House Office Building",
            "link": "https://aguilar.house.gov" },.....]}

        ======================================================== */

    private String name;
    private String party;
    private String state;
    private String district;
    private String phone;
    private String office;
    private String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
