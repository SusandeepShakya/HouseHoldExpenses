public class Tenant {

    private String TenantName;
    private int ID;

    public Tenant(){};

    public Tenant(int id, String tenantName){
    }



    public int getID() {
        return ID;
    }
    public void setID(int id) {
        ID = id;
    }

    public String getTenantName() {
        return TenantName;
    }
    public void setTenantName(String tenantName) {
        TenantName = tenantName;
    }
}
